package com.demo.module.employeeManager.Controller;

import com.demo.message.Response;
import com.demo.module.employeeManager.Entity.EmployeeInfo;
import com.demo.module.employeeManager.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author 86136
 */
@RestController
@RequestMapping("emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**根据companyCode 查询
     *
     * @return Response 返回
     * **/
    @ResponseBody
    @PostMapping("selectEmpByCompanyCode")
    public Response selectEmpByCompanyCode(){
        String employeeCode = "10000001";
        return new Response(employeeService.selectEmployeeByCompanyCode(employeeCode));
    }

    /**根据companyCode 查询
     *
     * @return Response 返回
     * **/
    @ResponseBody
    @PostMapping("selectMoreToOne")
    public Response selectMoreToOne(){
        String employeeCode = "10000001";
        return new Response(employeeService.selectMoreToOne(employeeCode));
    }
}
