package controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import otherFunction.binding.bindTelephone;
import otherFunction.binding.*;
import otherFunction.md5.Encryption;
import pojo.*;
import service.adminAccountManagementService.AdminAccountManagementService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ZGM on 2017/3/30.
 */
@Controller
@RequestMapping("/AdminAccountManagement")
public class AdminAccountManagementController {
    @Autowired
    private AdminAccountManagementService adminAccountManagementService;

    //查看手机号码和邮箱
    @RequestMapping("/showTelephoneAndEmail")
    public @ResponseBody List<TbEmployee> queryEmployee(TbEmployee tbEmployee)
    {
        String employeeId=tbEmployee.getEmployeeid();
        if(employeeId==null||employeeId=="")
            return null;
        List<TbEmployee> employeeList=adminAccountManagementService.queryEmployee(tbEmployee);

        return employeeList;
    }

    //发送手机短信验证码
    @RequestMapping("/sendMessage")
    public @ResponseBody JSONObject sendMessage(TbEmployee tbEmployee,HttpServletRequest request)throws IOException
    {   System.out.println("test sendMessage Tel:"+tbEmployee.getTelephone());
        JSONObject json = new JSONObject();
        try {
//            int randomNumber = bindTelephone.sendMessage(tbEmployee);
            int randomNumber=123;//测试时用 不用发短信
            if(randomNumber!=0) {
                //将验证码写入Session
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1 * 60);//Session1分钟失效
                session.setAttribute("Verification", randomNumber);
                session.setAttribute("EmployeeId", tbEmployee.getEmployeeid());
                json.put("status", true);
                System.out.println(session.getAttribute("EmployeeId"));
                System.out.println(session.getAttribute("Verification"));
            }
            else  json.put("status",false);
        }
        catch (Exception e) {
            json.put("status",false);
        }
        return json;
    }

    //公司管理员发送手机短信验证码
    @RequestMapping("/sendMessageToCompanyAdmin")
    public @ResponseBody JSONObject sendMessageToCompanyAdmin(TbCompanyrepresentative tbCompanyrepresentative,HttpServletRequest request)throws IOException
    {   System.out.println("test sendMessage Tel:"+tbCompanyrepresentative.getTelephone());
        String companyrepresentativeid = request.getParameter("companyRepresentativeid");
        JSONObject json = new JSONObject();
        try {
//            int randomNumber = bindTelephone.sendMessage(tbEmployee);
            int randomNumber=123;//测试时用 不用发短信
            if(randomNumber!=0) {
                //将验证码写入Session
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(1 * 60);//Session1分钟失效
                session.setAttribute("Verification", randomNumber);
                session.setAttribute("CompanyRepresentativeId", companyrepresentativeid);
                json.put("status", true);
                System.out.println(session.getAttribute("CompanyRepresentativeId"));
                System.out.println(session.getAttribute("Verification"));
            }
            else  json.put("status",false);
        }
        catch (Exception e) {
            json.put("status",false);
        }
        return json;
    }

    //绑定手机
    @RequestMapping("/bindTelephone")
    public @ResponseBody JSONObject bindTelephone(TbEmployee tbEmployee,HttpServletRequest request)
    {   System.out.println("test bindTelephone");
        JSONObject json = new JSONObject();
        try {
        String code = request.getParameter("code");
        String employeeId=tbEmployee.getEmployeeid();
//        String tel=tbEmployee.getTelephone();
//            System.out.println(tel);
//            System.out.println(code);
//            System.out.println(employeeId+" test code eid");
        HttpSession session = request.getSession();
//            System.out.println("test set session:"+session.getAttribute("EmployeeId"));
//            System.out.println(session.getAttribute("Verification"));
        int code2=(int) Integer.parseInt(code);//String转int
        //验证id和验证码是否都正确
        if(session.getAttribute("Verification").equals(code2)&& session.getAttribute("EmployeeId").equals(employeeId)) {
            if (adminAccountManagementService.changeTelephone(tbEmployee))json.put("status",true);
            else json.put("status",false);
        }
        else json.put("status",false);
        }
        catch (Exception e) {
            json.put("status",false);
        }
        return json;
    }

    //公司管理员绑定手机
    @RequestMapping("/companyAdminBindTelephone")
    public @ResponseBody JSONObject companyAdminBindTelephone(TbCompanyrepresentative tbCompanyrepresentative,HttpServletRequest request)
    {
//        System.out.println("test bindTelephone");
        JSONObject json = new JSONObject();
        try {
            String code = request.getParameter("code");
            String companyrepresentativeId=tbCompanyrepresentative.getCompanyrepresentativeid();
            HttpSession session = request.getSession();
            int code2=(int) Integer.parseInt(code);//String转int
            //验证id和验证码是否都正确
            if(session.getAttribute("Verification").equals(code2)&& session.getAttribute("CompanyRepresentativeId").equals(companyrepresentativeId)) {
                if (adminAccountManagementService.changeCompanyAdminTelephone(tbCompanyrepresentative))json.put("status",true);
                else json.put("status",false);
            }
            else json.put("status",false);
        }
        catch (Exception e) {
            json.put("status",false);
        }
        return json;
    }

    //发送邮箱验证链接
    @RequestMapping("/sendEmailCode")
    public @ResponseBody JSONObject sendEmailCode(TbEmployee tbEmployee,HttpServletRequest request)throws IOException
    {   System.out.println("test sendEmailCode Email:"+tbEmployee.getEmail());
        JSONObject json = new JSONObject();
        try {
            String UUID = bindEmail.sendEmailCode(tbEmployee);
           // String UUID2="123";//测试时用 不用发邮件
            if(UUID!=null) {
                //将UUID写入Session
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10 * 60);//Session 10分钟失效
                session.setAttribute("UUID", UUID);
                session.setAttribute("EmployeeId", tbEmployee.getEmployeeid());
                session.setAttribute("Email",tbEmployee.getEmail());
                json.put("status", true);
                    System.out.println(session.getAttribute("EmployeeId"));
                    System.out.println(session.getAttribute("UUID"));
                    System.out.println(session.getAttribute("Email"));
            }
            else  json.put("status",false);
        }
        catch (Exception e) {
            json.put("status",false);
        }
        return json;
    }


    //发送邮箱验证链接给公司管理员
    @RequestMapping("/sendEmailCodeToCompanyAdmin")
    public @ResponseBody JSONObject sendEmailCodeToCompanyAdmin(TbCompanyrepresentative tbCompanyrepresentative,HttpServletRequest request)throws IOException
    {   System.out.println("test sendEmailCode Email:"+tbCompanyrepresentative.getEmail());
        tbCompanyrepresentative.setCompanyrepresentativeid(request.getParameter("companyRepresentativeid"));
        JSONObject json = new JSONObject();
        try {
            String UUID = bindEmail.sendEmailCodeToCompanyAdmin(tbCompanyrepresentative);
            // String UUID2="123";//测试时用 不用发邮件
            if(UUID!=null) {
                //将UUID写入Session
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10 * 60);//Session 10分钟失效
                session.setAttribute("UUID", UUID);
                session.setAttribute("CompanyRepresentativeId", tbCompanyrepresentative.getCompanyrepresentativeid());
                session.setAttribute("CompanyRepresentativeEmail",tbCompanyrepresentative.getEmail());
                json.put("status", true);
                System.out.println(session.getAttribute("CompanyRepresentativeId"));
                System.out.println(session.getAttribute("UUID"));
                System.out.println(session.getAttribute("CompanyRepresentativeEmail"));
            }
            else  json.put("status",false);
        }
        catch (Exception e) {
            json.put("status",false);
        }
        return json;
    }


    @RequestMapping("/checkCompanyAdminBingingEamilInformation")
    public @ResponseBody void checkCompanyAdminBingingEamilInformation(TbCompanyrepresentative tbCompanyrepresentative,HttpServletRequest request,
                                             HttpServletResponse response)throws IOException{
        System.out.println("test run checkCompanyAdminBingingEamilInformation");
        JSONObject json = new JSONObject();
        Writer writer = response.getWriter();
        String companyRepresentativeId = request.getParameter("CompanyrepresentativeId");
        String email = request.getParameter("Email");
        String UUID = request.getParameter("UUID");
        String createTime = request.getParameter("CreateTime");
//            System.out.println("test checkCompanyAdminBingingEamilInformation Eid:"+employeeId);
//            System.out.println("test UUID:"+UUID);
//            System.out.println("test email:"+email);
//        tbEmployee取不倒Eid的值，通过request域中从进来，再赋值给tbEmployee
        tbCompanyrepresentative.setCompanyrepresentativeid(companyRepresentativeId);
        //取出Session中的值
        HttpSession session = request.getSession();
        String sCompanyRepresentativeId= (String) session.getAttribute("CompanyRepresentativeId");
        String sEmail= (String) session.getAttribute("CompanyRepresentativeEmail");
        String sUUID= (String) session.getAttribute("UUID");
//            System.out.println("test set session:"+sEmployeeId);
//            System.out.println(sEmail);
//            System.out.println(sUUID);

        if(sCompanyRepresentativeId.equals(companyRepresentativeId) && sEmail.equals(email) && sUUID.equals(UUID)) {
            if(bindEmail.checkEmailCode(createTime)) {
                if(adminAccountManagementService.changeCompanyAdminEmail(tbCompanyrepresentative))
                    writer.write("Success");
                else writer.write("Fail");
            }
            else writer.write("Fail");
        }
        else writer.write("Fail");
    }


    @RequestMapping("/checkBingingEamilInformation")
    public @ResponseBody void checkEmailCode(TbEmployee tbEmployee,HttpServletRequest request,
                                                   HttpServletResponse response)throws IOException{
        System.out.println("test run checkBingingEamilInformation");
        JSONObject json = new JSONObject();
        Writer writer = response.getWriter();
        String employeeId = request.getParameter("EmployeeId");
        String email = request.getParameter("Email");
        String UUID = request.getParameter("UUID");
        String createTime = request.getParameter("CreateTime");
//            System.out.println("test checkBingingEamilInformation Eid:"+employeeId);
//            System.out.println("test UUID:"+UUID);
//            System.out.println("test email:"+email);
//        tbEmployee取不倒Eid的值，通过request域中从进来，再赋值给tbEmployee
        tbEmployee.setEmployeeid(employeeId);
        //取出Session中的值
        HttpSession session = request.getSession();
        String sEmployeeId= (String) session.getAttribute("EmployeeId");
        String sEmail= (String) session.getAttribute("Email");
        String sUUID= (String) session.getAttribute("UUID");
//            System.out.println("test set session:"+sEmployeeId);
//            System.out.println(sEmail);
//            System.out.println(sUUID);

        if(sEmployeeId.equals(employeeId) && sEmail.equals(email) && sUUID.equals(UUID)) {
            if(bindEmail.checkEmailCode(createTime)) {
                if(adminAccountManagementService.changeEmail(tbEmployee))
                    writer.write("Success");
                else writer.write("Fail");
            }
            else writer.write("Fail");
        }
        else writer.write("Fail");
    }

    //管理员修改密码
    @RequestMapping("/changePassword")
    public @ResponseBody JSONObject queryApplications(TbEmployee tbEmployee)
    {   System.out.println("test changePassword");
        JSONObject json = new JSONObject();
        String password=tbEmployee.getPassword();
        if(password==null||password=="") {
            json.put("status", false);
        }
        else {
            if (adminAccountManagementService.changePassword(tbEmployee))json.put("status",true);
            else json.put("status",false);
        }
        return json;
    }

    //公司管理员修改密码
    @RequestMapping("/companyAdminChangePassword")
    public @ResponseBody JSONObject companyAdminChangePassword(TbCompanyrepresentative companyAdminChangePassword)
    {   System.out.println("test companyAdminChangePassword");
        JSONObject json = new JSONObject();
        String password=companyAdminChangePassword.getPassword();
        if(password==null||password=="") {
            json.put("status", false);
        }
        else {
            if (adminAccountManagementService.companyAdminChangePassword(companyAdminChangePassword))json.put("status",true);
            else json.put("status",false);
        }
        return json;
    }

    //管理员密码验证
    @RequestMapping("/verification")
    public @ResponseBody JSONObject verification(TbEmployee tbEmployee)
    {   System.out.println("test verification");
        JSONObject json = new JSONObject();
        String password=tbEmployee.getPassword();
        if(password==null||password=="") {
            json.put("status", false);
        }
        else {
            List<TbEmployee> employeeList = adminAccountManagementService.verification(tbEmployee);
            TbEmployee tbEmployee2 = employeeList.get(0);
            System.out.println(password);
            System.out.println(tbEmployee2.getPassword()+" tbEmployee2.getPassword()");
            if (password .equals(tbEmployee2.getPassword()) )json.put("status", true);
            else json.put("status", false);
        }
        return json;
    }

    //公司管理员密码验证
    @RequestMapping("/verificationCompanyAdmin")
    public @ResponseBody JSONObject verificationCompanyAdmin(TbCompanyrepresentative tbCompanyrepresentative)
    {   System.out.println("test verification");
        JSONObject json = new JSONObject();
        String password=tbCompanyrepresentative.getPassword();
        String MD5password= Encryption.generatePassword(password);
        if(password==null||password=="") {
            json.put("status", false);
        }
        else {
            List<TbCompanyrepresentative> companyrepresentativeList = adminAccountManagementService.verificationCompanyAdmin(tbCompanyrepresentative);
            TbCompanyrepresentative tbCompanyrepresentative2 = companyrepresentativeList.get(0);
            System.out.println(password);
            System.out.println(tbCompanyrepresentative2.getPassword()+" tbEmployee2.getPassword()");
            if (MD5password .equals(tbCompanyrepresentative2.getPassword()) )json.put("status", true);
            else json.put("status", false);
        }
        return json;
    }

    //公司管理员查看该公司的部门列表
    @RequestMapping("/selectDepartment")
    public @ResponseBody List<TbDepartment> selectDepartment(TbDepartment tbDepartment){
        String companyId=tbDepartment.getCompanyid();
        if(companyId==null||companyId=="")
            return null;
        List<TbDepartment> departmentList=adminAccountManagementService.queryDepartment(tbDepartment);

        return departmentList;
    }

    //查看公司列表
    @RequestMapping("/selectCompany")
    public @ResponseBody List<TbCompany> selectCompany(TbCompany tbCompany){
        String companyrepResentativeId=tbCompany.getCompanyrepresentativeid();
        if(companyrepResentativeId==null||companyrepResentativeId=="")
            return null;
        List<TbCompany> companyList=adminAccountManagementService.queryCompany(tbCompany);

        return companyList;
    }

    //公司管理员新增通知
    @RequestMapping("/addNotify")
    public @ResponseBody JSONObject addNotify(TbNotify tbNotify,HttpServletRequest request){
        JSONObject json = new JSONObject();
        if(adminAccountManagementService.addNotify(tbNotify,request))
            json.put("status", true);
        else
            json.put("status", false);
        return json;
    }

    @RequestMapping("/addEmployeeNotify")
    public @ResponseBody JSONObject addEmployeeNotify(TbEmployeenotify tbEmployeenotify,HttpServletRequest request){
        JSONObject json = new JSONObject();
        if(adminAccountManagementService.addEmployeeNotify(tbEmployeenotify,request))
            json.put("status", true);
        else
            json.put("status", false);
        return json;
    }

    @RequestMapping("/getDepartmentEmployeeId")
    public @ResponseBody List<TbEmployee> getDepartmentEmployeeId(TbEmployeeVo tbEmployeeVo){
//        System.out.println(tbEmployeeVo.getDepartmentids());
//        System.out.println("test4");
        List<TbEmployee> employeeList=adminAccountManagementService.getDepartmentEmployeeId(tbEmployeeVo);

        return employeeList;
    }

    @RequestMapping("/addActivity")
    public @ResponseBody JSONObject addActivity(TbActivity tbActivity,HttpServletRequest request,String starttime1,String endtime1) {
        JSONObject json = new JSONObject();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date d1=format.parse(starttime1);
            Date d2=format.parse(endtime1);
            tbActivity.setStarttime(d1);
            tbActivity.setEndtime(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (adminAccountManagementService.addActivity(tbActivity, request))
            json.put("status", true);
        else
            json.put("status", false);
        return json;
    }

    @RequestMapping("/departmentGetCompanyId")
    public @ResponseBody List<TbDepartment> departmentGetCompanyId(TbDepartment tbDepartment){
        List<TbDepartment> departmentList = adminAccountManagementService.departmentGetCompanyId(tbDepartment);
        return departmentList;
    }

    @RequestMapping("/getEmployeeList")
    public @ResponseBody List<TbEmployee> getEmployeeList(TbEmployee tbEmployee){
//        System.out.println(tbEmployee.getDepartmentid());
        List<TbEmployee> employeeList = adminAccountManagementService.getEmployeeList(tbEmployee);

        return employeeList;
    }

    @RequestMapping("/getCompanyAdminInforMation")
    public @ResponseBody List<TbCompanyrepresentative> getCompanyAdminInforMation(TbCompanyrepresentative tbCompanyrepresentative){
//        System.out.println(tbEmployee.getDepartmentid());
        List<TbCompanyrepresentative> companyAdminList = adminAccountManagementService.getCompanyAdminInforMation(tbCompanyrepresentative);

        return companyAdminList;
    }

}