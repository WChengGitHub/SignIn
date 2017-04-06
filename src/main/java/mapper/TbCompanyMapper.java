package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.TbCompany;
import pojo.TbCompanyExample;

public interface TbCompanyMapper {
    long countByExample(TbCompanyExample example);

    int deleteByExample(TbCompanyExample example);

    int deleteByPrimaryKey(String companyid);

    int insert(TbCompany record);

    int insertSelective(TbCompany record);

    List<TbCompany> selectByExample(TbCompanyExample example);

    TbCompany selectByPrimaryKey(String companyid);

    int updateByExampleSelective(@Param("record") TbCompany record, @Param("example") TbCompanyExample example);

    int updateByExample(@Param("record") TbCompany record, @Param("example") TbCompanyExample example);

    int updateByPrimaryKeySelective(TbCompany record);

    int updateByPrimaryKey(TbCompany record);
}