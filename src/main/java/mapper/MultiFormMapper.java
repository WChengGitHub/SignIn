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
}
