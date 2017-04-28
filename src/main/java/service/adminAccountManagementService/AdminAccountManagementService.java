package service.adminAccountManagementService;

import mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import otherFunction.md5.Encryption;
import pojo.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ZGM on 2017/3/30.
 */
@Service
public class AdminAccountManagementService {
    @Autowired
    private TbEmployeeMapper tbEmployeeMapper;
    @Autowired
    private TbCompanyMapper tbCompanyMapper;
    @Autowired
    private TbDepartmentMapper tbDepartmentMapper;
    @Autowired
    private TbNotifyMapper tbNotifyMapper;
    @Autowired
    private TbEmployeenotifyMapper tbEmployeenotifyMapper;
    @Autowired
    private MultiFormMapper multiFormMapper;
    @Autowired
    private TbActivityMapper tbActivityMapper;
    @Autowired
    private TbCompanyrepresentativeMapper tbCompanyrepresentativeMapper;

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

    //公司管理员验证旧密码是否正确
    public List<TbCompanyrepresentative> verificationCompanyAdmin(TbCompanyrepresentative tbCompanyrepresentative)
    {
        TbCompanyrepresentativeExample companyrepresentativeExample=new TbCompanyrepresentativeExample();
        TbCompanyrepresentativeExample.Criteria criteria=companyrepresentativeExample.createCriteria();
        criteria.andCompanyrepresentativeidEqualTo(tbCompanyrepresentative.getCompanyrepresentativeid());
        List<TbCompanyrepresentative> companyrepresentativeList=tbCompanyrepresentativeMapper.selectByExample(companyrepresentativeExample);
//        for(TbEmployee tmp:employeeList)
//        {
//            tmp.setPassword(null);
//        }
        return companyrepresentativeList;
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

    //公司管理员修改密码
    public boolean companyAdminChangePassword(TbCompanyrepresentative tbCompanyrepresentative)
    {
        String MD5password=Encryption.generatePassword(tbCompanyrepresentative.getPassword());
        tbCompanyrepresentative.setPassword(MD5password);
        try {
            TbCompanyrepresentative tbCompanyrepresentative2 = tbCompanyrepresentativeMapper.selectByPrimaryKey(tbCompanyrepresentative.getCompanyrepresentativeid());
            tbCompanyrepresentative2.setPassword(tbCompanyrepresentative.getPassword());
            tbCompanyrepresentativeMapper.updateByPrimaryKey(tbCompanyrepresentative2);
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

    //修改公司管理员手机号码
    public boolean changeCompanyAdminTelephone(TbCompanyrepresentative tbCompanyrepresentative)
    {
        try {
            TbCompanyrepresentative tbCompanyrepresentative2 = tbCompanyrepresentativeMapper.selectByPrimaryKey(tbCompanyrepresentative.getCompanyrepresentativeid());
            tbCompanyrepresentative2.setTelephone(tbCompanyrepresentative.getTelephone());
            tbCompanyrepresentativeMapper.updateByPrimaryKey(tbCompanyrepresentative2);
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

    //公司管理员修改邮箱
    public boolean changeCompanyAdminEmail(TbCompanyrepresentative tbCompanyrepresentative)
    {
        System.out.println("test change companyAdmin Email");
//        System.out.println(tbCompanyrepresentative.getCompanyrepresentativeid());
//        System.out.println(tbCompanyrepresentative.getEmail());
        try {
            TbCompanyrepresentative tbCompanyrepresentative2 = tbCompanyrepresentativeMapper.selectByPrimaryKey(tbCompanyrepresentative.getCompanyrepresentativeid());
            tbCompanyrepresentative2.setEmail(tbCompanyrepresentative.getEmail());
            tbCompanyrepresentativeMapper.updateByPrimaryKey(tbCompanyrepresentative2);
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
    //查询该公司的部门列表
    public List<TbDepartment>  queryDepartment(TbDepartment tbDepartment)
    {
        TbDepartmentExample departmentExample=new TbDepartmentExample();
        TbDepartmentExample.Criteria criteria=departmentExample.createCriteria();
        criteria.andCompanyidEqualTo(tbDepartment.getCompanyid());
        List<TbDepartment> departmentList=tbDepartmentMapper.selectByExample(departmentExample);
        return departmentList;
    }

    //查看公司列表
    public List<TbCompany>  queryCompany(TbCompany tbCompany)
    {
        TbCompanyExample companyExample=new TbCompanyExample();
        TbCompanyExample.Criteria criteria=companyExample.createCriteria();
        criteria.andCompanyrepresentativeidEqualTo(tbCompany.getCompanyrepresentativeid());
        List<TbCompany> companyList=tbCompanyMapper.selectByExample(companyExample);
        return companyList;
    }

    //添加通知表记录
    public boolean addNotify(TbNotify tbNotify,HttpServletRequest request){
        try {
            //生成NotifyId
            Calendar cal1 = Calendar.getInstance();
            TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));
            java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddkkmmss");
            int randomNumber = (int)(Math.random() * 10 );
            tbNotify.setNotifyid(sdf.format(cal1.getTime())+randomNumber);

            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(1 * 60);//Session1分钟失效
            session.setAttribute("Notifyid", (sdf.format(cal1.getTime())+randomNumber));

            tbNotifyMapper.insert(tbNotify);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    //批量添加员工通知表记录
    public boolean addEmployeeNotify(TbEmployeenotify tbEmployeenotify,HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            List<String> employeeIds=tbEmployeenotify.getEmployeeIds();
            int len=employeeIds.size();
            System.out.println(len+"test   length                                     test");
//            List<String> newNotifyIdsList = new ArrayList();//存放生成的NotifyId
//            String[] newNotifyIds=new String[len];
//            for(int i=0;i<len;i++){
//                Calendar cal1 = Calendar.getInstance();
//                TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));
//                java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddkkmmss");
//                int randomNumber = (int)(Math.random() * 10 );
////                newNotifyIds.add(sdf.format(cal1.getTime())+randomNumber);
//                newNotifyIds[i]=sdf.format(cal1.getTime())+randomNumber;
//            }
//            List<String> newNotifyIdsList = Arrays.asList(newNotifyIds);//存放生成的NotifyId
//            tbEmployeenotify.setNotifyIds(newNotifyIdsList);
            for (int i=0;i<len;i++){
                TbEmployeenotify tbEmployeenotify2 = new TbEmployeenotify();
                System.out.println((String)session.getAttribute("Notifyid"));
                tbEmployeenotify2.setEmployeeid(tbEmployeenotify.getEmployeeIds().get(i));
                tbEmployeenotify2.setNotifyid((String)session.getAttribute("Notifyid"));
                tbEmployeenotifyMapper.insert(tbEmployeenotify2);
            }
//            tbEmployeenotifyMapper.insert(tbEmployeenotify);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<TbEmployee> getDepartmentEmployeeId(TbEmployeeVo tbEmployeeVo){
        int length=tbEmployeeVo.getDepartmentids().size();
        System.out.println(length);
        List<String> departmentids=tbEmployeeVo.getDepartmentids();
//        List<TbEmployee> tbEmployeeList = null;
        TbEmployee[] Eid=new TbEmployee[length];
        try {
            for (int i = 0; i < length; i++) {
                TbEmployee tbEmployee = new TbEmployee();
                System.out.println("test7");
                //根据部门的id查到该部门管理员的id
                String employeeId = multiFormMapper.selectDepartmentEmployeeIds(departmentids.get(i));
                System.out.println(employeeId + "test2                                     test2");
                tbEmployee.setEmployeeid(employeeId);
//                tbEmployeeList.add(tbEmployee);
                Eid[i]=tbEmployee;
            }
            List<TbEmployee> tbEmployeeList = Arrays.asList(Eid);
            return tbEmployeeList;
        }
        catch (Exception e){
            return null;
        }
    }

    //添加活动表记录
    public boolean addActivity(TbActivity tbActivity,HttpServletRequest request){
        try {
            //生成Id
            Calendar cal1 = Calendar.getInstance();
            TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));
            java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddkkmmss");
            int randomNumber = (int)(Math.random() * 10 );
            tbActivity.setActivityid(sdf.format(cal1.getTime()) + randomNumber);

            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(1 * 60);//Session1分钟失效
            session.setAttribute("Activityid", (sdf.format(cal1.getTime())+randomNumber));

            tbActivityMapper.insert(tbActivity);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    //部门管理员获取所属公司的id
    public List<TbDepartment> departmentGetCompanyId(TbDepartment tbDepartment){
        TbDepartmentExample departmentExample=new TbDepartmentExample();
        TbDepartmentExample.Criteria criteria=departmentExample.createCriteria();
        criteria.andDepartmentidEqualTo(tbDepartment.getDepartmentid());
        List<TbDepartment> departmentList=tbDepartmentMapper.selectByExample(departmentExample);
        return departmentList;
    }

    //加载该部门的员工列表
    public List<TbEmployee> getEmployeeList(TbEmployee tbEmployee){
        TbEmployeeExample employeeExample=new TbEmployeeExample();
        TbEmployeeExample.Criteria criteria=employeeExample.createCriteria();
        criteria.andDepartmentidEqualTo(tbEmployee.getDepartmentid());
        List<TbEmployee> employeeList=tbEmployeeMapper.selectByExample(employeeExample);
        for(TbEmployee tmp:employeeList)
        {
            tmp.setPassword(null);
        }
        return employeeList;
    }

    public List<TbCompanyrepresentative> getCompanyAdminInforMation(TbCompanyrepresentative tbCompanyrepresentative){
        TbCompanyrepresentativeExample companyrepresentativeExample=new TbCompanyrepresentativeExample();
        TbCompanyrepresentativeExample.Criteria criteria=companyrepresentativeExample.createCriteria();
        criteria.andCompanyrepresentativeidEqualTo(tbCompanyrepresentative.getCompanyrepresentativeid());
        List<TbCompanyrepresentative> companyrepresentativeList=tbCompanyrepresentativeMapper.selectByExample(companyrepresentativeExample);
        for(TbCompanyrepresentative tmp:companyrepresentativeList)
        {
            tmp.setPassword(null);
        }
        return companyrepresentativeList;
    }

}
