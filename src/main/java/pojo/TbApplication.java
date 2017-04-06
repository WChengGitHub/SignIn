package pojo;

import java.util.Date;

public class TbApplication {
    private String applicationid;

    private String employeeid;

    private String dailyattendanceid;

    private String title;

    private String remark;

    private Date applicationtime;

    private Boolean status;

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid == null ? null : applicationid.trim();
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid == null ? null : employeeid.trim();
    }

    public String getDailyattendanceid() {
        return dailyattendanceid;
    }

    public void setDailyattendanceid(String dailyattendanceid) {
        this.dailyattendanceid = dailyattendanceid == null ? null : dailyattendanceid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getApplicationtime() {
        return applicationtime;
    }

    public void setApplicationtime(Date applicationtime) {
        this.applicationtime = applicationtime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}