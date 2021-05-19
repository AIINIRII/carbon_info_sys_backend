package xyz.aiinirii.carboninfosys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.aiinirii.carboninfosys.common.api.CommonResult;
import xyz.aiinirii.carboninfosys.model.BuildingGroup;
import xyz.aiinirii.carboninfosys.service.BuildingGroupService;

import java.util.List;

/**
 * @author AIINIRII
 */
@RestController
@RequestMapping("/buildingGroup")
@Api(value = "BuildingGroupController", tags = {"建筑群相关操作"})
public class BuildingGroupController {
    private BuildingGroupService buildingGroupService;

    @Autowired
    public void setBuildingGroupService(BuildingGroupService buildingGroupService) {
        this.buildingGroupService = buildingGroupService;
    }

    @GetMapping("")
    @ApiOperation("获取所有建筑群的信息")
    public CommonResult<List<BuildingGroup>> getAllBuildingGroups() {
        return CommonResult.success(buildingGroupService.getAllBuildingGroups());
    }

}