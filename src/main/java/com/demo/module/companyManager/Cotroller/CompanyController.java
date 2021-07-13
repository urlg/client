package com.demo.module.companyManager.Cotroller;

import com.demo.message.Response;
import com.demo.module.companyManager.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    /**根据companyCode查询 company表和employee**/
    @ResponseBody
    @PostMapping("CompanyAndEmp")
    public Response selectCompanyAndEmp(){
        String code ="10000001";
        return new Response(companyService.SelectCompanyAndEmp(code));
    }

    /**根据companyCode删除表company和employee**/
    @ResponseBody
    @PostMapping("deleteCompanyAndEmployee")
    public int deleteCompanyAndEmployee(){
        String code ="10000002";
        return companyService.deleteCompanyAndEmployee(code);
    }
}
