package pojo;

import javafx.util.converter.TimeStringConverter;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by user on 2017/4/28.
 */
public class TbDailyAttendanceVo extends TbDailyattendance{
    private String date;
    private int year;
    private int month;
    private int day;
    private Date d1;
    private Date d2;
    private String name;
    private Timestamp entertime;
    private Timestamp outtime;

    @Override
    public Timestamp getOuttime() {
        return outtime;
    }

    public void setOuttime(Timestamp outtime) {
        this.outtime = outtime;
    }

    private String departmentid;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Date getD2() {
        return d2;
    }

    public void setD2(Date d2) {
        this.d2 = d2;
    }

    public Date getD1() {
        return d1;
    }

    public void setD1(Date d1) {
        this.d1 = d1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public Timestamp getEntertime() {
        return entertime;
    }

    public void setEntertime(Timestamp entertime) {
        this.entertime = entertime;
    }
}
