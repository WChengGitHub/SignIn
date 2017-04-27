package service.companyAdminService;

import mapper.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import otherFunction.md5.Encryption;
import pojo.*;
import utils.GetId;
import otherFunction.md5.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by user on 2017/4/13.
 */
@Service
public class CompanyAdminService {
    @Autowired
    private TbCompanyMapper tbCompanyMapper;

    @Autowired
    private TbDepartmentMapper tbDepartmentMapper;

    @Autowired
    private TbEmployeeMapper tbEmployeeMapper;

    @Autowired
    private TbActivityMapper tbActivityMapper;

    @Autowired
    private TbNotifyMapper notifyMapper;

    @Autowired
    private TbCompanyrepresentativeMapper tbCompanyrepresentativeMapper;

    @Autowired
    private MultiFormMapper multiFormMapper;


    public List<TbDepartment> getExcelDataAndDealData(MultipartFile file,String companyid)
    {
       List<TbDepartment> departments=new LinkedList<TbDepartment>();
        try {
            Workbook wb= WorkbookFactory.create(file.getInputStream());
            Sheet sheet=wb.getSheetAt(0);
            int length=sheet.getLastRowNum();
            System.out.println(length);
            for(int i=2;i<=sheet.getLastRowNum();i++)
            {
                Row row=sheet.getRow(i);
                TbDepartment department=new TbDepartment();

//                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
//                employee.setEmployeeid(row.getCell(0).getStringCellValue());

                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                department.setName(row.getCell(0).getStringCellValue());

                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                department.setAddress(row.getCell(1).getStringCellValue());

                row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                department.setMac(row.getCell(2).getStringCellValue());

                department.setCompanyid(companyid);
                department.setDel(false);
                departments.add(department);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(departments);
        return departments;
    }
    public void addDepartments(MultipartFile file, String companyid)
    {
       List<TbDepartment>departments=getExcelDataAndDealData(file,companyid);
        //deleteAllEmployee(departmentid);
        int size=departments.size();
        for(int i=0;i<size;i++)
        {
            TbDepartment department=departments.get(i);
            department.setDepartmentid(GetId.getId());
            tbDepartmentMapper.insert(department);
            autoAddDepartmentAdmin(department.getDepartmentid());
//            if(employee.getEmployeeid()==null||employee.getEmployeeid().equals(""))
//            {
//                employee.setEmployeeid(""+(i+1));
//                tbEmployeeMapper.insert(employee);
//            }
//            else
//            {
//                    tbEmployeeMapper.updateByPrimaryKey(employee);
//            }
        }
    }
    public boolean addOneDepartment(TbDepartment department)
    {
        department.setDepartmentid(GetId.getId());
        department.setDel(false);
        try
        {
            tbDepartmentMapper.insert(department);
            autoAddDepartmentAdmin(department.getDepartmentid());
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public List<TbDepartment> getDepartments(String companyid)
    {
        TbDepartmentExample departmentExample=new TbDepartmentExample();
        TbDepartmentExample.Criteria criteria=departmentExample.createCriteria();
        criteria.andCompanyidEqualTo(companyid);
        criteria.andDelEqualTo(false);
        List<TbDepartment> departments=null;
        departments=tbDepartmentMapper.selectByExample(departmentExample);
        return departments;
    }
    public void autoAddDepartmentAdmin(String departmentid)
    {
        TbEmployee employee=new TbEmployee();
        employee.setEmployeeid(GetId.getId());
        employee.setName("管理员");
        employee.setAccount(GetId.getId());
        employee.setPassword("123456");
        employee.setDel(false);
        employee.setDuties("部门管理员");
        employee.setSex(true);
        employee.setPrivilege("1");
        employee.setDepartmentid(departmentid);
        employee.setTelephone("无");
        employee.setEmail("无");
        tbEmployeeMapper.insert(employee);

    }
    public List<TbEmployee> getDepartmentAdmin(String departmentid)
    {
        TbEmployeeExample employeeExample=new TbEmployeeExample();
        TbEmployeeExample.Criteria criteria=employeeExample.createCriteria();
        criteria.andDepartmentidEqualTo(departmentid);
        criteria.andDelEqualTo(false);
        List<TbEmployee> employees=tbEmployeeMapper.selectByExample(employeeExample);
        if(employees!=null&&employees.size()!=0)
        {
            int size=employees.size();
            for(int i=0;i<size;i++)
            {
                employees.get(i).setPassword("");
            }
        }
        return employees;
    }
    public boolean updateDepartment(TbDepartmentVo tbDepartmentVo)
    {
        TbDepartment department=new TbDepartment();
        department.setAddress(tbDepartmentVo.getAddress());
        department.setName(tbDepartmentVo.getName());
        department.setMac(tbDepartmentVo.getMac());
        List<String> departmentids=tbDepartmentVo.getDepartmentids();
        int size=departmentids.size();
        try {
            for (int i = 0; i < size; i++) {
                department.setDepartmentid(departmentids.get(i));
                tbDepartmentMapper.updateByPrimaryKeySelective(department);
            }
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteDepartments(TbDepartmentVo tbDepartmentVo)
    {
        List<String> departmentids=tbDepartmentVo.getDepartmentids();
        int size=departmentids.size();
        try
        {
            for(int i=0;i<size;i++)
            {
                TbDepartment tbDepartment=new TbDepartment();
                tbDepartment.setDepartmentid(departmentids.get(i));
                tbDepartment.setDel(true);
                tbDepartmentMapper.updateByPrimaryKeySelective(tbDepartment);
            }
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    public List<TbActivity> queryActivities( String companyrepresentativeid)
    {
        TbActivityExample activityExample=new TbActivityExample();
        TbActivityExample.Criteria criteria=activityExample.createCriteria();
        criteria.andCompanyrepresentativeidEqualTo(companyrepresentativeid);
        return tbActivityMapper.selectByExample(activityExample);
    }

    public List<TbNotify> queryNotifies(String companyrepresentativeid)
    {
        TbNotifyExample notifyExample=new TbNotifyExample();
        TbNotifyExample.Criteria criteria=notifyExample.createCriteria();
        criteria.andCompanyrepresentativeidEqualTo(companyrepresentativeid);
        return notifyMapper.selectByExample(notifyExample);
    }

    //公司管理员登录
    public String login(TbCompanyrepresentative tbCompanyrepresentative)
    {
        try {

            String MD5password=Encryption.generatePassword(tbCompanyrepresentative.getPassword());
            tbCompanyrepresentative.setPassword(MD5password);

            TbCompanyrepresentativeExample companyrepresentativeExample = new TbCompanyrepresentativeExample();
            TbCompanyrepresentativeExample.Criteria criteria = companyrepresentativeExample.createCriteria();
            criteria.andTelephoneEqualTo(tbCompanyrepresentative.getTelephone());
            List<TbCompanyrepresentative> tbCompanyrepresentativeList = tbCompanyrepresentativeMapper.selectByExample(companyrepresentativeExample);

            int count = tbCompanyrepresentativeList.size();
            if (count == 0) return "0";
            else
            if (tbCompanyrepresentative.getPassword().equals(tbCompanyrepresentativeList.get(0).getPassword()))
                return tbCompanyrepresentativeList.get(0).getCompanyrepresentativeid();
            else
                return "passwordWrong";
        }
        catch(Exception e){
            return null;
        }
    }

    //公司管理员注册
    public boolean register(TbCompanyrepresentative tbCompanyrepresentative){



        //生成随机id
        Calendar cal1 = Calendar.getInstance();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));
        java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddkkmmss");
        int randomNumber = (int)(Math.random() * 10 );
        try {
            tbCompanyrepresentative.setCompanyrepresentativeid(sdf.format(cal1.getTime())+randomNumber);
            tbCompanyrepresentative.setEmail("0");

            String MD5password=Encryption.generatePassword(tbCompanyrepresentative.getPassword());
            tbCompanyrepresentative.setPassword(MD5password);
            tbCompanyrepresentativeMapper.insert(tbCompanyrepresentative);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }



}
