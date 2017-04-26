package pojo;

/**
 * Created by user on 2017/4/26.
 */
public class TbDepartmentScheduleVo1 extends TbDepartmentschedule{
    private String dailyattendanceid;
    private String employeeid;
    private String currentTime;
    private String status;

    public String getDailyattendanceid() {
        return dailyattendanceid;
    }

    public void setDailyattendanceid(String dailyattendanceid) {
        this.dailyattendanceid = dailyattendanceid;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
