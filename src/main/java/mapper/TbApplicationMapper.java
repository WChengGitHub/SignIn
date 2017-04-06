package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbApplication;
import pojo.TbApplicationExample;

public interface TbApplicationMapper {
    long countByExample(TbApplicationExample example);

    int deleteByExample(TbApplicationExample example);

    int deleteByPrimaryKey(String applicationid);

    int insert(TbApplication record);

    int insertSelective(TbApplication record);

    List<TbApplication> selectByExample(TbApplicationExample example);

    TbApplication selectByPrimaryKey(String applicationid);

    int updateByExampleSelective(@Param("record") TbApplication record, @Param("example") TbApplicationExample example);

    int updateByExample(@Param("record") TbApplication record, @Param("example") TbApplicationExample example);

    int updateByPrimaryKeySelective(TbApplication record);

    int updateByPrimaryKey(TbApplication record);
}