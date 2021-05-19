package xyz.aiinirii.carboninfosys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.aiinirii.carboninfosys.common.api.CommonResult;
import xyz.aiinirii.carboninfosys.domain.*;
import xyz.aiinirii.carboninfosys.model.User;
import xyz.aiinirii.carboninfosys.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * 关于用户的Controller类
 *
 * @author AIINIRII
 */
@RestController
@RequestMapping("/sso")
@Api(value = "UserController", tags = {"用户账号有关操作"})
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public CommonResult<User> register(@Validated @RequestBody UserRegisterParam userRegisterParam, BindingResult bindingResult) {
        LOGGER.info("register user: " + userRegisterParam);
        User register = userService.register(userRegisterParam);
        return CommonResult.success(register, "注册成功");
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public CommonResult<TokenParam> login(@Validated @RequestBody UserLoginParam memberLoginParam, BindingResult bindingResult) {
        LOGGER.info("login user: " + memberLoginParam);
        String token = userService.login(memberLoginParam.getUsername(), memberLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        TokenParam tokenMap = new TokenParam();
        tokenMap.setToken(token);
        tokenMap.setTokenHead(tokenHead);
        return CommonResult.success(tokenMap, "登录成功");
    }

    @ApiOperation("修改密码")
    @PostMapping("/updatePassword")
    public CommonResult<?> updatePassword(@Validated @RequestBody UpdateMemberPasswordParam memberPasswordParam, BindingResult bindingResult) {

        if (userService.updatePassword(memberPasswordParam) == 1) {
            return CommonResult.success(null, "密码修改成功");
        } else {
            return CommonResult.failed("密码修改失败");
        }

    }

    @ApiOperation("刷新Token")
    @PostMapping("/refreshToken")
    public CommonResult<TokenParam> refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = userService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token令牌已过期");
        }
        TokenParam tokenParam = new TokenParam();
        tokenParam.setToken(refreshToken);
        tokenParam.setTokenHead(tokenHead);
        return CommonResult.success(tokenParam, "成功更新token");
    }

    @ApiOperation("获取目前用户信息")
    @GetMapping("/basicInfo")
    public CommonResult<User> getBasicInfo(Principal principal) {
        String username = principal.getName();
        if (username != null) {
            User umsMember = userService.getMemberByUsername(username);
            umsMember.setPassword(null);
            return CommonResult.success(umsMember);
        } else {
            return CommonResult.unauthorized(null);
        }
    }

    @ApiOperation("删除用户")
    @PostMapping("/delete")
    public CommonResult<?> deleteUser(Principal principal) {
        String username = principal.getName();
        if (username != null) {
            User umsMember = userService.getMemberByUsername(username);
            int delete = userService.delete(umsMember.getId());
            return delete == 1 ? CommonResult.success(null) : CommonResult.failed("can not verify the identity, delete failed");
        }
        return CommonResult.failed("删除用户失败");
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public CommonResult<?> updateUser(@Validated @RequestBody UserUpdateParam umsMemberParam,
                                      BindingResult bindingResult,
                                      Principal principal) {
        String username = principal.getName();
        LOGGER.info("ready to update username: {}", username);
        if (username != null) {
            User user = userService.getMemberByUsername(username);

            user.setUsername(umsMemberParam.getUsername());
            user.setEmail(umsMemberParam.getEmail());
            LOGGER.info("update user: {}", user);
            int update = userService.update(user);
            if (update == 1) {
                return CommonResult.success(null, "更新用户信息成功");
            } else {
                return CommonResult.failed("更新用户信息失败");
            }
        }
        return CommonResult.failed("更新用户信息失败");
    }
}