package pojo;

import java.util.Date;

public class TbDailyattendance {
    private String dailyattendanceid;

    private Date entertime;

    private Date outtime;

    private Date fronttime;

    private Date accumulatedtime;

    private String status;

    private String employeeid;

    public String getDailyattendanceid() {
        return dailyattendanceid;
    }

    public void setDailyattendanceid(String dailyattendanceid) {
        this.dailyattendanceid = dailyattendanceid == null ? null : dailyattendanceid.trim();
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

    public Date getFronttime() {
        return fronttime;
    }

    public void setFronttime(Date fronttime) {
        this.fronttime = fronttime;
    }

    public Date getAccumulatedtime() {
        return accumulatedtime;
    }

    public void setAccumulatedtime(Date accumulatedtime) {
        this.accumulatedtime = accumulatedtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid == null ? null : employeeid.trim();
    }
}