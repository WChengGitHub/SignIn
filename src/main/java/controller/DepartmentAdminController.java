package controller;

import com.alibaba.fastjson.JSONArray;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pojo.*;
import service.departmentAdminService.DepartmentAdminService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2017/3/26.
 */
@Controller
@RequestMapping("/DepartmentAdmin")
public class DepartmentAdminController {
    @Autowired
    private DepartmentAdminService departmentAdminService;

    @RequestMapping("/queryEmployee")
    public @ResponseBody List<TbEmployee> queryEmployee(TbEmployee tbEmployee)
    {
        String departmentId=tbEmployee.getDepartmentid();
        if(departmentId==null||departmentId.equals(""))
            return null;
        List<TbEmployee> employeeList=departmentAdminService.queryEmployee(tbEmployee);

        return employeeList;
    }

    @RequestMapping("/queryApplications")
    public @ResponseBody List<TbApplication> queryApplications(TbEmployee tbEmployee)
    {
        String departmentId=tbEmployee.getDepartmentid();
        if(departmentId==null||departmentId.equals(""))
            return null;
        List<TbApplication> applications=departmentAdminService.queryApplication(tbEmployee);
        return applications;
    }
    @RequestMapping("/queryHistoryApplications")
    public @ResponseBody List<TbApplication> queryHistoryApplications(TbEmployee tbEmployee)
    {
        String departmentId=tbEmployee.getDepartmentid();
        if(departmentId==null||departmentId.equals(""))
            return null;
        List<TbApplication> applications=departmentAdminService.queryHistoryApplication(tbEmployee);
        return applications;
    }

    @RequestMapping("/queryDepartmentSchedules")
    public @ResponseBody List<TbDepartmentschedule> queryDepartmentSchedules(TbEmployee tbEmployee)
    {
        String departmentId=tbEmployee.getDepartmentid();
        if(departmentId==null||departmentId.equals(""))
            return null;
        List<TbDepartmentschedule> departmentschedules=departmentAdminService.queryDepartmentSchedule(tbEmployee);
        return departmentschedules;
    }

    @RequestMapping("/queryNotifies")
    public @ResponseBody List<TbNotifyVo> queryNotifies(TbEmployee tbEmployee,boolean status)
    {
        String employId=tbEmployee.getEmployeeid();
        if(employId==null||employId.equals(""))
            return null;
        List<TbNotifyVo> notifies=departmentAdminService.queryNotifyVo(tbEmployee);
        return notifies;
    }

    @RequestMapping("/queryActivites")
    public @ResponseBody List<TbActivity> queryActivites(TbEmployee tbEmployee)
    {
        String employId=tbEmployee.getEmployeeid();
        if(employId==null||employId.equals(""))
            return null;
        List<TbActivity> activities=departmentAdminService.queryActivites(tbEmployee);
        return activities;
    }

    @RequestMapping("/updateNotifyStatus")
    public @ResponseBody void updateNotifyStatus(TbEmployeenotify tbEmployeenotify)
    {
        String employId=tbEmployeenotify.getEmployeeid();
        String notifyid=tbEmployeenotify.getNotifyid();
        if(employId==null||employId.equals("")||notifyid==null||notifyid.equals(""))
            return;
        departmentAdminService.updateNotifyStatus(tbEmployeenotify);
    }

    @RequestMapping("/uploadExcel")
    public String uploadExcel(MultipartFile file,String departmentid)
    {
        System.out.println(file);
        if(file==null||departmentid==null||departmentid.equals(""))
            return null;
        departmentAdminService.addEmployee(file,departmentid);

        return "redirect:/departmentAdmin.html";
//        List<TbEmployee> employees=new LinkedList<TbEmployee>();
//        try {
//            Workbook wb= WorkbookFactory.create(file.getInputStream());
//            Sheet sheet=wb.getSheetAt(0);
//            int length=sheet.getLastRowNum();
//            System.out.println(length);
//            for(int i=2;i<=sheet.getLastRowNum();i++)
//            {
//                Row row=sheet.getRow(i);
//                TbEmployee employee=new TbEmployee();
//                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
//                employee.setAccount(row.getCell(0).getStringCellValue());
//                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
//                employee.setPassword(row.getCell(1).getStringCellValue());
//                employees.add(employee);
//            }
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        System.out.println(employees);
    }

    @RequestMapping("deleteEmployeeids")
    public  @ResponseBody String deleteEmployeeids(TbEmployeeVo tbEmployeeVo)
    {
        if(tbEmployeeVo==null||tbEmployeeVo.getEmployeeids()==null||tbEmployeeVo.getEmployeeids().size()==0)
            return null;
        if(departmentAdminService.deleteEmployee(tbEmployeeVo))
            return "success";
        return null;
    }

    @RequestMapping("deleteDepartmentSchedules")
    public  @ResponseBody String deleteDepartmentSchedules(TbDepartmentscheduleVo tbDepartmentscheduleVo)
    {
        if(tbDepartmentscheduleVo==null||tbDepartmentscheduleVo.getScheduleids()==null||tbDepartmentscheduleVo.getScheduleids().size()==0)
            return null;
        if(departmentAdminService.deleteSchedule(tbDepartmentscheduleVo))
        return "success";
        return null;
    }

//    @RequestMapping(value="/exportExcel",method= RequestMethod.POST)
//    public ModelAndView exportExcel(ModelMap model, HttpServletRequest request, HttpServletResponse response,TbEmployee employee) {
//        ViewExcel viewExcel = new ViewExcel();
//        Map<String, Object> obj = null;
//
//        //获取数据库表生成的workbook
//        Map<String, Object> condition = new HashMap<String, Object>();
//        HSSFWorkbook workbook = departmentAdminService.getEmployeeExcel(employee);
//        try {
//            viewExcel.buildExcelDocument(obj, workbook, request, response);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return new ModelAndView(viewExcel, model);
//    }
}
