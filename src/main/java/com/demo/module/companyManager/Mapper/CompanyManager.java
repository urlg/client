package com.demo.module.companyManager.Mapper;

import com.demo.module.companyManager.Entity.CompanyEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author 86136
 */
@Repository("companyManager")
public interface CompanyManager {

    /**根据companyCode查询表Company和employee**/
   public ArrayList<CompanyEntity> SelectCompanyAndEmp(String companyCode);

   /**根据companyCode删除表company和employee**/
   public int deleteCompanyAndEmployee(String companyCode);

   /**
    *   向主表添加一条信息,此时不用考虑从表状态
    * @description 主表:company_info
    * @description 从表：employee_info
    *
    * @param companyEntity  表company_info 实体类
    * @return int 增加影响的行数
    * @author A-8626
    * **/
   public int insertCompany(CompanyEntity companyEntity);

   /**
    * 更新主表信息时不用考虑从表信息
    * @description 主表:company_info
    * @description 从表：employee_info
    *
    * @author A-8626  沙建斌
    * @param companyEntity 表company_info实体类
    * @return int 更改影响的行数
    * **/
   public int updateCompanyInfo(CompanyEntity companyEntity);

}
