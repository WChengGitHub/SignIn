package service.companyAdminService;

import mapper.TbCompanyMapper;
import mapper.TbDepartmentMapper;
import mapper.TbEmployeeMapper;
import mapper.TbEmployeenotifyMapper;
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

    @Autowired
    private TbEmployeeMapper tbEmployeeMapper;

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
    public void addDepartments(MultipartFile file, String companyid)
    {
       List<TbDepartment>departments=getExcelDataAndDealData(file,companyid);
        //deleteAllEmployee(departmentid);
        int size=departments.size();
        for(int i=0;i<size;i++)
        {
            TbDepartment department=departments.get(i);
            department.setDepartmentid(GetId.getId());
            tbDepartmentMapper.insert(department);
            autoAddDepartmentAdmin(department.getDepartmentid());
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
    public boolean addOneDepartment(TbDepartment department)
    {
        department.setDepartmentid(GetId.getId());
        department.setDel(false);
        try
        {
            tbDepartmentMapper.insert(department);
            autoAddDepartmentAdmin(department.getDepartmentid());
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
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
    public void autoAddDepartmentAdmin(String departmentid)
    {
        TbEmployee employee=new TbEmployee();
        employee.setEmployeeid(GetId.getId());
        employee.setName("管理员");
        employee.setAccount(GetId.getId());
        employee.setPassword("123456");
        employee.setDel(false);
        employee.setDuties("部门管理员");
        employee.setSex(true);
        employee.setPrivilege("1");
        employee.setDepartmentid(departmentid);
        employee.setTelephone("无");
        employee.setEmail("无");
        tbEmployeeMapper.insert(employee);

    }
    public List<TbEmployee> getDepartmentAdmin(String departmentid)
    {
        TbEmployeeExample employeeExample=new TbEmployeeExample();
        TbEmployeeExample.Criteria criteria=employeeExample.createCriteria();
        criteria.andDepartmentidEqualTo(departmentid);
        criteria.andDelEqualTo(false);
        List<TbEmployee> employees=tbEmployeeMapper.selectByExample(employeeExample);
        if(employees!=null&&employees.size()!=0)
        {
            int size=employees.size();
            for(int i=0;i<size;i++)
            {
                employees.get(i).setPassword("");
            }
        }
        return employees;
    }
    public boolean updateDepartment(TbDepartmentVo tbDepartmentVo)
    {
        TbDepartment department=new TbDepartment();
        department.setAddress(tbDepartmentVo.getAddress());
        department.setName(tbDepartmentVo.getName());
        department.setMac(tbDepartmentVo.getMac());
        List<String> departmentids=tbDepartmentVo.getDepartmentids();
        int size=departmentids.size();
        try {
            for (int i = 0; i < size; i++) {
                department.setDepartmentid(departmentids.get(i));
                tbDepartmentMapper.updateByPrimaryKeySelective(department);
            }
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
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
