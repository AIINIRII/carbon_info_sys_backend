package xyz.aiinirii.carboninfosys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.aiinirii.carboninfosys.model.BuildingGroup;
import xyz.aiinirii.carboninfosys.model.BuildingGroupExample;

public interface BuildingGroupMapper {
    long countByExample(BuildingGroupExample example);

    int deleteByExample(BuildingGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BuildingGroup record);

    int insertSelective(BuildingGroup record);

    List<BuildingGroup> selectByExample(BuildingGroupExample example);

    BuildingGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BuildingGroup record, @Param("example") BuildingGroupExample example);

    int updateByExample(@Param("record") BuildingGroup record, @Param("example") BuildingGroupExample example);

    int updateByPrimaryKeySelective(BuildingGroup record);

    int updateByPrimaryKey(BuildingGroup record);
}