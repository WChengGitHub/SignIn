package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbDepartmentschedule;
import pojo.TbDepartmentscheduleExample;

public interface TbDepartmentscheduleMapper {
    long countByExample(TbDepartmentscheduleExample example);

    int deleteByExample(TbDepartmentscheduleExample example);

    int deleteByPrimaryKey(String scheduleid);

    int insert(TbDepartmentschedule record);

    int insertSelective(TbDepartmentschedule record);

    List<TbDepartmentschedule> selectByExample(TbDepartmentscheduleExample example);

    TbDepartmentschedule selectByPrimaryKey(String scheduleid);

    int updateByExampleSelective(@Param("record") TbDepartmentschedule record, @Param("example") TbDepartmentscheduleExample example);

    int updateByExample(@Param("record") TbDepartmentschedule record, @Param("example") TbDepartmentscheduleExample example);

    int updateByPrimaryKeySelective(TbDepartmentschedule record);

    int updateByPrimaryKey(TbDepartmentschedule record);
}