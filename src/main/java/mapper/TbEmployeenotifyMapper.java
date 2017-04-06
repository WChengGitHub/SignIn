package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbEmployeenotify;
import pojo.TbEmployeenotifyExample;
import pojo.TbEmployeenotifyKey;

public interface TbEmployeenotifyMapper {
    long countByExample(TbEmployeenotifyExample example);

    int deleteByExample(TbEmployeenotifyExample example);

    int deleteByPrimaryKey(TbEmployeenotifyKey key);

    int insert(TbEmployeenotify record);

    int insertSelective(TbEmployeenotify record);

    List<TbEmployeenotify> selectByExample(TbEmployeenotifyExample example);

    TbEmployeenotify selectByPrimaryKey(TbEmployeenotifyKey key);

    int updateByExampleSelective(@Param("record") TbEmployeenotify record, @Param("example") TbEmployeenotifyExample example);

    int updateByExample(@Param("record") TbEmployeenotify record, @Param("example") TbEmployeenotifyExample example);

    int updateByPrimaryKeySelective(TbEmployeenotify record);

    int updateByPrimaryKey(TbEmployeenotify record);
}