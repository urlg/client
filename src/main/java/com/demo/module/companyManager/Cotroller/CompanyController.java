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
        String code ="00000010";
        return new Response(companyService.CompanyAndEmp(code));
    }
}
