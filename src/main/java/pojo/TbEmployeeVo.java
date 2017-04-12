package pojo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 2017/4/6.
 */
public class TbEmployeeVo extends TbEmployee{
    private List<String> employeeids = new LinkedList<String>();

    //存放部门id集合
    private List<String> departmentids = new LinkedList<String>();

    public List<String> getEmployeeids() {
        return employeeids;
    }

    public List<String> getDepartmentids() {
        return departmentids;
    }

    public void setDepartmentids(List<String> departmentids) {
        this.departmentids = departmentids;
    }

    public void setEmployeeids(List<String> employeeids) {

        this.employeeids = employeeids;
    }
}
