package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbActivityattendance;
import pojo.TbActivityattendanceExample;

public interface TbActivityattendanceMapper {
    long countByExample(TbActivityattendanceExample example);

    int deleteByExample(TbActivityattendanceExample example);

    int deleteByPrimaryKey(String activityattendanceid);

    int insert(TbActivityattendance record);

    int insertSelective(TbActivityattendance record);

    List<TbActivityattendance> selectByExample(TbActivityattendanceExample example);

    TbActivityattendance selectByPrimaryKey(String activityattendanceid);

    int updateByExampleSelective(@Param("record") TbActivityattendance record, @Param("example") TbActivityattendanceExample example);

    int updateByExample(@Param("record") TbActivityattendance record, @Param("example") TbActivityattendanceExample example);

    int updateByPrimaryKeySelective(TbActivityattendance record);

    int updateByPrimaryKey(TbActivityattendance record);
}