package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pojo.TbDepartment;
import pojo.TbDepartmentVo;
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
        companyAdminService.addCompany(file,companyid);
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

