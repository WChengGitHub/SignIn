package service.adminAccountManagementService;

import mapper.TbEmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.TbEmployee;
import pojo.TbEmployeeExample;

import java.util.List;

/**
 * Created by ZGM on 2017/3/30.
 */
@Service
public class AdminAccountManagementService {
    @Autowired
    private TbEmployeeMapper tbEmployeeMapper;

    //验证旧密码是否正确
    public List<TbEmployee> verification(TbEmployee tbEmployee)
    {
        TbEmployeeExample employeeExample=new TbEmployeeExample();
        TbEmployeeExample.Criteria criteria=employeeExample.createCriteria();
        criteria.andEmployeeidEqualTo(tbEmployee.getEmployeeid());
        List<TbEmployee> employeeList=tbEmployeeMapper.selectByExample(employeeExample);
//        for(TbEmployee tmp:employeeList)
//        {
//            tmp.setPassword(null);
//        }
        return employeeList;
    }

    //修改密码
    public boolean changePassword(TbEmployee tbEmployee)
    {
        try {
            TbEmployee tbEmployee2 = tbEmployeeMapper.selectByPrimaryKey(tbEmployee.getEmployeeid());
            tbEmployee2.setPassword(tbEmployee.getPassword());
            tbEmployeeMapper.updateByPrimaryKey(tbEmployee2);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    //修改手机号码
    public boolean changeTelephone(TbEmployee tbEmployee)
    {
        try {
            TbEmployee tbEmployee2 = tbEmployeeMapper.selectByPrimaryKey(tbEmployee.getEmployeeid());
            tbEmployee2.setTelephone(tbEmployee.getTelephone());
            tbEmployeeMapper.updateByPrimaryKey(tbEmployee2);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    //修改邮箱
    public boolean changeEmail(TbEmployee tbEmployee)
    {
        System.out.println("test change Email");
        System.out.println(tbEmployee.getEmployeeid());
        System.out.println(tbEmployee.getEmail());
        try {
            TbEmployee tbEmployee2 = tbEmployeeMapper.selectByPrimaryKey(tbEmployee.getEmployeeid());
            tbEmployee2.setEmail(tbEmployee.getEmail());
            tbEmployeeMapper.updateByPrimaryKey(tbEmployee2);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    //查询手机号码及邮箱
    public List<TbEmployee>  queryEmployee(TbEmployee tbEmployee)
    {
        TbEmployeeExample employeeExample=new TbEmployeeExample();
        TbEmployeeExample.Criteria criteria=employeeExample.createCriteria();
        criteria.andEmployeeidEqualTo(tbEmployee.getEmployeeid());
        List<TbEmployee> employeeList=tbEmployeeMapper.selectByExample(employeeExample);
        for(TbEmployee tmp:employeeList)
        {
            //System.out.println(tmp);
            tmp.setPassword(null);
        }
        return employeeList;
    }
}
