package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pojo.TbDepartment;
import pojo.TbDepartmentVo;
import pojo.TbEmployee;
import service.companyAdminService.CompanyAdminService;

import java.util.List;

/**
 * Created by user on 2017/4/13.
 */
@Controller
@RequestMapping("/CompanyAdmin")
public class CompanyAdminController {

    @Autowired
    private CompanyAdminService companyAdminService;

    @RequestMapping("/uploadExcel")
    public String uploadExcel(MultipartFile file,String companyid)
    {
        System.out.println(file);
        if(companyid==null||companyid.equals("")||file==null)
            return null;
        companyAdminService.addDepartments(file,companyid);
        return "redirect:/companyAdmin1.html";
    }

    @RequestMapping("/getDepartments")
    public @ResponseBody List<TbDepartment> getDepartments(String companyid)
    {
        if(companyid==null&&companyid.equals(""))
            return null;
        List<TbDepartment> departments=companyAdminService.getDepartments(companyid);
        return departments;
    }
    @RequestMapping("/addDepartment")
      public @ResponseBody String addDepartment(TbDepartment department)
    {
        if(department==null)
            return null;
        String name=department.getName();
        String address=department.getAddress();
        String mac=department.getMac();
        if(name==null&&name.equals("")||address==null&&address.equals("")||mac==null&&mac.equals(""))
            return null;
        if(companyAdminService.addOneDepartment(department))
            return "success";

        return null;
    }

    @RequestMapping("/updateDepartment")
    public @ResponseBody String updateDepartment(TbDepartmentVo departmentVo)
    {
        if(departmentVo==null)
            return null;
        String name=departmentVo.getName();
        String address=departmentVo.getAddress();
        String mac=departmentVo.getMac();
        List<String>departmentids=departmentVo.getDepartmentids();
        if(name==null&&name.equals("")||address==null&&address.equals("")||mac==null&&mac.equals("")||departmentids==null&&departmentids.size()<1)
            return null;
        if(companyAdminService.updateDepartment(departmentVo))
            return "success";
        return null;
    }
    @RequestMapping("/getDepartmentAdmin")
    public @ResponseBody List<TbEmployee> getDepartmentAdmins(String departmentid)
    {
        if(departmentid==null&&departmentid.equals(""))
            return null;
        return companyAdminService.getDepartmentAdmin(departmentid);
    }
    @RequestMapping("/deleteDepartments")
    public @ResponseBody String deleteDeparments(TbDepartmentVo departmentVo)
    {
        if(departmentVo==null||departmentVo.getDepartmentids()==null||departmentVo.getDepartmentids().size()==0)
            return null;
        if(companyAdminService.deleteDepartments(departmentVo))
            return "success";
        return null;
    }
}

