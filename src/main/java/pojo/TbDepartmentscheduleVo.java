package pojo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 2017/4/6.
 */
public class TbDepartmentscheduleVo extends TbDepartmentschedule{
    private List<String> scheduleids=new LinkedList<String>();

    public List<String> getScheduleids() {
        return scheduleids;
    }

    public void setScheduleids(List<String> scheduleids) {
        this.scheduleids = scheduleids;
    }
}
