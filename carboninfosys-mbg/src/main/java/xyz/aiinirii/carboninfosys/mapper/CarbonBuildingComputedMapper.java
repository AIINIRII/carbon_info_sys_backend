package xyz.aiinirii.carboninfosys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.aiinirii.carboninfosys.model.CarbonBuildingComputed;
import xyz.aiinirii.carboninfosys.model.CarbonBuildingComputedExample;

public interface CarbonBuildingComputedMapper {
    long countByExample(CarbonBuildingComputedExample example);

    int deleteByExample(CarbonBuildingComputedExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CarbonBuildingComputed record);

    int insertSelective(CarbonBuildingComputed record);

    List<CarbonBuildingComputed> selectByExample(CarbonBuildingComputedExample example);

    CarbonBuildingComputed selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CarbonBuildingComputed record, @Param("example") CarbonBuildingComputedExample example);

    int updateByExample(@Param("record") CarbonBuildingComputed record, @Param("example") CarbonBuildingComputedExample example);

    int updateByPrimaryKeySelective(CarbonBuildingComputed record);

    int updateByPrimaryKey(CarbonBuildingComputed record);
}