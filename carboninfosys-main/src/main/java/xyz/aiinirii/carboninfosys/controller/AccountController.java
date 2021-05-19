package xyz.aiinirii.carboninfosys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import xyz.aiinirii.carboninfosys.common.api.CommonPage;
import xyz.aiinirii.carboninfosys.common.api.CommonResult;
import xyz.aiinirii.carboninfosys.domain.PasswordParam;
import xyz.aiinirii.carboninfosys.model.User;
import xyz.aiinirii.carboninfosys.service.UserService;

/**
 * @author AIINIRII
 */
@RestController
@RequestMapping("/account")
@Api(value = "AccountController", tags = {"(管理员专属)账号管理有关操作"})
@PreAuthorize("hasAuthority('ADMINISTRATOR')")
public class AccountController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("根据页数获取当前用户列表")
    @GetMapping("/user")
    public CommonResult<CommonPage<User>> getUsersByPageNum(@RequestParam int pageNum, @RequestParam int pageSize) {
        return CommonResult.success(CommonPage.restPage(userService.getUsersByPageNum(pageNum, pageSize)));
    }

    @ApiOperation("更改用户的密码")
    @PostMapping("/user/{id}")
    public CommonResult<?> changeUserPassword(@PathVariable("id") Long userId, @RequestBody PasswordParam passwordParam) {
        boolean changeUserPasswordSuccessfully = userService.changeUserPassword(userId, passwordParam.getPassword());
        if (changeUserPasswordSuccessfully) {
            return CommonResult.success(null, "密码修改成功");
        } else {
            return CommonResult.failed("密码修改失败");
        }
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/user/{id}")
    public CommonResult<?> deleteUser(@PathVariable("id") Long userId) {
        int delete = userService.delete(userId);
        if (delete == 1) {
            return CommonResult.success(null, "删除成功");
        } else {
            return CommonResult.failed("删除失败");
        }
    }

    @ApiOperation("更新用户状态")
    @PutMapping("/user/status/{id}")
    public CommonResult<?> updateUserStatus(@PathVariable("id") Long userId, @RequestParam int isEnable) {
        if (isEnable == 1 || isEnable == 0) {
            int update = userService.updateUserStatus(userId, (byte) isEnable);
            if (update == 1) {
                return CommonResult.success(null, "更新用户状态成功");
            }
        }
        return CommonResult.failed("更新用户状态失败");
    }
}