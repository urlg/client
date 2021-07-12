package com.demo.module.companyManager.Mapper;

import com.demo.module.companyManager.Entity.CompanyEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("companyManager")
public interface Manager {

    /**根据companyCode查询表Company和employee**/
   public ArrayList<CompanyEntity> CompanyAndEmp(String companyCode);
}
