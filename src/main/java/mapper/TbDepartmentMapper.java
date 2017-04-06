package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbDepartment;
import pojo.TbDepartmentExample;

public interface TbDepartmentMapper {
    long countByExample(TbDepartmentExample example);

    int deleteByExample(TbDepartmentExample example);

    int deleteByPrimaryKey(String departmentid);

    int insert(TbDepartment record);

    int insertSelective(TbDepartment record);

    List<TbDepartment> selectByExample(TbDepartmentExample example);

    TbDepartment selectByPrimaryKey(String departmentid);

    int updateByExampleSelective(@Param("record") TbDepartment record, @Param("example") TbDepartmentExample example);

    int updateByExample(@Param("record") TbDepartment record, @Param("example") TbDepartmentExample example);

    int updateByPrimaryKeySelective(TbDepartment record);

    int updateByPrimaryKey(TbDepartment record);
}