package service.attendanceInformationService;

import mapper.MultiFormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.TbActivityattendanceVo;
import pojo.TbDailyAttendanceVo;

import java.util.List;

/**
 * Created by ZGM on 2017/4/28.
 */
@Service
public class AttendanceInformationService {
    @Autowired
    private MultiFormMapper multiFormMapper;

    public List<TbDailyAttendanceVo> getInformation(TbDailyAttendanceVo tbDailyattendanceVo){
        List<TbDailyAttendanceVo> dailyattendanceVoList = multiFormMapper.queryDailyAttendanceInformation(tbDailyattendanceVo);
        return dailyattendanceVoList;
    }

    public List<TbActivityattendanceVo> getActivityAttendanceInformation(TbActivityattendanceVo tbActivityattendanceVo){
        List<TbActivityattendanceVo> activityAttendanceVoList = multiFormMapper.queryActivityAttendanceInformation(tbActivityattendanceVo);
        return activityAttendanceVoList;
    }
}
