package pojo;

/**
 * Created by user on 2017/3/31.
 */
public class TbNotifyVo extends  TbNotify{
    private String status;
    private String employeeid;
    private String name;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
