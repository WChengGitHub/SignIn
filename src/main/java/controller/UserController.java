package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.*;
import service.userService.UserService;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by user on 2017/4/20.
 */
@Controller
@RequestMapping("/UserController")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/signIn")
    public @ResponseBody Map<String,Object> signIn(TbEmployee employee)
    {
        Map<String,Object>map=new HashMap<String, Object>();
        if(employee==null&&employee.getPassword()==null&&employee.getAccount()==null) {
            map.put("message","系统发生异常");
            return map;
        }
        TbEmployeeVo1 tbEmployeeVo1=userService.queryEmployee1(employee);
        if(tbEmployeeVo1==null)
        {
            map.put("message","登陆失败，请检查用户名和密码是否正确");
        }
        else
        {
            map.put("message","登陆成功");
            map.put("user",tbEmployeeVo1);
        }
        return map;
    }
    @RequestMapping("/init")
    public @ResponseBody Map<String,Object> init(String employeeid,String year,String month)
    {
        Map<String,Object>map=new HashMap<String, Object>();
        if(employeeid==null&&year==null&&month==null) {
            map.put("message","系统发生异常");
            return map;
        }
        List<TbActivityVo1> activities=userService.queryActivities3(employeeid, year, month);
        List<TbNotifyVo1> notifies=userService.selectNotifies2(employeeid, year, month);
        List<TbMemoVo> memos=userService.selectMemos2(employeeid, year, month);
        List<TbDailyAttendanceVo> dailyattendances=userService.selectDailyattendance1(employeeid, year, month);
        String workTime=userService.getWorkHours(dailyattendances);
        map.put("activities",activities);
        map.put("notifies",notifies);
        map.put("memos",memos);
        map.put("dailyattendances",dailyattendances);
        map.put(year+"/"+month,workTime);
        return map;
    }
    @RequestMapping("/updateNotifyStatus")
    public @ResponseBody void updateNotifyStatus(TbEmployeenotify tbEmployeenotify)
    {
        String employId=tbEmployeenotify.getEmployeeid();
        String notifyid=tbEmployeenotify.getNotifyid();
        if(employId==null||employId.equals("")||notifyid==null||notifyid.equals(""))
            return;
        userService.updateNotifyStatus(tbEmployeenotify);
    }

    @RequestMapping("/updateActivityStatus")
        public @ResponseBody void updateActivityStatus(TbActivityattendance tbActivityattendance)
        {
            String employId=tbActivityattendance.getEmployeeid();
            String activityid=tbActivityattendance.getActivityid();
            if(employId==null||employId.equals("")||activityid==null||activityid.equals(""))
                return;
            userService.updateActivityStatus(tbActivityattendance,"9");
    }

    @RequestMapping("/addDetail")
    public @ResponseBody Map<String,Object> addDetail(TbDetail detail,String startTime,String endTime)
    {
        Map<String,Object>map=new HashMap<String, Object>();
        if(detail==null&&detail.getEmployeeid()==null&&detail.getReason()==null&&startTime==null&&endTime==null)
            return null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1=format.parse(startTime);
            Date d2=format.parse(endTime);
            detail.setStarttime(d1);
            detail.setEndtime(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        detail.setStyle(false);
        if(userService.addDetail(detail))
            map.put("message","申请成功");
        else
            map.put("message","申请失败");
        return map;
    }

    @RequestMapping("/dailyAttendanceSignIn")
    public @ResponseBody Map<String,Object> DailyAttendanceSignIn(TbDepartmentScheduleVo1 tbDepartmentScheduleVo1)
    {
        Map<String,Object>map=new HashMap<String, Object>();
        if(tbDepartmentScheduleVo1==null&&tbDepartmentScheduleVo1.getEmployeeid()==null)
            return null;
        TbDepartmentScheduleVo1 departmentScheduleVo1=userService.DailyAttendanceSignIn(tbDepartmentScheduleVo1);
        map.put("departmentScheduleVo1",departmentScheduleVo1);
        return map;
    }
    @RequestMapping("/activitySignIn")
     public @ResponseBody Map<String,Object> ActivitySignIn(TbActivityattendance activityattendance)
    {
        Map<String,Object>map=new HashMap<String, Object>();
        if(activityattendance==null&&activityattendance.getEmployeeid()==null&&activityattendance.getActivityid()==null)
            return null;
        String Status=userService.ActivitySignIn(activityattendance);
        map.put("Status",Status);
        return map;
    }

    @RequestMapping("/dailyAttendanceSignOut")
    public @ResponseBody Map<String,Object> DailyAttendanceSignOut(TbDepartmentScheduleVo1 tbDepartmentScheduleVo1)
    {
        Map<String,Object>map=new HashMap<String, Object>();
        if(tbDepartmentScheduleVo1==null&&tbDepartmentScheduleVo1.getEmployeeid()==null&&tbDepartmentScheduleVo1.getScheduleid()==null)
            return null;
        String Status=userService.DailyAttendanceSignOut(tbDepartmentScheduleVo1);
        map.put("Status",Status);
        return map;
    }
    @RequestMapping("/activitySignOut")
    public @ResponseBody Map<String,Object> ActivitySignOut(TbActivityattendance activityattendance)
    {
        Map<String,Object>map=new HashMap<String, Object>();
        if(activityattendance==null&&activityattendance.getEmployeeid()==null&&activityattendance.getActivityid()==null)
            return null;
        String Status=userService.ActivitySignOut(activityattendance);
        map.put("Status",Status);
        return map;
    }

    @RequestMapping("/addMemo")
    public @ResponseBody Map<String,Object> addMemo(TbMemo memo,String startTime,String endTime)
    {
        Map<String,Object>map=new HashMap<String, Object>();
        if(memo==null&&memo.getEmployeeid()==null&&memo.getContent()==null&&startTime==null&&endTime==null)
            return null;
        if(userService.addMemos(memo,startTime,endTime))
            map.put("message","success");
        else
            map.put("message","failure");
        return map;
    }
    @RequestMapping("/updateMemo")
    public @ResponseBody Map<String,Object> updateMemo(TbMemo memo,String startTime,String endTime)
    {
        Map<String,Object>map=new HashMap<String, Object>();
        if(memo==null&&memo.getMemoid()==null)
            return null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1=new Date();
        Date d2=new Date();
        try {
            if(startTime!=null&&!startTime.equals("")) {
                d1 = format.parse(startTime);
                memo.setStarttime(d1);
            }
            if(endTime!=null&&!startTime.equals(""))
            {
                d2=format.parse(endTime);
                memo.setEndtime(d2);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(userService.updateMemos(memo))
            map.put("message","success");
        else
            map.put("message","failure");
        return map;
    }
    public static void main(String[]args)
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-Dao.xml","spring/applicationContext-Service.xml","spring/applicationContext-transaction.xml"});
        UserService userService= (UserService) applicationContext.getBean("userService");
        String employeeid="11";
        String year="2017";
        String month="05";
        Map<String,Object>map=new HashMap<String, Object>();
     List<TbActivityVo1> activities=userService.queryActivities3(employeeid, year, month);
      List<TbNotifyVo1> notifies=userService.selectNotifies2(employeeid, year, month);
        List<TbMemoVo> memos=userService.selectMemos2(employeeid, year, month);
        List<TbDailyAttendanceVo> dailyattendances=userService.selectDailyattendance1(employeeid, year, month);
        System.out.println(userService.getWorkHours(dailyattendances));
        map.put("activities",activities);
       map.put("notifies",notifies);
        map.put("memos",memos);
        map.put("dailyattendances",dailyattendances);
        String jsonText = JSON.toJSONString(map, true);
        System.out.println(jsonText);
    }

    @RequestMapping("/go")
    public String error()
    {
        return "forward:/UserController/go";
    }
}
