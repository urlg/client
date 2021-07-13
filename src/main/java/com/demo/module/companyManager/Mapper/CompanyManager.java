package com.demo.module.companyManager.Mapper;

import com.demo.module.companyManager.Entity.CompanyEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("companyManager")
public interface CompanyManager {

    /**根据companyCode查询表Company和employee**/
   public ArrayList<CompanyEntity> SelectCompanyAndEmp(String companyCode);

   /**根据companyCode删除表company和employee**/
   public int deleteCompanyAndEmployee(String companyCode);
}
