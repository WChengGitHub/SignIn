package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbActivity;
import pojo.TbActivityExample;

public interface TbActivityMapper {
    long countByExample(TbActivityExample example);

    int deleteByExample(TbActivityExample example);

    int deleteByPrimaryKey(String activityid);

    int insert(TbActivity record);

    int insertSelective(TbActivity record);

    List<TbActivity> selectByExample(TbActivityExample example);

    TbActivity selectByPrimaryKey(String activityid);

    int updateByExampleSelective(@Param("record") TbActivity record, @Param("example") TbActivityExample example);

    int updateByExample(@Param("record") TbActivity record, @Param("example") TbActivityExample example);

    int updateByPrimaryKeySelective(TbActivity record);

    int updateByPrimaryKey(TbActivity record);
}