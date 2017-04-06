package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbInterimExample;
import pojo.TbInterimKey;

public interface TbInterimMapper {
    long countByExample(TbInterimExample example);

    int deleteByExample(TbInterimExample example);

    int deleteByPrimaryKey(TbInterimKey key);

    int insert(TbInterimKey record);

    int insertSelective(TbInterimKey record);

    List<TbInterimKey> selectByExample(TbInterimExample example);

    int updateByExampleSelective(@Param("record") TbInterimKey record, @Param("example") TbInterimExample example);

    int updateByExample(@Param("record") TbInterimKey record, @Param("example") TbInterimExample example);
}