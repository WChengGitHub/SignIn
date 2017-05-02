package service.attendanceInformationService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.TbDailyAttendanceVo;

/**
 * Created by ZGM on 2017/4/28.
 */
public class AttendanceInformationServiceTest {
    private AttendanceInformationService attendanceInformationService;
    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-Dao.xml","spring/applicationContext-Service.xml","spring/applicationContext-transaction.xml"});
        attendanceInformationService= (AttendanceInformationService) applicationContext.getBean("attendanceInformationService");
    }

    @Test
    public void testGetInformation() throws Exception {
        TbDailyAttendanceVo tbDailyattendanceVo = new TbDailyAttendanceVo();
        tbDailyattendanceVo.setStatus("1");
        tbDailyattendanceVo.setDepartmentid("1");
        attendanceInformationService.getInformation(tbDailyattendanceVo);
    }
}