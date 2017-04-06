package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbEmployeescheduleExample;
import pojo.TbEmployeescheduleKey;

public interface TbEmployeescheduleMapper {
    long countByExample(TbEmployeescheduleExample example);

    int deleteByExample(TbEmployeescheduleExample example);

    int deleteByPrimaryKey(TbEmployeescheduleKey key);

    int insert(TbEmployeescheduleKey record);

    int insertSelective(TbEmployeescheduleKey record);

    List<TbEmployeescheduleKey> selectByExample(TbEmployeescheduleExample example);

    int updateByExampleSelective(@Param("record") TbEmployeescheduleKey record, @Param("example") TbEmployeescheduleExample example);

    int updateByExample(@Param("record") TbEmployeescheduleKey record, @Param("example") TbEmployeescheduleExample example);
}