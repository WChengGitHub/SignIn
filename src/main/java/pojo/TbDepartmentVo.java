package pojo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 2017/4/14.
 */
public class TbDepartmentVo extends TbDepartment{
    List<String> departmentids=new LinkedList<String>();

    public List<String> getDepartmentids() {
        return departmentids;
    }

    public void setDepartmentids(List<String> departmentids) {
        this.departmentids = departmentids;
    }
}
