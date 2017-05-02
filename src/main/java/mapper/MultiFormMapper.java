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
    public List<TbApplicationVo> queryApplications(String departmentid);
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
    //   根据部门id查询该部门下的员工的出清记录条数，根据不同状态（status）查询
    public int queryDailyAttendanceNum(TbDailyAttendanceVo tbDailyattendanceVo);
    //   具体信息 某个出勤状态的信息
    public List<TbDailyAttendanceVo> queryDailyAttendanceInformation(TbDailyAttendanceVo tbDailyattendanceVo);
    //   根据部门id查询活动出席情况
    public List<TbActivityattendanceVo> queryActivityAttendanceInformation(TbActivityattendanceVo tbActivityattendanceVo);
}
