package service.companyAdminService;

import mapper.TbCompanyMapper;
import mapper.TbDepartmentMapper;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pojo.*;
import utils.GetId;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 2017/4/13.
 */
@Service
public class CompanyAdminService {
    @Autowired
    private TbCompanyMapper tbCompanyMapper;

    @Autowired
    private TbDepartmentMapper tbDepartmentMapper;

    public List<TbDepartment> getExcelDataAndDealData(MultipartFile file,String companyid)
    {
       List<TbDepartment> departments=new LinkedList<TbDepartment>();
        try {
            Workbook wb= WorkbookFactory.create(file.getInputStream());
            Sheet sheet=wb.getSheetAt(0);
            int length=sheet.getLastRowNum();
            System.out.println(length);
            for(int i=2;i<=sheet.getLastRowNum();i++)
            {
                Row row=sheet.getRow(i);
                TbDepartment department=new TbDepartment();

//                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
//                employee.setEmployeeid(row.getCell(0).getStringCellValue());

                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                department.setName(row.getCell(0).getStringCellValue());

                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                department.setAddress(row.getCell(1).getStringCellValue());

                row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                department.setMac(row.getCell(2).getStringCellValue());

                department.setCompanyid(companyid);
                department.setDel(false);
                departments.add(department);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(departments);
        return departments;
    }
    public void addCompany(MultipartFile file,String companyid)
    {
       List<TbDepartment>departments=getExcelDataAndDealData(file,companyid);
        //deleteAllEmployee(departmentid);
        int size=departments.size();
        for(int i=0;i<size;i++)
        {
            TbDepartment department=departments.get(i);
            department.setDepartmentid(GetId.getId());
            tbDepartmentMapper.insert(department);
//            if(employee.getEmployeeid()==null||employee.getEmployeeid().equals(""))
//            {
//                employee.setEmployeeid(""+(i+1));
//                tbEmployeeMapper.insert(employee);
//            }
//            else
//            {
//                    tbEmployeeMapper.updateByPrimaryKey(employee);
//            }
        }
    }

    public List<TbDepartment> getDepartments(String companyid)
    {
        TbDepartmentExample departmentExample=new TbDepartmentExample();
        TbDepartmentExample.Criteria criteria=departmentExample.createCriteria();
        criteria.andCompanyidEqualTo(companyid);
        criteria.andDelEqualTo(false);
        List<TbDepartment> departments=null;
        departments=tbDepartmentMapper.selectByExample(departmentExample);
        return departments;
    }
    public boolean deleteDepartments(TbDepartmentVo tbDepartmentVo)
    {
        List<String> departmentids=tbDepartmentVo.getDepartmentids();
        int size=departmentids.size();
        try
        {
            for(int i=0;i<size;i++)
            {
                TbDepartment tbDepartment=new TbDepartment();
                tbDepartment.setDepartmentid(departmentids.get(i));
                tbDepartment.setDel(true);
                tbDepartmentMapper.updateByPrimaryKeySelective(tbDepartment);
            }
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
