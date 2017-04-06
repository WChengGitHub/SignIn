package service.departmentAdminService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by user on 2017/3/25.
 */
public class DepartmentAdminServiceTest {

    private ApplicationContext applicationContext;
    @Before
    public void setUp() throws Exception {
        applicationContext=new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-Dao.xml","spring/applicationContext-Service.xml","spring/applicationContext-transaction.xml"});
    }


    @Test
    public void testQueryEmployee() throws Exception {
        DepartmentAdminService departmentAdminService= (DepartmentAdminService) applicationContext.getBean("departmentAdminService");
        TbEmployee tbEmployee=new TbEmployee();
        tbEmployee.setDepartmentid("1");
        List<TbEmployee> employeeList=departmentAdminService.queryEmployee(tbEmployee);

    }

    @Test
    public void testQueryApplication() throws Exception {
        DepartmentAdminService departmentAdminService= (DepartmentAdminService) applicationContext.getBean("departmentAdminService");
        TbEmployee tbEmployee=new TbEmployee();
        tbEmployee.setDepartmentid("1");
        List<TbApplication> applications=departmentAdminService.queryApplication(tbEmployee);
    }

    @Test
    public void testQueryHistoryApplication() throws Exception {
        DepartmentAdminService departmentAdminService= (DepartmentAdminService) applicationContext.getBean("departmentAdminService");
        TbEmployee tbEmployee=new TbEmployee();
        tbEmployee.setDepartmentid("1");
        List<TbApplication> applications=departmentAdminService.queryHistoryApplication(tbEmployee);
    }

    @Test
    public void testQueryDepartmentSchedule() throws Exception {
        DepartmentAdminService departmentAdminService= (DepartmentAdminService) applicationContext.getBean("departmentAdminService");
        TbEmployee tbEmployee=new TbEmployee();
        tbEmployee.setDepartmentid("1");
        List<TbDepartmentschedule> departmentschedules=departmentAdminService.queryDepartmentSchedule(tbEmployee);
    }

    @Test
    public void testQueryEmployeeNotify() throws Exception {
        DepartmentAdminService departmentAdminService= (DepartmentAdminService) applicationContext.getBean("departmentAdminService");
        TbEmployee tbEmployee=new TbEmployee();
        tbEmployee.setEmployeeid("2");
        departmentAdminService.queryEmployeeNotify(tbEmployee,false);
    }


    @Test
    public void testQueryActivites() throws Exception {
        DepartmentAdminService departmentAdminService= (DepartmentAdminService) applicationContext.getBean("departmentAdminService");
        TbEmployee tbEmployee=new TbEmployee();
        tbEmployee.setEmployeeid("2");
        departmentAdminService.queryActivites(tbEmployee);
    }



    @Test
    public void testQueryNotifyVo() throws Exception {
        DepartmentAdminService departmentAdminService= (DepartmentAdminService) applicationContext.getBean("departmentAdminService");
        TbEmployee tbEmployee=new TbEmployee();
        tbEmployee.setEmployeeid("2");
        List<TbNotifyVo> tbNotifyVos=departmentAdminService.queryNotifyVo(tbEmployee);
        System.out.println(tbNotifyVos);
    }

    @Test
    public void testUpdateNotifyStatus() throws Exception {
        DepartmentAdminService departmentAdminService= (DepartmentAdminService) applicationContext.getBean("departmentAdminService");
        TbEmployeenotify tbEmployeenotify=new TbEmployeenotify();
        tbEmployeenotify.setNotifyid("1");
        tbEmployeenotify.setEmployeeid("2");
        departmentAdminService.updateNotifyStatus(tbEmployeenotify);
    }

    @Test
    public void testDeleteEmployee() throws Exception {
        DepartmentAdminService departmentAdminService= (DepartmentAdminService) applicationContext.getBean("departmentAdminService");
        TbEmployeeVo tbEmployeeVo=new TbEmployeeVo();
        tbEmployeeVo.getEmployeeids().add("1");
        tbEmployeeVo.getEmployeeids().add("2");
        departmentAdminService.deleteEmployee(tbEmployeeVo);
    }

    @Test
    public void testDeleteSchedule() throws Exception {
        DepartmentAdminService departmentAdminService= (DepartmentAdminService) applicationContext.getBean("departmentAdminService");
        TbDepartmentscheduleVo tbDepartmentscheduleVo=new TbDepartmentscheduleVo();
        tbDepartmentscheduleVo.getScheduleids().add("1");
       tbDepartmentscheduleVo.getScheduleids().add("2");
        departmentAdminService.deleteSchedule(tbDepartmentscheduleVo);
    }
}