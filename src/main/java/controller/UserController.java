package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.*;
import service.userService.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        TbEmployee employee1=userService.queryEmployee(employee);
        if(employee1==null)
        {
            map.put("message","登陆失败");
        }
        else
        {
            map.put("message","登陆成功");
            map.put("user",employee1);
        }
        return map;
    }
    @RequestMapping("/init")
    public @ResponseBody Map<String,Object> init(TbEmployee employee)
    {
        Map<String,Object>map=new HashMap<String, Object>();
        if(employee==null&&employee.getEmployeeid()==null) {
            map.put("message","系统发生异常");
            return map;
        }
        Map<String,List<TbActivityVo1>> activities=userService.queryActivities1(employee.getEmployeeid());
        Map<String,List<TbNotifyVo1>> notifies=userService.selectNotifies(employee.getEmployeeid());
        Map<String,List<TbMemoVo>> memos=userService.selectMemos(employee.getEmployeeid());
        map.put("activities",activities);
        map.put("notifies",notifies);
        map.put("memos",memos);
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
    public @ResponseBody Map<String,Object> addDetail(TbDetail detail)
    {
        Map<String,Object>map=new HashMap<String, Object>();
        if(detail==null&&detail.getStyle()==null&&detail.getEmployeeid()==null&&detail.getReason()==null)
            return null;
        if(userService.addDetail(detail))
            map.put("message","申请成功");
        else
            map.put("message","申请失败");
        return map;
    }
}
