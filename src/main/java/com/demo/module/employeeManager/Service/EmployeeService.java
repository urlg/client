package com.demo.module.employeeManager.Service;

import com.demo.message.ErrorCodeAndMsg;
import com.demo.message.GlobalException;
import com.demo.message.Response;
import com.demo.module.employeeManager.Entity.EmployeeInfo;
import com.demo.module.employeeManager.Mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author 86136
 */
@Service("employeeService")
public class EmployeeService implements EmployeeMapper {

    @Autowired
    EmployeeMapper employeeMapper;
    /**
     * 根据company_code查询表employee表
     *
     * @param companyCode 公司编码
     * @return ArrayList<EmployeeInfo></>
     **/
    @Override
    public ArrayList<EmployeeInfo> selectEmployeeByCompanyCode(String companyCode) {
        ArrayList<EmployeeInfo> result = employeeMapper.selectEmployeeByCompanyCode(companyCode);
            if (result.isEmpty()){
                new GlobalException(ErrorCodeAndMsg.IS_NULL_RECORD);
            }
        return result;
    }

    /**
     * 根据company_code查询表employee表和company  多对一查询
     *
     * @param companyCode 公司编码
     * @return ArrayList<EmployeeInfo></>
     **/
    @Override
    public ArrayList<EmployeeInfo> selectMoreToOne(String companyCode) {
        ArrayList<EmployeeInfo> result = employeeMapper.selectMoreToOne(companyCode);
        if (result.isEmpty()){
            new GlobalException(ErrorCodeAndMsg.IS_NULL_RECORD);
        }
        return result;
    }

    /**
     *
     **/
    @Override
    public ArrayList queryEmployee(String companyCode) {
        ArrayList result = employeeMapper.queryEmployee(companyCode);
            if (result.isEmpty()){
                new GlobalException(ErrorCodeAndMsg.IS_NULL_RECORD);
            }
        return result;
    }

    /**
     * resultMap type = "arrayList"
     *
     * @param companyCode
     **/
    @Override
    public ArrayList selectArrayList(String companyCode) {
        return employeeMapper.selectArrayList(companyCode);
    }


}
