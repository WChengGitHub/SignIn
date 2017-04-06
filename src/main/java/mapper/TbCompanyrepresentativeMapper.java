package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbCompanyrepresentative;
import pojo.TbCompanyrepresentativeExample;

public interface TbCompanyrepresentativeMapper {
    long countByExample(TbCompanyrepresentativeExample example);

    int deleteByExample(TbCompanyrepresentativeExample example);

    int deleteByPrimaryKey(String companyrepresentativeid);

    int insert(TbCompanyrepresentative record);

    int insertSelective(TbCompanyrepresentative record);

    List<TbCompanyrepresentative> selectByExample(TbCompanyrepresentativeExample example);

    TbCompanyrepresentative selectByPrimaryKey(String companyrepresentativeid);

    int updateByExampleSelective(@Param("record") TbCompanyrepresentative record, @Param("example") TbCompanyrepresentativeExample example);

    int updateByExample(@Param("record") TbCompanyrepresentative record, @Param("example") TbCompanyrepresentativeExample example);

    int updateByPrimaryKeySelective(TbCompanyrepresentative record);

    int updateByPrimaryKey(TbCompanyrepresentative record);
}