package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbNotify;
import pojo.TbNotifyExample;

public interface TbNotifyMapper {
    long countByExample(TbNotifyExample example);

    int deleteByExample(TbNotifyExample example);

    int deleteByPrimaryKey(String notifyid);

    int insert(TbNotify record);

    int insertSelective(TbNotify record);

    List<TbNotify> selectByExample(TbNotifyExample example);

    TbNotify selectByPrimaryKey(String notifyid);

    int updateByExampleSelective(@Param("record") TbNotify record, @Param("example") TbNotifyExample example);

    int updateByExample(@Param("record") TbNotify record, @Param("example") TbNotifyExample example);

    int updateByPrimaryKeySelective(TbNotify record);

    int updateByPrimaryKey(TbNotify record);
}