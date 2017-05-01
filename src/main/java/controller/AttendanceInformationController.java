package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.TbActivityattendanceVo;
import pojo.TbDailyAttendanceVo;
import service.attendanceInformationService.AttendanceInformationService;

import java.util.List;

/**
 * Created by ZGM on 2017/4/28.
 */
@Controller
@RequestMapping("/AttendanceInformation")
public class AttendanceInformationController {

    @Autowired
    private AttendanceInformationService attendanceInformationService;

    @RequestMapping("/getInformation")
    public @ResponseBody
    List<TbDailyAttendanceVo> getInformation(TbDailyAttendanceVo tbDailyattendanceVo){
        List<TbDailyAttendanceVo> dailyattendanceVoList=attendanceInformationService.getInformation(tbDailyattendanceVo);
        return dailyattendanceVoList;
    }
    
    @RequestMapping("/getActivityAttendanceInformation")
    public @ResponseBody
    List<TbActivityattendanceVo> getActivityAttendanceInformation(TbActivityattendanceVo tbActivityattendanceVo){
        List<TbActivityattendanceVo> activityattendanceVoList=attendanceInformationService.getActivityAttendanceInformation(tbActivityattendanceVo);
        return activityattendanceVoList;
    }



}
