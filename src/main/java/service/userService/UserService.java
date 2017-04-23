package service.userService;

import mapper.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;
import utils.GetId;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by user on 2017/4/20.
 */
@Service
public class UserService {
    @Autowired
    private TbActivityMapper activityMapper;

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

    @Autowired
    private TbDetailMapper detailMapper;

    public List<TbActivityVo> queryActivities(String employeeid)
    {
        List<TbActivityVo> activityVos=multiFormMapper.selectActivityByEmployeeid(employeeid);
        return  activityVos;
    }

    public Map<String,List<TbActivityVo1>> queryActivities1(String employeeid)
    {
            Map<String,List<TbActivityVo1>>map=new HashMap<String, List<TbActivityVo1>>();

            Date d0=new Date();
            Calendar now =Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            TbActivityVo1 tbActivityVo1=new TbActivityVo1();
            tbActivityVo1.setEmployeeid(employeeid);
            for(int i=0;i<365;i++)
            {
                List<TbActivityVo1> tbActivityVo1s=null;

                now.setTime(d0);
                now.set(Calendar.DATE,now.get(Calendar.DATE)-i);
                Date d1=now.getTime();
                Date d2=new Date();

                String year=String.format("%tY",d1);
                String month=String.format("%tm",d1);
                String day=String.format("%td",d1);

                int year1=Integer.parseInt(year);
                int month1=Integer.parseInt(month);
                int day1=Integer.parseInt(day);

                String d1String=year+"-"+month+"-"+day+" "+"00:00:00";
                String d2String=year+"-"+month+"-"+day+" "+"23:59:59";

                String key=year+"/"+month+"/"+day;
                try {
                    d1=format.parse(d1String);
                    d2=format.parse(d2String);

                    tbActivityVo1.setD1(d1);
                    tbActivityVo1.setD2(d2);
                    tbActivityVo1s=multiFormMapper.selectActivities(tbActivityVo1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(tbActivityVo1s!=null&&tbActivityVo1s.size()!=0)
                {
                    int size=tbActivityVo1s.size();
                    for(int j=0;j<size;j++)
                    {
                        tbActivityVo1s.get(j).setYear(year1);
                        tbActivityVo1s.get(j).setDay(day1);
                        tbActivityVo1s.get(j).setMonth(month1);
                    }

                }
                map.put(key,tbActivityVo1s);
//                System.out.println("d1String:"+d1String+"d2String:"+d2String);
//                System.out.println("d1:"+d1+" d2:"+d2);
            }

        return map;
    }
    public List<TbNotifyVo> queryNotifies(String employeeid)
    {
        List<TbNotifyVo> notifyVos=multiFormMapper.selectNotify(employeeid);
        return notifyVos;
    }
    public Map<String,List<TbNotifyVo1>> selectNotifies(String employeeid)
    {
        Map<String,List<TbNotifyVo1>>map=new HashMap<String, List<TbNotifyVo1>>();
        Date d0=new Date();
        Calendar now =Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        TbNotifyVo1 tbNotifyVo1=new TbNotifyVo1();
        tbNotifyVo1.setEmployeeid(employeeid);
        for(int i=0;i<365;i++)
        {
            List<TbNotifyVo1>tbNotifyVo1s=null;
            now.setTime(d0);
            now.set(Calendar.DATE,now.get(Calendar.DATE)-i);
            Date d1=now.getTime();
            Date d2=new Date();

            String year=String.format("%tY",d1);
            String month=String.format("%tm",d1);
            String day=String.format("%td",d1);

            int year1=Integer.parseInt(year);
            int month1=Integer.parseInt(month);
            int day1=Integer.parseInt(day);

            String d1String=year+"-"+month+"-"+day+" "+"00:00:00";
            String d2String=year+"-"+month+"-"+day+" "+"23:59:59";

            String key=year+"/"+month+"/"+day;
            try {
                d1=format.parse(d1String);
                d2=format.parse(d2String);

                tbNotifyVo1.setD1(d1);
                tbNotifyVo1.setD2(d2);
                tbNotifyVo1s=multiFormMapper.selectNotifies(tbNotifyVo1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(tbNotifyVo1s!=null&&tbNotifyVo1s.size()!=0)
            {
                int size=tbNotifyVo1s.size();
                for(int j=0;j<size;j++)
                {
                    tbNotifyVo1s.get(j).setYear(year1);
                    tbNotifyVo1s.get(j).setDay(day1);
                    tbNotifyVo1s.get(j).setMonth(month1);
                }

            }
            map.put(key,tbNotifyVo1s);
//                System.out.println("d1String:"+d1String+"d2String:"+d2String);
//                System.out.println("d1:"+d1+" d2:"+d2);
        }

        return map;
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
    public Map<String,List<TbMemoVo>> selectMemos(String employeeid)
    {
        Map<String,List<TbMemoVo>>map=new HashMap<String, List<TbMemoVo>>();
        Date d0=new Date();
        Calendar now =Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        TbMemoVo tbMemoVo=new TbMemoVo();
        tbMemoVo.setEmployeeid(employeeid);
        for(int i=0;i<365;i++)
        {
            List<TbMemoVo>tbMemoVos=null;
            now.setTime(d0);
            now.set(Calendar.DATE,now.get(Calendar.DATE)-i);
            Date d1=now.getTime();
            Date d2=new Date();

            String year=String.format("%tY",d1);
            String month=String.format("%tm",d1);
            String day=String.format("%td",d1);

            int year1=Integer.parseInt(year);
            int month1=Integer.parseInt(month);
            int day1=Integer.parseInt(day);

            String d1String=year+"-"+month+"-"+day+" "+"00:00:00";
            String d2String=year+"-"+month+"-"+day+" "+"23:59:59";

            String key=year+"/"+month+"/"+day;
            try {
                d1=format.parse(d1String);
                d2=format.parse(d2String);

                tbMemoVo.setD1(d1);
                tbMemoVo.setD2(d2);
                tbMemoVos=multiFormMapper.selectMemos(tbMemoVo);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(tbMemoVos!=null&&tbMemoVos.size()!=0)
            {
                int size=tbMemoVos.size();
                for(int j=0;j<size;j++)
                {
                    tbMemoVos.get(j).setYear(year1);
                    tbMemoVos.get(j).setDay(day1);
                    tbMemoVos.get(j).setMonth(month1);
                }

            }
            map.put(key,tbMemoVos);
//                System.out.println("d1String:"+d1String+"d2String:"+d2String);
//                System.out.println("d1:"+d1+" d2:"+d2);
        }

        return map;
    }
    public TbEmployee queryEmployee(TbEmployee employee)
    {
        TbEmployeeExample employeeExample=new TbEmployeeExample();
        TbEmployeeExample.Criteria criteria=employeeExample.createCriteria();
        criteria.andAccountEqualTo(employee.getAccount());
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

    public void updateActivityStatus(TbActivityattendance activityattendance,String status)
    {
        activityattendance.setStatus(status);
        TbActivityattendanceExample activityattendanceExample=new TbActivityattendanceExample();
        TbActivityattendanceExample.Criteria criteria=activityattendanceExample.createCriteria();
        criteria.andEmployeeidEqualTo(activityattendance.getEmployeeid());
        criteria.andActivityidEqualTo(activityattendance.getActivityid());
        tbActivityattendanceMapper.updateByExampleSelective(activityattendance,activityattendanceExample);
    }
    public boolean addDetail(TbDetail tbDetail)
    {
        tbDetail.setDetailid(GetId.getId());
        tbDetail.setStatus("0");
        try
        {
            detailMapper.insert(tbDetail);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
