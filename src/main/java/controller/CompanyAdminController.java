package controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pojo.*;
import service.companyAdminService.CompanyAdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    @RequestMapping("/queryActivities")
    public @ResponseBody List<TbActivity> queryActivities(String companyrepresentativeid)
    {
        if(companyrepresentativeid==null&&companyrepresentativeid.equals(""))
            return null;
        return  companyAdminService.queryActivities(companyrepresentativeid);
    }
    @RequestMapping("/queryNotifies")
    public @ResponseBody List<TbNotify> queryNotifies(String companyrepresentativeid)
    {
        if(companyrepresentativeid==null&&companyrepresentativeid.equals(""))
            return null;
        return  companyAdminService.queryNotifies(companyrepresentativeid);
    }


    //公司管理员注册，发送手机短信验证码
    @RequestMapping("/registerSendMessage")
    public @ResponseBody JSONObject registerSendMessage(HttpServletRequest request)throws IOException
    {   System.out.println("test registerSendMessage Tel:"+request.getParameter("telephone"));
        String Tel = request.getParameter("telephone");
        JSONObject json = new JSONObject();
        try {
//             int randomNumber = registerBindTelephone.sendMessage(Tel);
            int randomNumber=123;//测试时用 不用发短信
            if(randomNumber!=0) {
                //将验证码写入Session
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1 * 60);//Session1分钟失效
                session.setAttribute("registerVerification", randomNumber);
                session.setAttribute("registerTelephone",Tel);
//                session.setAttribute("EmployeeId", tbEmployee.getEmployeeid());
                json.put("status", true);
//                System.out.println(session.getAttribute("EmployeeId"));
                System.out.println(session.getAttribute("registerVerification"));
            }
            else  json.put("status",false);
        }
        catch (Exception e) {
            json.put("status",false);
        }
        return json;
    }



    @RequestMapping("/companyAdminLogin")
    public @ResponseBody JSONObject verification(TbCompanyrepresentative tbCompanyrepresentative)
    {
        System.out.println(tbCompanyrepresentative.getTelephone());
        System.out.println("test verification CompanyLogin");
        JSONObject json = new JSONObject();
//        String password=tbCompanyrepresentative.getPassword();
        String result=companyAdminService.login(tbCompanyrepresentative);
        if(result==null)
            json.put("status", "登录失败");
//        else {
//            TbCompanyrepresentative tbCompanyrepresentative2 = companyrepresentativeList.get(0);
//            System.out.println(password);
//            System.out.println(tbCompanyrepresentative2.getPassword() + " tbCompanyrepresentative2.getPassword()");
//            if (password.equals(tbCompanyrepresentative2.getPassword())) json.put("status", true);
        else json.put("status", result);
//        }
        return json;
    }

    @RequestMapping("/register")
    public @ResponseBody JSONObject register(TbCompanyrepresentative tbCompanyrepresentative,HttpServletRequest request) {
        JSONObject json = new JSONObject();
        try{
        String code = request.getParameter("code");
        int code2 = (int) Integer.parseInt(code);//String转int
        HttpSession session = request.getSession();
        String Tel = (String)session.getAttribute("registerTelephone");
        if (session.getAttribute("registerVerification").equals(code2)){
            tbCompanyrepresentative.setTelephone(Tel);
            if (companyAdminService.register(tbCompanyrepresentative)) json.put("status", true);
            else json.put("status", false);
        }
        else json.put("status",false);
        }
        catch (Exception e) {
                json.put("status",false);
                }
        return json;
    }

}

