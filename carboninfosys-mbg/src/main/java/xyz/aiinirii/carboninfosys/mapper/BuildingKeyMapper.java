package xyz.aiinirii.carboninfosys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.aiinirii.carboninfosys.model.BuildingKey;
import xyz.aiinirii.carboninfosys.model.BuildingKeyExample;

public interface BuildingKeyMapper {
    long countByExample(BuildingKeyExample example);

    int deleteByExample(BuildingKeyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BuildingKey record);

    int insertSelective(BuildingKey record);

    List<BuildingKey> selectByExample(BuildingKeyExample example);

    BuildingKey selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BuildingKey record, @Param("example") BuildingKeyExample example);

    int updateByExample(@Param("record") BuildingKey record, @Param("example") BuildingKeyExample example);

    int updateByPrimaryKeySelective(BuildingKey record);

    int updateByPrimaryKey(BuildingKey record);
}