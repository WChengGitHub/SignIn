package service.userService;

import mapper.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 2017/4/20.
 */
@Service
public class UserService {
    @Autowired
    private MultiFormMapper multiFormMapper;

    @Autowired
    private TbMemoMapper memoMapper;

    @Autowired
    private TbEmployeeMapper employeeMapper;

    @Autowired
    private TbEmployeenotifyMapper tbEmployeenotifyMapper;

    @Autowired
    private TbActivityattendanceMapper tbActivityattendanceMapper;

    public List<TbActivityVo> queryActivities(String employeeid)
    {
        List<TbActivityVo> activityVos=multiFormMapper.selectActivityByEmployeeid(employeeid);
        return  activityVos;
    }

    public List<TbNotifyVo> queryNotifies(String employeeid)
    {
        List<TbNotifyVo> notifyVos=multiFormMapper.selectNotify(employeeid);
        return notifyVos;
    }

    public List<TbMemo> queryMemos(String employeeid)
    {
        TbMemoExample memoExample=new TbMemoExample();
        TbMemoExample.Criteria criteria=memoExample.createCriteria();
        criteria.andEmployeeidEqualTo(employeeid);
        Date d1=new Date();
        Calendar now =Calendar.getInstance();
        now.setTime(d1);
        now.set(Calendar.DATE,now.get(Calendar.DATE)-365);
        Date d2=now.getTime();
        criteria.andStarttimeBetween(d2,d1);
        List<TbMemo> memos=memoMapper.selectByExample(memoExample);
        return memos;
    }

    public TbEmployee queryEmployee(TbEmployee employee)
    {
        TbEmployeeExample employeeExample=new TbEmployeeExample();
        TbEmployeeExample.Criteria criteria=employeeExample.createCriteria();
        criteria.andEmployeeidEqualTo(employee.getEmployeeid());
        criteria.andPasswordEqualTo(employee.getPassword());
        List<TbEmployee>employees=employeeMapper.selectByExample(employeeExample);
        if(employees!=null&&employees.size()==1)
        {
            employee=employees.get(0);
            employee.setPassword("");
        }
        return null;
    }

    public void updateNotifyStatus(TbEmployeenotify employeenotify)
    {
        employeenotify.setStatus(true);
        tbEmployeenotifyMapper.updateByPrimaryKey(employeenotify);
    }

    public void updateActivityStatus(TbActivityattendance activityattendance)
    {
        activityattendance.setStatus("9");
        TbActivityattendanceExample activityattendanceExample=new TbActivityattendanceExample();
        TbActivityattendanceExample.Criteria criteria=activityattendanceExample.createCriteria();
        criteria.andEmployeeidEqualTo(activityattendance.getEmployeeid());
        criteria.andActivityidEqualTo(activityattendance.getActivityid());
        tbActivityattendanceMapper.updateByExampleSelective(activityattendance,activityattendanceExample);
    }
}
