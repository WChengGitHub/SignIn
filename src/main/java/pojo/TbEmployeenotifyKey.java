package pojo;

public class TbEmployeenotifyKey {
    private String notifyid;

    private String employeeid;

    public String getNotifyid() {
        return notifyid;
    }

    public void setNotifyid(String notifyid) {
        this.notifyid = notifyid == null ? null : notifyid.trim();
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid == null ? null : employeeid.trim();
    }
}