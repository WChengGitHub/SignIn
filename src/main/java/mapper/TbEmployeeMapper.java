package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbEmployee;
import pojo.TbEmployeeExample;

public interface TbEmployeeMapper {
    long countByExample(TbEmployeeExample example);

    int deleteByExample(TbEmployeeExample example);

    int deleteByPrimaryKey(String employeeid);

    int insert(TbEmployee record);

    int insertSelective(TbEmployee record);

    List<TbEmployee> selectByExample(TbEmployeeExample example);

    TbEmployee selectByPrimaryKey(String employeeid);

    int updateByExampleSelective(@Param("record") TbEmployee record, @Param("example") TbEmployeeExample example);

    int updateByExample(@Param("record") TbEmployee record, @Param("example") TbEmployeeExample example);

    int updateByPrimaryKeySelective(TbEmployee record);

    int updateByPrimaryKey(TbEmployee record);
}