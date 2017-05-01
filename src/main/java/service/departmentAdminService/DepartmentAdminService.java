package service.departmentAdminService;

import mapper.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import otherFunction.md5.Encryption;
import pojo.*;
import utils.GetId;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by user on 2017/3/25.
 */
@Service
public class DepartmentAdminService {

    @Autowired
    private TbEmployeeMapper tbEmployeeMapper;

    @Autowired
    private TbApplicationMapper tbApplicationMapper;

    @Autowired
    private TbDepartmentscheduleMapper tbDepartmentscheduleMapper;

    @Autowired
    private TbEmployeenotifyMapper tbEmployeenotifyMapper;

    @Autowired
    private TbNotifyMapper notifyMapper;

    @Autowired
    private  TbActivityMapper activityMapper;

    @Autowired
    private MultiFormMapper multiFormMapper;

    @Autowired
    private TbDailyattendanceMapper dailyattendanceMapper;

    public List<TbEmployee>  queryEmployee(TbEmployee tbEmployee)
    {
        TbEmployeeExample employeeExample=new TbEmployeeExample();
        TbEmployeeExample.Criteria criteria=employeeExample.createCriteria();
        criteria.andDepartmentidEqualTo(tbEmployee.getDepartmentid());
        criteria.andDelEqualTo(false);
        List<TbEmployee> employeeList=tbEmployeeMapper.selectByExample(employeeExample);
        for(TbEmployee tmp:employeeList)
        {
            //System.out.println(tmp);
            tmp.setPassword(null);
        }
        return employeeList;
    }
    public List<TbApplication> queryApplication(TbEmployee tbEmployee)
    {
        List<TbEmployee> employeeList=queryEmployee(tbEmployee);
        TbApplicationExample applicationExample=new TbApplicationExample();
        TbApplicationExample.Criteria criteria=applicationExample.createCriteria();
        List<String>employIdList=new LinkedList<String>();
        for(TbEmployee tmp:employeeList)
        {
            //System.out.println(tmp)
            employIdList.add(tmp.getEmployeeid());
        }
        criteria.andEmployeeidIn(employIdList);
        List<TbApplication> applications=tbApplicationMapper.selectByExample(applicationExample);
        return applications;
    }
    public List<TbApplication> queryHistoryApplication(TbEmployee tbEmployee)
    {
        List<TbEmployee> employeeList=queryEmployee(tbEmployee);
        TbApplicationExample applicationExample=new TbApplicationExample();
        TbApplicationExample.Criteria criteria=applicationExample.createCriteria();
        List<String>employIdList=new LinkedList<String>();
        for(TbEmployee tmp:employeeList)
        {
            //System.out.println(tmp)
            employIdList.add(tmp.getEmployeeid());
        }
        criteria.andEmployeeidIn(employIdList);
        criteria.andStatusEqualTo(true);

        Date d1=new Date();
        Calendar now =Calendar.getInstance();
        now.setTime(d1);
        now.set(Calendar.DATE,now.get(Calendar.DATE)-7);
        Date d2=now.getTime();

        criteria.andApplicationtimeBetween(d2, d1);
        List<TbApplication> applications=tbApplicationMapper.selectByExample(applicationExample);
        return applications;
    }

    public List<TbDepartmentschedule> queryDepartmentSchedule(TbEmployee tbEmployee)
    {
        TbDepartmentscheduleExample tbDepartmentscheduleExample=new TbDepartmentscheduleExample();
        TbDepartmentscheduleExample.Criteria criteria=tbDepartmentscheduleExample.createCriteria();
        criteria.andDepartmentidEqualTo(tbEmployee.getDepartmentid());
        criteria.andDelEqualTo(false);
        List<TbDepartmentschedule> departmentschedules=tbDepartmentscheduleMapper.selectByExample(tbDepartmentscheduleExample);
        return departmentschedules;
    }
    public List<TbEmployeenotify> queryEmployeeNotify(TbEmployee employee,boolean status)
    {
        TbEmployeenotifyExample employeenotifyExample=new TbEmployeenotifyExample();
        TbEmployeenotifyExample.Criteria criteria=employeenotifyExample.createCriteria();
        criteria.andEmployeeidEqualTo(employee.getEmployeeid());
        criteria.andStatusEqualTo(status);
        List<TbEmployeenotify> employeenotifies=tbEmployeenotifyMapper.selectByExample(employeenotifyExample);
        return employeenotifies;
    }

    public List<TbNotifyVo> queryNotifyVo(TbEmployee employee)
    {
        List<TbNotifyVo> tbNotifyVos=multiFormMapper.selectNotifyVoByEmployeeid(employee.getEmployeeid());
        tbNotifyVos=queryNotifyVo1(employee.getEmployeeid(),tbNotifyVos);
        return tbNotifyVos;
    }
   public List<TbNotifyVo> queryNotifyVo1(String employeeid,List<TbNotifyVo> tbNotifyVos)
   {
       TbNotifyExample notifyExample=new TbNotifyExample();
       TbNotifyExample.Criteria criteria=notifyExample.createCriteria();
       criteria.andEmployeeidEqualTo(employeeid);
       List<TbNotify> notifies=notifyMapper.selectByExample(notifyExample);
       TbNotifyVo notifyVo=new TbNotifyVo();
       notifyVo.setStatus("2");
       if(notifies!=null)
       {
           int size=notifies.size();
           for(int i=0;i<size;i++)
           {
               BeanUtils.copyProperties(notifies.get(i),notifyVo);
               tbNotifyVos.add(notifyVo);
           }
       }
       return tbNotifyVos;
   }
    public List<TbActivity> queryActivites(TbEmployee employee)
    {
        TbActivityExample activityExample=new TbActivityExample();
        TbActivityExample.Criteria criteria=activityExample.createCriteria();
        criteria.andEmployeeidEqualTo(employee.getEmployeeid());
//        Date d1=new Date();
//        Calendar now =Calendar.getInstance();
//        now.setTime(d1);
//        now.set(Calendar.DATE,now.get(Calendar.DATE)-7);
//        Date d2=now.getTime();
//        criteria.andStarttimeBetween(d2,d1);
        List<TbActivity> activities=activityMapper.selectByExample(activityExample);
        return activities;
    }

    public void updateNotifyStatus(TbEmployeenotify employeenotify)
    {
        employeenotify.setStatus(true);
        tbEmployeenotifyMapper.updateByPrimaryKey(employeenotify);
    }

    public boolean deleteEmployee(TbEmployeeVo tbEmployeeVo)
    {
        int length=tbEmployeeVo.getEmployeeids().size();
        List<String>employeeids=tbEmployeeVo.getEmployeeids();
        try
        {
        for(int i=0;i<length;i++)
        {
            TbEmployee tbEmployee=new TbEmployee();
            tbEmployee.setEmployeeid(employeeids.get(i));
            tbEmployee.setDel(true);
            tbEmployeeMapper.updateByPrimaryKeySelective(tbEmployee);
        }
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  false;
    }

    public boolean deleteSchedule(TbDepartmentscheduleVo tbDepartmentscheduleVo)
    {
        int length=tbDepartmentscheduleVo.getScheduleids().size();
        TbDepartmentschedule departmentschedule=new TbDepartmentschedule();
        List<String> sheduleids=tbDepartmentscheduleVo.getScheduleids();
        try {
            for (int i = 0; i < length; i++) {
                departmentschedule.setScheduleid(sheduleids.get(i));
                departmentschedule.setDel(true);
                tbDepartmentscheduleMapper.updateByPrimaryKeySelective(departmentschedule);
            }
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public List<TbEmployee> getExcelDataAndDealData(MultipartFile file,String departmentid)
    {
        List<TbEmployee> employees=new LinkedList<TbEmployee>();
        try {
            Workbook wb= WorkbookFactory.create(file.getInputStream());
            Sheet sheet=wb.getSheetAt(0);
            int length=sheet.getLastRowNum();
            System.out.println(length);
            for(int i=2;i<=sheet.getLastRowNum();i++)
            {
                Row row=sheet.getRow(i);
                TbEmployee employee=new TbEmployee();

//                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
//                employee.setEmployeeid(row.getCell(0).getStringCellValue());

                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                employee.setName(row.getCell(0).getStringCellValue());

                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                employee.setAccount(row.getCell(1).getStringCellValue());

                row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                String Sex=row.getCell(2).getStringCellValue();
                if(Sex.equals("男"))
                    employee.setSex(true);
                else
                    employee.setSex(false);

                row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                employee.setDuties(row.getCell(3).getStringCellValue());

                row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                employee.setTelephone(row.getCell(4).getStringCellValue());

                row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                employee.setEmail(row.getCell(5).getStringCellValue());

                employee.setDepartmentid(departmentid);
                employee.setDel(false);
                employee.setPrivilege("0");
                employee.setPassword("123456");

                employees.add(employee);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(employees);
        return employees;
    }
    public void deleteAllEmployee(String departmentid)
    {
        TbEmployee employee=new TbEmployee();
        employee.setDepartmentid(departmentid);
        List<TbEmployee> employees=queryEmployee(employee);
        int size=employees.size();
        for(int i=0;i<size;i++)
        {
            TbEmployee tmp=employees.get(i);
            tmp.setDel(true);
            tbEmployeeMapper.updateByPrimaryKeySelective(tmp);
        }
    }
    public boolean addOneEmployee(TbEmployee employee)
    {
        employee.setEmployeeid(GetId.getId());
        employee.setDel(false);
        employee.setPrivilege("0");
        employee.setPassword("123456");
        try {
            tbEmployeeMapper.insert(employee);
            return  true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean changeEmployee(TbEmployeeVo tbemployeeVo)
    {
        TbEmployee employee=new TbEmployee();
        List<String>employeeids=tbemployeeVo.getEmployeeids();
        int size=employeeids.size();
        try
        {
            for(int i=0;i<size;i++)
            {
                employee.setEmployeeid(employeeids.get(i));
                employee.setDuties(tbemployeeVo.getDuties());
                tbEmployeeMapper.updateByPrimaryKeySelective(employee);
            }
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();

        }

        return false;
    }
    public boolean addSchedules(TbDepartmentschedule departmentschedule)
    {
        departmentschedule.setScheduleid(GetId.getId());
        departmentschedule.setDel(false);
        try
        {
            tbDepartmentscheduleMapper.insert(departmentschedule);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean changeSchedule(TbDepartmentscheduleVo departmentscheduleVo)
    {
        TbDepartmentschedule departmentschedule=new TbDepartmentschedule();
        departmentschedule.setDepartmentid(departmentscheduleVo.getDepartmentid());
        departmentschedule.setEntertime(departmentscheduleVo.getEntertime());
        departmentschedule.setOuttime(departmentscheduleVo.getOuttime());
        List<String> scheduleids=departmentscheduleVo.getScheduleids();
        try
        {
            for(int i=0;i<scheduleids.size();i++)
            {
                departmentschedule.setScheduleid(scheduleids.get(i));
                tbDepartmentscheduleMapper.updateByPrimaryKeySelective(departmentschedule);
            }
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return  false;
    }
    public boolean judgeTelephone(String telephone)
    {
        return false;
    }
    public void addEmployee(MultipartFile file,String departmentid)
    {
        List<TbEmployee> employees=getExcelDataAndDealData(file,departmentid);
        //deleteAllEmployee(departmentid);
        int size=employees.size();
        for(int i=0;i<size;i++)
        {
            TbEmployee employee=employees.get(i);
            employee.setEmployeeid(GetId.getId());
            tbEmployeeMapper.insert(employee);
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
    public boolean agreeApplicaion(TbApplication application)
    {
        application=getApplicationByid(application);
        application.setStatus(true);
        if(updateApplicaion(application))
        {
            TbDailyattendance dailyattendance=new TbDailyattendance();
            dailyattendance.setDailyattendanceid(application.getDailyattendanceid());
            dailyattendance.setStatus("1");
            if(application.getStyle()==false)
               dailyattendance.setEntertime(application.getCorrecttime());
            else
                dailyattendance.setOuttime(application.getCorrecttime());
            return updateDailyAttendance(dailyattendance);
        }
        return false;
    }
    public boolean updateApplicaion(TbApplication application)
    {
        try
        {
            tbApplicationMapper.updateByPrimaryKeySelective(application);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public TbDailyattendance getDailyAttendanceById(TbDailyattendance dailyattendance)
    {
        dailyattendance=dailyattendanceMapper.selectByPrimaryKey(dailyattendance.getDailyattendanceid());
        return dailyattendance;
    }
    public TbApplication getApplicationByid(TbApplication application)
    {
        application=tbApplicationMapper.selectByPrimaryKey(application.getApplicationid());
        return application;
    }
    public boolean updateDailyAttendance(TbDailyattendance dailyattendance)
    {
        try
        {
            dailyattendanceMapper.updateByPrimaryKeySelective(dailyattendance);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public List<TbEmployee> getScheduleEmployee(String scheduleid)
    {
        List<TbEmployee> employees=null;
        employees=multiFormMapper.queryScheduleEmployee(scheduleid);
        return employees;
    }
//    public HSSFWorkbook getEmployeeExcel(TbEmployee employee)
//    {
//        List<TbEmployee> employees=queryEmployee(employee);
//        HSSFWorkbook workbook=new HSSFWorkbook();
//        HSSFSheet sheet=workbook.createSheet("员工表");
//        HSSFRow row=sheet.createRow((short)0);
//        HSSFCell cell=null;
//        int nColumn=7;
//        cell=row.createCell(0);
//        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//        cell.setCellValue("ID");
//        cell=row.createCell(1);
//        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//        cell.setCellValue("名字");
//        cell=row.createCell(2);
//        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//        cell.setCellValue("用户名");
//        cell=row.createCell(3);
//        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//        cell.setCellValue("性别");
//        cell=row.createCell(4);
//        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//        cell.setCellValue("职务");
//        cell=row.createCell(5);
//        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//        cell.setCellValue("电话");
//        cell=row.createCell(6);
//        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//        cell.setCellValue("邮箱");
//
//        for(int i=1;i<=employees.size();i++)
//        {
//            row=sheet.createRow(i);
//            TbEmployee temp=employees.get(i-1);
//            cell=row.createCell(0);
//            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//            cell.setCellValue(temp.getEmployeeid());
//            cell=row.createCell(1);
//            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//            cell.setCellValue(temp.getName());
//            cell=row.createCell(2);
//            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//            cell.setCellValue(temp.getAccount());
//            cell=row.createCell(3);
//            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//            if(temp.getSex()==true)
//                cell.setCellValue("男");
//            else
//                cell.setCellValue("女");
//            cell=row.createCell(4);
//            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//            cell.setCellValue(temp.getDuties());
//            cell=row.createCell(5);
//            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//            cell.setCellValue(temp.getTelephone());
//            cell=row.createCell(6);
//            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//            cell.setCellValue(temp.getEmail());
//
//        }
//        return workbook;
//    }


    //部门管理员登录
    public String login(TbEmployee tbEmployee,HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        try {
            String MD5password= Encryption.generatePassword(tbEmployee.getPassword());
            tbEmployee.setPassword(MD5password);

            TbEmployeeExample employeeExample=new TbEmployeeExample();
            TbEmployeeExample.Criteria criteria=employeeExample.createCriteria();

            if(tbEmployee.getTelephone()!=null) criteria.andTelephoneEqualTo(tbEmployee.getTelephone());
            else if(tbEmployee.getEmail()!=null) criteria.andEmailEqualTo(tbEmployee.getEmail());
            else if(tbEmployee.getAccount()!=null) criteria.andAccountEqualTo(tbEmployee.getAccount());
            criteria.andDelEqualTo(false);
            criteria.andPrivilegeEqualTo("1");
            List<TbEmployee> tbEmployeeList = tbEmployeeMapper.selectByExample(employeeExample);

            int count = tbEmployeeList.size();
            if (count == 0) return "0";
//            else if(tbEmployeeList.get(0).getPrivilege()=="1") return "0";
            else
            if (tbEmployee.getPassword().equals(tbEmployeeList.get(0).getPassword())) {
                session.setMaxInactiveInterval(1 * 60);//Session1分钟失效
                session.setAttribute("EmployeeId", tbEmployeeList.get(0).getEmployeeid());
                return tbEmployeeList.get(0).getDepartmentid();
            }
            else
                return "passwordWrong";
        }
        catch(Exception e){
            return null;
        }
    }

    //获取部门管理员的员工id
    public String getDepartmentAdminEmployeeName(TbEmployee tbEmployee) {
        TbEmployeeExample employeeExample=new TbEmployeeExample();
        TbEmployeeExample.Criteria criteria=employeeExample.createCriteria();
        criteria.andEmployeeidEqualTo(tbEmployee.getEmployeeid());
        List<TbEmployee> employeeList=tbEmployeeMapper.selectByExample(employeeExample);
        String employeeName = employeeList.get(0).getName();
        return employeeName;
    }
}
