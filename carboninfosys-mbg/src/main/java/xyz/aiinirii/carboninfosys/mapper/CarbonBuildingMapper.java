package xyz.aiinirii.carboninfosys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.aiinirii.carboninfosys.model.CarbonBuilding;
import xyz.aiinirii.carboninfosys.model.CarbonBuildingExample;

public interface CarbonBuildingMapper {
    long countByExample(CarbonBuildingExample example);

    int deleteByExample(CarbonBuildingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CarbonBuilding record);

    int insertSelective(CarbonBuilding record);

    List<CarbonBuilding> selectByExample(CarbonBuildingExample example);

    CarbonBuilding selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CarbonBuilding record, @Param("example") CarbonBuildingExample example);

    int updateByExample(@Param("record") CarbonBuilding record, @Param("example") CarbonBuildingExample example);

    int updateByPrimaryKeySelective(CarbonBuilding record);

    int updateByPrimaryKey(CarbonBuilding record);
}