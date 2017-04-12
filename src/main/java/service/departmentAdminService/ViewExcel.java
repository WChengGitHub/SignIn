//package service.departmentAdminService;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.springframework.web.servlet.view.document.AbstractExcelView;
//import org.apache.commons.lang.StringUtils;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.OutputStream;
//import java.net.URLEncoder;
//import java.util.Map;
//
///**
// * Created by user on 2017/4/8.
// */
//public class ViewExcel extends AbstractExcelView {
//    @Override
//    public void buildExcelDocument(Map<String, Object> map, HSSFWorkbook hssfWorkbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String filename = "员工名单.xls";//设置下载时客户端Excel的名称
//        String newFileName = URLEncoder.encode(filename, "UTF-8");
//        newFileName = StringUtils.replace(newFileName, "+", "%20");
//        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-disposition", "attachment;filename="+ newFileName);
//        OutputStream ouputStream = response.getOutputStream();
//        hssfWorkbook.write(ouputStream);
//        ouputStream.flush();
//        ouputStream.close();
//    }
//}
