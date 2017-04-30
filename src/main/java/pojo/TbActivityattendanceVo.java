package pojo;

/**
 * Created by ZGM on 2017/4/30.
 */
public class TbActivityattendanceVo extends TbActivityattendance {
    private String name;

    private String activityname;

    private String departmentid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }
}
