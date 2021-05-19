package xyz.aiinirii.carboninfosys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.aiinirii.carboninfosys.model.EnvironmentBuilding;
import xyz.aiinirii.carboninfosys.model.EnvironmentBuildingExample;

public interface EnvironmentBuildingMapper {
    long countByExample(EnvironmentBuildingExample example);

    int deleteByExample(EnvironmentBuildingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EnvironmentBuilding record);

    int insertSelective(EnvironmentBuilding record);

    List<EnvironmentBuilding> selectByExample(EnvironmentBuildingExample example);

    EnvironmentBuilding selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EnvironmentBuilding record, @Param("example") EnvironmentBuildingExample example);

    int updateByExample(@Param("record") EnvironmentBuilding record, @Param("example") EnvironmentBuildingExample example);

    int updateByPrimaryKeySelective(EnvironmentBuilding record);

    int updateByPrimaryKey(EnvironmentBuilding record);
}