package com.demo.module.companyManager.Service;

import com.demo.module.companyManager.Entity.CompanyEntity;
import com.demo.module.companyManager.Mapper.CompanyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("companyService")
public class CompanyService  implements CompanyManager {

    @Autowired
    CompanyManager companyManager;

    /**
     * 根据companyCode查询表Company和employee
     *
     * @param companyCode
     **/
    @Override
    public ArrayList<CompanyEntity> SelectCompanyAndEmp(String companyCode) {
        return  companyManager.SelectCompanyAndEmp(companyCode);
    }

    /**
     * 根据companyCode删除表company和employee
     *
     * @param companyCode
     **/
    @Override
    public int deleteCompanyAndEmployee(String companyCode) {
        return companyManager.deleteCompanyAndEmployee(companyCode);
    }
}
