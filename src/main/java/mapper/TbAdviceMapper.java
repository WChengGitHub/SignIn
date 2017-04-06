package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbAdvice;
import pojo.TbAdviceExample;

public interface TbAdviceMapper {
    long countByExample(TbAdviceExample example);

    int deleteByExample(TbAdviceExample example);

    int deleteByPrimaryKey(String adviceid);

    int insert(TbAdvice record);

    int insertSelective(TbAdvice record);

    List<TbAdvice> selectByExample(TbAdviceExample example);

    TbAdvice selectByPrimaryKey(String adviceid);

    int updateByExampleSelective(@Param("record") TbAdvice record, @Param("example") TbAdviceExample example);

    int updateByExample(@Param("record") TbAdvice record, @Param("example") TbAdviceExample example);

    int updateByPrimaryKeySelective(TbAdvice record);

    int updateByPrimaryKey(TbAdvice record);
}