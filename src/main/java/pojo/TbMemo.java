package pojo;

import java.util.Date;

public class TbMemo {
    private String memoid;

    private String employeeid;

    private String content;

    private Date starttime;

    private Date endtime;

    public String getMemoid() {
        return memoid;
    }

    public void setMemoid(String memoid) {
        this.memoid = memoid == null ? null : memoid.trim();
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid == null ? null : employeeid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}