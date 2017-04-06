package pojo;

import java.util.Date;

public class TbActivityattendance {
    private String activityattendanceid;

    private String employeeid;

    private String activityid;

    private Date entertime;

    private Date outtime;

    private String status;

    public String getActivityattendanceid() {
        return activityattendanceid;
    }

    public void setActivityattendanceid(String activityattendanceid) {
        this.activityattendanceid = activityattendanceid == null ? null : activityattendanceid.trim();
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid == null ? null : employeeid.trim();
    }

    public String getActivityid() {
        return activityid;
    }

    public void setActivityid(String activityid) {
        this.activityid = activityid == null ? null : activityid.trim();
    }

    public Date getEntertime() {
        return entertime;
    }

    public void setEntertime(Date entertime) {
        this.entertime = entertime;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}