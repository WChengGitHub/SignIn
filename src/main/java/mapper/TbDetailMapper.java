package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbDetail;
import pojo.TbDetailExample;

public interface TbDetailMapper {
    long countByExample(TbDetailExample example);

    int deleteByExample(TbDetailExample example);

    int deleteByPrimaryKey(String detailid);

    int insert(TbDetail record);

    int insertSelective(TbDetail record);

    List<TbDetail> selectByExample(TbDetailExample example);

    TbDetail selectByPrimaryKey(String detailid);

    int updateByExampleSelective(@Param("record") TbDetail record, @Param("example") TbDetailExample example);

    int updateByExample(@Param("record") TbDetail record, @Param("example") TbDetailExample example);

    int updateByPrimaryKeySelective(TbDetail record);

    int updateByPrimaryKey(TbDetail record);
}