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

    @RequestMapping("/init")
    public @ResponseBody Map<String,Object> init(TbEmployee employee)
    {
        Map<String,Object>map=new HashMap<String, Object>();
        if(employee==null&&employee.getPassword()==null&&employee.getEmployeeid()==null) {
            map.put("error","系统发生异常");
            return map;
        }
        TbEmployee employee1=userService.queryEmployee(employee);
        if(employee1==null)
        {
            map.put("error","登陆失败");
        }
        List<TbActivityVo>activityVos=userService.queryActivities(employee.getEmployeeid());
        List<TbMemo> memos=userService.queryMemos(employee.getEmployeeid());
        List<TbNotifyVo> notifyVos=userService.queryNotifies(employee.getEmployeeid());
        map.put("employee",employee1);
        map.put("activities",activityVos);
        map.put("notifies",notifyVos);
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
        userService.updateActivityStatus(tbActivityattendance);
    }
}
