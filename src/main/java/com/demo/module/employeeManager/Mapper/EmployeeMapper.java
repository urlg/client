package com.demo.module.employeeManager.Mapper;

import com.demo.module.employeeManager.Entity.EmployeeInfo;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author 86136
 */
@Repository("employeeMapper")
public interface EmployeeMapper {

    /**
     * 根据company_code查询表employee表
     * @param companyCode 公司编码
     * @return ArrayList<EmployeeInfo></>
     * **/
    public ArrayList<EmployeeInfo> selectEmployeeByCompanyCode(String companyCode);


    /**
     * 根据company_code查询表employee表和company  多对一查询
     * @param companyCode 公司编码
     * @return ArrayList<EmployeeInfo></>
     * **/
    public ArrayList<EmployeeInfo> selectMoreToOne(String companyCode);

    /**
     *
     *
     * **/
    public ArrayList queryEmployee(String companyCode);

    /**
     * resultMap type = "arrayList"
     * **/
    public ArrayList selectArrayList(String companyCode);
}
