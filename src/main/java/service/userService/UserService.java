package service.userService;


import mapper.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import otherFunction.md5.Encryption;
import pojo.*;
import utils.GetId;

import java.sql.Timestamp;
import java.text.DateFormat;
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

    @Autowired
    private TbDepartmentscheduleMapper departmentscheduleMapper;

    @Autowired
    private TbDailyattendanceMapper dailyattendanceMapper;


    public List<TbActivityVo> queryActivities(String employeeid)
    {
        List<TbActivityVo> activityVos=multiFormMapper.selectActivityByEmployeeid(employeeid);
        return  activityVos;
    }
    public Map<String,List<TbDailyAttendanceVo>> selectDailyattendance(String employeeid,String yearString,String monthString)
    {
        Map<String,List<TbDailyAttendanceVo>>map=new HashMap<String, List<TbDailyAttendanceVo>>();
        Date d0=new Date();
        Calendar now =Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d0String=yearString+"-"+monthString+"-"+"01"+" "+"00:00:00";
        try {
            d0=format.parse(d0String);
            System.out.println(d0);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TbDailyAttendanceVo dailyAttendanceVo=new TbDailyAttendanceVo();
        dailyAttendanceVo.setEmployeeid(employeeid);
        for(int i=0;i<31;i++)
        {
            List<TbDailyAttendanceVo>tbDailyAttendanceVos=null;
            now.setTime(d0);
            now.set(Calendar.DATE,now.get(Calendar.DATE)+i);
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

                dailyAttendanceVo.setD1(d1);
                dailyAttendanceVo.setD2(d2);
                tbDailyAttendanceVos=multiFormMapper.selectDailyAttendance(dailyAttendanceVo);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(tbDailyAttendanceVos!=null&&tbDailyAttendanceVos.size()!=0)
            {
                int size=tbDailyAttendanceVos.size();
                for(int j=0;j<size;j++)
                {
                    tbDailyAttendanceVos.get(j).setYear(year1);
                    tbDailyAttendanceVos.get(j).setDay(day1);
                    tbDailyAttendanceVos.get(j).setMonth(month1);
                }

            }
            map.put(key,tbDailyAttendanceVos);
//                System.out.println("d1String:"+d1String+"d2String:"+d2String);
//                System.out.println("d1:"+d1+" d2:"+d2);
        }

        return map;
    }
    public List<TbDailyAttendanceVo> selectDailyattendance1(String employeeid,String yearString,String monthString)
    {
        List<TbDailyAttendanceVo>list=new LinkedList<TbDailyAttendanceVo>();
        Date d0=new Date();
        Calendar now =Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d0String=yearString+"-"+monthString+"-"+"01"+" "+"00:00:00";
        try {
            d0=format.parse(d0String);
            System.out.println(d0);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TbDailyAttendanceVo dailyAttendanceVo=new TbDailyAttendanceVo();
        dailyAttendanceVo.setEmployeeid(employeeid);
        for(int i=0;i<31;i++)
        {
            List<TbDailyAttendanceVo>tbDailyAttendanceVos=null;
            now.setTime(d0);
            now.set(Calendar.DATE,now.get(Calendar.DATE)+i);
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

                dailyAttendanceVo.setD1(d1);
                dailyAttendanceVo.setD2(d2);
                tbDailyAttendanceVos=multiFormMapper.selectDailyAttendance(dailyAttendanceVo);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(tbDailyAttendanceVos!=null&&tbDailyAttendanceVos.size()!=0)
            {
                int size=tbDailyAttendanceVos.size();
                for(int j=0;j<size;j++)
                {
                    tbDailyAttendanceVos.get(j).setYear(year1);
                    tbDailyAttendanceVos.get(j).setDay(day1);
                    tbDailyAttendanceVos.get(j).setMonth(month1);
                    tbDailyAttendanceVos.get(j).setDate(key);
                    list.add(tbDailyAttendanceVos.get(j));
                }

            }

//                System.out.println("d1String:"+d1String+"d2String:"+d2String);
//                System.out.println("d1:"+d1+" d2:"+d2);
        }

        return list;
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

    public Map<String,List<TbActivityVo1>> queryActivities2(String employeeid,String yearString,String monthString)
    {
        Map<String,List<TbActivityVo1>>map=new HashMap<String, List<TbActivityVo1>>();

        Date d0=new Date();
        Calendar now =Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d0String=yearString+"-"+monthString+"-"+"01"+" "+"00:00:00";
        try {
            d0=format.parse(d0String);
            System.out.println(d0);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TbActivityVo1 tbActivityVo1=new TbActivityVo1();
        tbActivityVo1.setEmployeeid(employeeid);
        for(int i=0;i<31;i++)
        {
            List<TbActivityVo1> tbActivityVo1s=null;

            now.setTime(d0);
            now.set(Calendar.DATE,now.get(Calendar.DATE)+i);
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
    public List<TbActivityVo1>queryActivities3(String employeeid,String yearString,String monthString)
    {
        List<TbActivityVo1> list=new LinkedList<TbActivityVo1>();
        Date d0=new Date();
        Calendar now =Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d0String=yearString+"-"+monthString+"-"+"01"+" "+"00:00:00";
        try {
            d0=format.parse(d0String);
            System.out.println(d0);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TbActivityVo1 tbActivityVo1=new TbActivityVo1();
        tbActivityVo1.setEmployeeid(employeeid);
        for(int i=0;i<31;i++)
        {
            List<TbActivityVo1> tbActivityVo1s=null;

            now.setTime(d0);
            now.set(Calendar.DATE,now.get(Calendar.DATE)+i);
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
                    TbActivityVo1 tbActivityVo12=tbActivityVo1s.get(j);
                    tbActivityVo12.setYear(year1);
                    tbActivityVo12.setDay(day1);
                    tbActivityVo12.setMonth(month1);
                    tbActivityVo12.setDate(key);
                    list.add(tbActivityVo12);
                }

            }
//                System.out.println("d1String:"+d1String+"d2String:"+d2String);
//                System.out.println("d1:"+d1+" d2:"+d2);
        }

        return list;
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
    public Map<String,List<TbNotifyVo1>> selectNotifies1(String employeeid,String yearString,String monthString)
    {
        Map<String,List<TbNotifyVo1>>map=new HashMap<String, List<TbNotifyVo1>>();
        Date d0=new Date();
        Calendar now =Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d0String=yearString+"-"+monthString+"-"+"01"+" "+"00:00:00";
        try {
            d0=format.parse(d0String);
            System.out.println(d0);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TbNotifyVo1 tbNotifyVo1=new TbNotifyVo1();
        tbNotifyVo1.setEmployeeid(employeeid);
        for(int i=0;i<31;i++)
        {
            List<TbNotifyVo1>tbNotifyVo1s=null;
            now.setTime(d0);
            now.set(Calendar.DATE,now.get(Calendar.DATE)+i);
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

    public List<TbNotifyVo1>selectNotifies2(String employeeid,String yearString,String monthString)
    {
        List<TbNotifyVo1> list=new LinkedList<TbNotifyVo1>();
        Date d0=new Date();
        Calendar now =Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d0String=yearString+"-"+monthString+"-"+"01"+" "+"00:00:00";
        try {
            d0=format.parse(d0String);
            System.out.println(d0);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TbNotifyVo1 tbNotifyVo1=new TbNotifyVo1();
        tbNotifyVo1.setEmployeeid(employeeid);
        for(int i=0;i<31;i++)
        {
            List<TbNotifyVo1>tbNotifyVo1s=null;
            now.setTime(d0);
            now.set(Calendar.DATE,now.get(Calendar.DATE)+i);
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
                    tbNotifyVo1s.get(j).setDate(key);
                    list.add(tbNotifyVo1s.get(j));
                }

            }
//                System.out.println("d1String:"+d1String+"d2String:"+d2String);
//                System.out.println("d1:"+d1+" d2:"+d2);
        }

        return list;
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
    public Map<String,List<TbMemoVo>> selectMemos1(String employeeid,String yearString,String monthString)
    {
        Map<String,List<TbMemoVo>>map=new HashMap<String, List<TbMemoVo>>();
        Date d0=new Date();
        Calendar now =Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d0String=yearString+"-"+monthString+"-"+"01"+" "+"00:00:00";
        try {
            d0=format.parse(d0String);
            System.out.println(d0);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TbMemoVo tbMemoVo=new TbMemoVo();
        tbMemoVo.setEmployeeid(employeeid);
        for(int i=0;i<31;i++)
        {
            List<TbMemoVo>tbMemoVos=null;
            now.setTime(d0);
            now.set(Calendar.DATE,now.get(Calendar.DATE)+i);
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

    public List<TbMemoVo> selectMemos2(String employeeid,String yearString,String monthString)
    {
        List<TbMemoVo> list=new LinkedList<TbMemoVo>();
        Date d0=new Date();
        Calendar now =Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d0String=yearString+"-"+monthString+"-"+"01"+" "+"00:00:00";
        try {
            d0=format.parse(d0String);
            System.out.println(d0);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TbMemoVo tbMemoVo=new TbMemoVo();
        tbMemoVo.setEmployeeid(employeeid);
        for(int i=0;i<31;i++)
        {
            List<TbMemoVo>tbMemoVos=null;
            now.setTime(d0);
            now.set(Calendar.DATE,now.get(Calendar.DATE)+i);
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
                    tbMemoVos.get(j).setDate(key);
                    list.add(tbMemoVos.get(j));
                }

            }

//                System.out.println("d1String:"+d1String+"d2String:"+d2String);
//                System.out.println("d1:"+d1+" d2:"+d2);
        }

        return list;
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
    public TbEmployeeVo1 queryEmployee1(TbEmployee employee)
    {
        employee.setPassword(Encryption.generatePassword(employee.getPassword()));
        TbEmployeeVo1 tbEmployeeVo1=multiFormMapper.queryEmployee(employee);
        if(tbEmployeeVo1!=null)
        tbEmployeeVo1.setPassword("");
        return tbEmployeeVo1;
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
    public List<TbDepartmentScheduleVo1> confirmBeLate(TbDepartmentScheduleVo1 tbDepartmentScheduleVo1)
    {
        Date date=new Date();
        String hour=String.format("%tH",date);
        String minute=String.format("%tM",date);
        String currentTime=hour+":"+minute;
        tbDepartmentScheduleVo1.setCurrentTime(currentTime);
        List<TbDepartmentScheduleVo1> tbDepartmentScheduleVo1s=multiFormMapper.confirmBeLate(tbDepartmentScheduleVo1);
        return tbDepartmentScheduleVo1s;
    }
    public List<TbDepartmentScheduleVo1> querySignInSchedule(TbDepartmentScheduleVo1 tbDepartmentScheduleVo1)
    {
        Date date=new Date();
        String hour=String.format("%tH",date);
        String minute=String.format("%tM",date);
        String currentTime=hour+":"+minute;
        tbDepartmentScheduleVo1.setCurrentTime(currentTime);
        List<TbDepartmentScheduleVo1> tbDepartmentScheduleVo1s=multiFormMapper.querySignInSchedule(tbDepartmentScheduleVo1);
        return tbDepartmentScheduleVo1s;
    }
    public void insertDailyAttendance(TbDepartmentScheduleVo1 tbDepartmentScheduleVo1)
    {
        TbDailyattendance dailyattendance=new TbDailyattendance();

    }
    public TbDepartmentScheduleVo1 DailyAttendanceSignIn(TbDepartmentScheduleVo1 tbDepartmentScheduleVo1)
    {
        TbDailyattendance dailyattendance=new TbDailyattendance();
        TbDepartmentScheduleVo1 departmentScheduleVo1=new TbDepartmentScheduleVo1();
        String dailyattendanceid=GetId.getId();

        dailyattendance.setEmployeeid(tbDepartmentScheduleVo1.getEmployeeid());
        dailyattendance.setEntertime(new Date());
        dailyattendance.setDailyattendanceid(dailyattendanceid);

        List<TbDepartmentScheduleVo1>tbDepartmentScheduleVo1s=confirmBeLate(tbDepartmentScheduleVo1);
        if(tbDepartmentScheduleVo1s!=null&&tbDepartmentScheduleVo1s.size()!=0)
        {
            dailyattendance.setStatus("2");
            departmentScheduleVo1.setDailyattendanceid(dailyattendanceid);
            departmentScheduleVo1.setScheduleid(tbDepartmentScheduleVo1s.get(0).getScheduleid());
            departmentScheduleVo1.setOuttime(tbDepartmentScheduleVo1s.get(0).getOuttime());
            departmentScheduleVo1.setStatus("2");
        }
        else
        {
            dailyattendance.setStatus("1");
            List<TbDepartmentScheduleVo1>tbDepartmentScheduleVo1s1=querySignInSchedule(tbDepartmentScheduleVo1);
            if(tbDepartmentScheduleVo1s1!=null&&tbDepartmentScheduleVo1s1.size()!=0)
            {
                departmentScheduleVo1.setDailyattendanceid(dailyattendanceid);
                departmentScheduleVo1.setScheduleid(tbDepartmentScheduleVo1s1.get(0).getScheduleid());
                departmentScheduleVo1.setOuttime(tbDepartmentScheduleVo1s1.get(0).getOuttime());
                departmentScheduleVo1.setStatus("1");
            }
        }
        dailyattendanceMapper.insertSelective(dailyattendance);
        return departmentScheduleVo1;
    }
    public String DailyAttendanceSignOut(TbDepartmentScheduleVo1 tbDepartmentScheduleVo1)
    {
        TbDepartmentscheduleExample departmentscheduleExample=new TbDepartmentscheduleExample();
        TbDepartmentscheduleExample.Criteria criteria=departmentscheduleExample.createCriteria();
        criteria.andScheduleidEqualTo(tbDepartmentScheduleVo1.getScheduleid());

        Date date=new Date();
        String hour=String.format("%tH",date);
        String minute=String.format("%tM",date);
        String currentTime=hour+":"+minute;

        criteria.andOuttimeLessThanOrEqualTo(currentTime);

        long num=departmentscheduleMapper.countByExample(departmentscheduleExample);
        TbDailyattendance dailyattendance=new TbDailyattendance();
        dailyattendance.setOuttime(date);
        dailyattendance.setDailyattendanceid(tbDepartmentScheduleVo1.getDailyattendanceid());
        if(num==0)
        {
            if(tbDepartmentScheduleVo1.getStatus().equals("2"))
                dailyattendance.setStatus("4");
            else
                dailyattendance.setStatus("3");

        }
        dailyattendanceMapper.updateByPrimaryKeySelective(dailyattendance);
        return dailyattendance.getStatus();
    }
    public String ActivitySignIn(TbActivityattendance tbactivityattendance)
    {
        Date date=new Date();
        String Status;

        TbActivityExample activityExample=new TbActivityExample();
        TbActivityExample.Criteria criteria=activityExample.createCriteria();
        criteria.andActivityidEqualTo(tbactivityattendance.getActivityid());
        criteria.andStarttimeLessThan(date);

        List<TbActivity> activities=activityMapper.selectByExample(activityExample);

        if(activities==null||activities.size()!=0)
            Status="2";
        else Status="1";

        TbActivityattendance activityattendance=new TbActivityattendance();
        activityattendance.setEntertime(date);
        activityattendance.setStatus(Status);

        TbActivityattendanceExample activityattendanceExample=new TbActivityattendanceExample();
        TbActivityattendanceExample.Criteria criteria1=activityattendanceExample.createCriteria();
        criteria1.andActivityidEqualTo(tbactivityattendance.getActivityid());
        criteria1.andEmployeeidEqualTo(tbactivityattendance.getEmployeeid());

        tbActivityattendanceMapper.updateByExampleSelective(activityattendance,activityattendanceExample);
        return Status;
    }
    public String ActivitySignOut(TbActivityattendance tbactivityattendance)
    {
        String Status=tbactivityattendance.getStatus();
        Date date=new Date();

        TbActivityExample activityExample=new TbActivityExample();
        TbActivityExample.Criteria criteria=activityExample.createCriteria();
        criteria.andActivityidEqualTo(tbactivityattendance.getActivityid());
        criteria.andEndtimeGreaterThan(date);

        List<TbActivity> activities=activityMapper.selectByExample(activityExample);

        if(activities==null||activities.size()!=0)
            if(Status.equals("2"))
                Status="4";
            else
                Status="3";

        TbActivityattendance activityattendance=new TbActivityattendance();
        activityattendance.setOuttime(date);
        activityattendance.setStatus(Status);

        TbActivityattendanceExample activityattendanceExample=new TbActivityattendanceExample();
        TbActivityattendanceExample.Criteria criteria1=activityattendanceExample.createCriteria();
        criteria1.andActivityidEqualTo(tbactivityattendance.getActivityid());
        criteria1.andEmployeeidEqualTo(tbactivityattendance.getEmployeeid());

        tbActivityattendanceMapper.updateByExampleSelective(activityattendance,activityattendanceExample);
        return Status;
    }
    public String getWorkHours(List<TbDailyAttendanceVo> dailyAttendanceVos)
    {
        if(dailyAttendanceVos==null&&dailyAttendanceVos.size()==0)
            return null;
        long sumTime=0;
        for(int i=0;i<dailyAttendanceVos.size();i++ )
        {
            TbDailyAttendanceVo tbDailyAttendanceVo=dailyAttendanceVos.get(i);
            Timestamp t1=tbDailyAttendanceVo.getEntertime();
            Timestamp t2=tbDailyAttendanceVo.getOuttime();
            sumTime=sumTime+t2.getTime()-t1.getTime();
        }
        long hour=sumTime/(3600*1000);
        sumTime=sumTime%((3600*1000));
        long minute=sumTime/(60*1000);
        long second=(sumTime%(60*1000))/1000;
        String h=hour+"";
        if(h.length()==1)
            h="0"+h;
        String m=minute+"";
        if(m.length()==1)
            m="0"+m;
        String s=second+"";
        if(s.length()==1)
            s="0"+s;
        String workTime=h+":"+m+":"+s;
        return workTime;
    }
    public boolean addMemos(TbMemo tbMemo,String startTime,String endTime)
    {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1=format.parse(startTime);
            Date d2=format.parse(endTime);
            tbMemo.setStarttime(d1);
            tbMemo.setEndtime(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        tbMemo.setMemoid(GetId.getId());
        try
        {
            memoMapper.insert(tbMemo);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateMemos(TbMemo tbMemo)
    {
        try
        {
            memoMapper.updateByPrimaryKeySelective(tbMemo);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
