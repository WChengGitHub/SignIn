package otherFunction.binding;

import mapper.TbEmployeeMapper;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.TbEmployee;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
/**
 * Created by ZGM on 2017/4/3.
 */
@Service
public class bindEmail {
    @Autowired
    private TbEmployeeMapper tbEmployeeMapper;

    //发送信件功能
    public static void sendHTMLEmail(String Email,String content)
    {
        HtmlEmail email = new HtmlEmail();
        // SimpleEmail email = new SimpleEmail();
        try {
            // 这里是SMTP发送服务器的名字：qq的如下：
            email.setHostName("smtp.163.com");
            // 字符编码集的设置
            email.setCharset("UTF-8");
            // 收件人的邮箱
            email.addTo(Email);
            // 发送人的邮箱
            email.setFrom("13794566179@163.com", "Hello");
            // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
            email.setAuthentication("13794566179@163.com", "a154468");
            email.setSubject("邮箱验证");
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            email.setMsg(content);
            // 发送
            MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
            mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
            mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
            mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
            mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
            mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
            CommandMap.setDefaultCommandMap(mc);
            email.send();

            System.out.println("邮件发送成功!");
        } catch (EmailException e) {
            e.printStackTrace();
            System.out.println("邮件发送失败!");
        }
    }

    //发送邮箱验证码（链接）
    public static String sendEmailCode(TbEmployee tbEmployee) throws UnknownHostException {
        //InetAddress.getLocalHost();应加throws UnknownHostException
        InetAddress address= InetAddress.getLocalHost();
//        String Ip=address.getHostAddress();
//        String hostName = InetAddress.getLocalHost().getHostName();
//        String Ip = InetAddress.getByName(hostName).getHostAddress();

        String Ip="localhost";

        String employeeId=tbEmployee.getEmployeeid();
        String email=tbEmployee.getEmail();

        String UUID1= UUID.randomUUID().toString();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");//设置日期格式
        String Time=df.format(new Date());
        String linkAddress="http://"+Ip+":8080/SignIn/AdminAccountManagement/checkBingingEamilInformation?" +
                "EmployeeId="+employeeId+"&Email="+email+"&UUID="+UUID1+"&CreateTime="+Time;
        String emailContent = "【签到系统】"
                +"点击下面的链接,验证邮箱<br/><a href="
                + linkAddress + " target='_BLANK'>" + "邮箱验证"
                + "</a> "
                + "<br/>tips:本邮件超过10分钟,链接将会失效" ;
        try {
            sendHTMLEmail(email, emailContent);
            return UUID1;
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    public static boolean checkEmailCode(String CreateTime){

        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");//设置日期格式
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Time=df.format(new Date());
        try
        {
            Date d1 = df1.parse(CreateTime);
            Date d2 = df.parse(Time);
            long diff = d2.getTime() - d1.getTime();
            long minutes = diff / (1000 * 60 );
            System.out.println("minutes:"+minutes);
            if(minutes>10)
                return false;
            else return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
