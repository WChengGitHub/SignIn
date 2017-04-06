package otherFunction.binding;
//
//import mapper.TbEmployeeMapper;
//import org.apache.commons.httpclient.Header;
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import pojo.TbEmployee;

/**
 * Created by ZGM on 2017/3/31.
 */
//@Service
//public class bindTelephone {
//    @Autowired
//    private TbEmployeeMapper tbEmployeeMapper;
//    //必须为static？
//    public static int sendMessage  (TbEmployee tbEmployee) {
//
//        //随机数
//        int randomNumber = (int)(Math.random() * 1000000 );
//        System.out.println(randomNumber);//test
//
//        try{
//            HttpClient client = new HttpClient();
//            PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
//            post.addRequestHeader("Content-Type",
//                    "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
//            NameValuePair[] data = { new NameValuePair("Uid", "Test_zgm"),
//                    new NameValuePair("Key", "bbba217a827f6978db2a"),
//                    new NameValuePair("smsMob", tbEmployee.getTelephone()),
//                    new NameValuePair("smsText", "您绑定手机的验证码为"+randomNumber) };
//            post.setRequestBody(data);
//
//            client.executeMethod(post);
//            Header[] headers = post.getResponseHeaders();
//            int statusCode = post.getStatusCode();
//            System.out.println("statusCode:" + statusCode);
//            for (Header h : headers) {
//                System.out.println(h.toString());
//            }
//            String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
//            System.out.println(result);
//
//            post.releaseConnection();
//            return randomNumber;
//        }
//        catch (Exception e) {
//            System.out.println("发送验证码失败");
//            e.printStackTrace();
//            return 0;
//        }
//
//
//    }
//
//}
import java.io.IOException;

import mapper.TbEmployeeMapper;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.TbEmployee;
//import util.StringUtil;
@Service
public class bindTelephone {

    private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

    @Autowired
    private TbEmployeeMapper tbEmployeeMapper;

    public static int sendMessage  (TbEmployee tbEmployee){

        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);

        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

        int randomNumber = (int)((Math.random()*9+1)*1000000);

        String content = new String("您的验证码是：" + randomNumber + "。请不要把验证码泄露给其他人。--SignIn签到系统");

        NameValuePair[] data = {//提交短信
                new NameValuePair("account", "C19786829"), //查看用户名请登录用户中心->验证码、通知短信->帐户及签名设置->APIID
                new NameValuePair("password", "8310adee9ec43547fcb64912d3694081"),  //查看密码请登录用户中心->验证码、通知短信->帐户及签名设置->APIKEY
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", tbEmployee.getTelephone()),
                new NameValuePair("content", content),
        };
        method.setRequestBody(data);

        try {
            client.executeMethod(method);

            String SubmitResult =method.getResponseBodyAsString();

            //System.out.println(SubmitResult);

            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();

            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");

            System.out.println(code);
            System.out.println(msg);
            System.out.println(smsid);

            if("2".equals(code)){
                System.out.println("短信提交成功");
            }
            return randomNumber;
        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            return 0;
    }

}