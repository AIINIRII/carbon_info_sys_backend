package xyz.aiinirii.carboninfosys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.aiinirii.carboninfosys.common.api.CommonResult;
import xyz.aiinirii.carboninfosys.service.BuildingKeyService;

import java.security.Principal;

/**
 * @author AIINIRII
 */
@RestController
@RequestMapping("/buildingKey")
@Api(value = "BuildingKeyController", tags = {"建筑key相关操作"})
public class BuildingKeyController {
    private BuildingKeyService buildingKeyService;

    @Autowired
    public void setBuildingKeyService(BuildingKeyService buildingKeyService) {
        this.buildingKeyService = buildingKeyService;
    }

    @GetMapping("/{buildingId}")
    @ApiOperation("获取某一建筑的key")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public CommonResult<String> getKeyByBuildingId(@PathVariable("buildingId") Long buildingId) {
        return CommonResult.success(buildingKeyService.getBuildingKey(buildingId));
    }
}