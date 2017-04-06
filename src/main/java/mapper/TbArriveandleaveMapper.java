package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbArriveandleave;
import pojo.TbArriveandleaveExample;

public interface TbArriveandleaveMapper {
    long countByExample(TbArriveandleaveExample example);

    int deleteByExample(TbArriveandleaveExample example);

    int deleteByPrimaryKey(String arriveandleaveid);

    int insert(TbArriveandleave record);

    int insertSelective(TbArriveandleave record);

    List<TbArriveandleave> selectByExample(TbArriveandleaveExample example);

    TbArriveandleave selectByPrimaryKey(String arriveandleaveid);

    int updateByExampleSelective(@Param("record") TbArriveandleave record, @Param("example") TbArriveandleaveExample example);

    int updateByExample(@Param("record") TbArriveandleave record, @Param("example") TbArriveandleaveExample example);

    int updateByPrimaryKeySelective(TbArriveandleave record);

    int updateByPrimaryKey(TbArriveandleave record);
}