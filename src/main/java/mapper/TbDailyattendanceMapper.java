package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbDailyattendance;
import pojo.TbDailyattendanceExample;

public interface TbDailyattendanceMapper {
    long countByExample(TbDailyattendanceExample example);

    int deleteByExample(TbDailyattendanceExample example);

    int deleteByPrimaryKey(String dailyattendanceid);

    int insert(TbDailyattendance record);

    int insertSelective(TbDailyattendance record);

    List<TbDailyattendance> selectByExample(TbDailyattendanceExample example);

    TbDailyattendance selectByPrimaryKey(String dailyattendanceid);

    int updateByExampleSelective(@Param("record") TbDailyattendance record, @Param("example") TbDailyattendanceExample example);

    int updateByExample(@Param("record") TbDailyattendance record, @Param("example") TbDailyattendanceExample example);

    int updateByPrimaryKeySelective(TbDailyattendance record);

    int updateByPrimaryKey(TbDailyattendance record);
}