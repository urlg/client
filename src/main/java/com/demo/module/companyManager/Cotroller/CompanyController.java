package com.demo.module.companyManager.Cotroller;

import com.demo.message.Response;
import com.demo.module.companyManager.Entity.CompanyEntity;
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
        String code ="10000003";
        return companyService.deleteCompanyAndEmployee(code);
    }

    /**
     * 向主表内增加一条数据
     *
     * **/
    @ResponseBody
    @PostMapping("insertCompany")
    public Response insertCompany(){
        CompanyEntity companyEntity = new CompanyEntity();
            companyEntity.setCompanyCode(10000005);
            companyEntity.setCompanyName("李小龙");
            companyEntity.setCompanyDepartment("总经理办公室");
            companyEntity.setCompanyUsing("Y");
        return new Response(companyService.insertCompany(companyEntity));
    }

    /**
     * 更新主表内信息
     *
     * **/
    @ResponseBody
    @PostMapping("updateCompany")
    public Response updateCompany(){
        CompanyEntity companyEntity = new CompanyEntity();
        int record = companyService.updateCompanyInfo(companyEntity);
        return  new Response(record);
    }
}
