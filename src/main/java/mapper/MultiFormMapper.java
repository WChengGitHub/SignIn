package mapper;

import pojo.TbEmployee;
import pojo.TbNotifyVo;

import java.util.List;

/**
 * Created by user on 2017/3/31.
 */
public interface MultiFormMapper {
    public List<TbNotifyVo> selectNotifyVoByEmployeeid(String employeeid);
    public List<TbEmployee> queryScheduleEmployee(String scheduleid);
//   根据部门的id查到该部门管理员的id @zhang
    public String selectDepartmentEmployeeIds(String departmentid);
}
