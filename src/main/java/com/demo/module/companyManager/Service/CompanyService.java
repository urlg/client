package com.demo.module.companyManager.Service;

import com.demo.module.companyManager.Entity.CompanyEntity;
import com.demo.module.companyManager.Mapper.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("companyService")
public class CompanyService  implements Manager {

    @Autowired
    Manager companyManager;

    /**
     * 根据companyCode查询表Company和employee
     *
     * @param companyCode
     **/
    @Override
    public ArrayList<CompanyEntity> CompanyAndEmp(String companyCode) {
        return companyManager.CompanyAndEmp(companyCode);
    }
}
