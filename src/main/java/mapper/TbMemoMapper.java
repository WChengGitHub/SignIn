package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbMemo;
import pojo.TbMemoExample;

public interface TbMemoMapper {
    long countByExample(TbMemoExample example);

    int deleteByExample(TbMemoExample example);

    int deleteByPrimaryKey(String memoid);

    int insert(TbMemo record);

    int insertSelective(TbMemo record);

    List<TbMemo> selectByExample(TbMemoExample example);

    TbMemo selectByPrimaryKey(String memoid);

    int updateByExampleSelective(@Param("record") TbMemo record, @Param("example") TbMemoExample example);

    int updateByExample(@Param("record") TbMemo record, @Param("example") TbMemoExample example);

    int updateByPrimaryKeySelective(TbMemo record);

    int updateByPrimaryKey(TbMemo record);
}