package mapper;

import pojo.TbActivityVo;
import pojo.TbEmployee;
import pojo.TbNotifyVo;

import java.util.List;

/**
 * Created by user on 2017/3/31.
 */
public interface MultiFormMapper {
    public List<TbNotifyVo> selectNotifyVoByEmployeeid(String employeeid);
    public List<TbEmployee> queryScheduleEmployee(String scheduleid);
    public List<TbActivityVo> selectActivityByEmployeeid(String employeeid);
    public List<TbNotifyVo> selectNotify(String employeeid);
//   根据部门的id查到该部门管理员的id @zhang
    public String selectDepartmentEmployeeIds(String departmentid);

}
