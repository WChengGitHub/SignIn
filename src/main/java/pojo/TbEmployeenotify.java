package pojo;

import java.util.LinkedList;
import java.util.List;

public class TbEmployeenotify extends TbEmployeenotifyKey {
    private Boolean status;

    //用于存放多个部门管理员id集合
    private List<String> employeeIds = new LinkedList<String>();
    //用于存放生成的NotifyId集合
    private List<String> notifyIds = new LinkedList<String>();

    public List<String> getNotifyIds() {
        return notifyIds;
    }

    public void setNotifyIds(List<String> notifyIds) {
        this.notifyIds = notifyIds;
    }

    public List<String> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<String> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
