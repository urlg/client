package com.demo.module.companyManager.Service;

import com.demo.message.ErrorCodeAndMsg;
import com.demo.message.GlobalException;
import com.demo.message.Response;
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

    /**
     * 向主表添加一条信息,此时不用考虑从表状态
     *
     * @param companyEntity 表company_info 实体类
     * @return int 增加影响的行数
     * @description 主表:company_info
     * @description 从表：employee_info
     * @author A-8626
     **/
    @Override
    public int insertCompany(CompanyEntity companyEntity) {
        int i;
        i = companyManager.insertCompany(companyEntity);
            if (i !=1){
                new GlobalException(ErrorCodeAndMsg.IS_NOT_ONE);
            }
        return 0;
    }
}
