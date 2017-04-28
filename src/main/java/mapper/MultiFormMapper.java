package mapper;

import pojo.*;

import java.util.List;

/**
 * Created by user on 2017/3/31.
 */
public interface MultiFormMapper {
    public TbEmployeeVo1 queryEmployee(TbEmployee tbEmployee);
    public List<TbNotifyVo> selectNotifyVoByEmployeeid(String employeeid);
    public List<TbEmployee> queryScheduleEmployee(String scheduleid);
    public List<TbActivityVo> selectActivityByEmployeeid(String employeeid);
    public List<TbDailyAttendanceVo>selectDailyAttendance(TbDailyAttendanceVo tbDailyAttendanceVo);
    public List<TbActivityVo1> selectActivities(TbActivityVo1 activityVo1);
    public List<TbNotifyVo> selectNotify(String employeeid);
    public List<TbNotifyVo1> selectNotifies(TbNotifyVo1 tbNotifyVo1);
    public List<TbMemoVo> selectMemos(TbMemoVo tbMemoVo);
    public List<TbDepartmentScheduleVo1> confirmBeLate(TbDepartmentScheduleVo1 tbDepartmentScheduleVo1);
    public List<TbDepartmentScheduleVo1> querySignInSchedule(TbDepartmentScheduleVo1 tbDepartmentScheduleVo1);
//   根据部门的id查到该部门管理员的id @zhang
    public String selectDepartmentEmployeeIds(String departmentid);

}
