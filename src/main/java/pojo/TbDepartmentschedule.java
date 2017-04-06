package pojo;

public class TbDepartmentschedule {
    private String scheduleid;

    private String departmentid;

    private String entertime;

    private String outtime;

    public String getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(String scheduleid) {
        this.scheduleid = scheduleid == null ? null : scheduleid.trim();
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid == null ? null : departmentid.trim();
    }

    public String getEntertime() {
        return entertime;
    }

    public void setEntertime(String entertime) {
        this.entertime = entertime == null ? null : entertime.trim();
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime == null ? null : outtime.trim();
    }
}