package com.demo.comm.service;

import com.demo.comm.entity.Common;
import com.demo.comm.mapper.CommonManager;
import com.demo.message.ErrorCodeAndMsg;
import com.demo.message.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;

@SuppressWarnings("all")
@Service("commonService")
public class CommonService implements CommonManager {


    @Autowired
    CommonManager commonManager;

    /**
     * @description 查询spdb.common表中所有信息
     * **/

    @Override
    public ArrayList<Common> getAllCommonInfo() {
        ArrayList<Common> result = commonManager.getAllCommonInfo();
            if (result.isEmpty()){
                throw new GlobalException(ErrorCodeAndMsg.IS_NULL_RECORD);
            }
        return commonManager.getAllCommonInfo();
    }
    /**
     * @description 向spdb.commom表中增加一条数据
     * **/
    @Override
    public int insertCommon(String commonCode, String checkField, String isNecessary) {
        int result;
            result =commonManager.insertCommon(commonCode,checkField,isNecessary);
        return result;
    }

    /**
     * 更新spdb.common表数据
     *  这边传递进来的应该不是Common对象,暂时先这样写
     * @param common
     **/
    @Override
    public int updateCommonByCommonCode(Common common) {
        common.setCommonCode(common.getCommonCode()+".req");
        return commonManager.updateCommonByCommonCode(common);
    }

    /**
     * 通过common_code删除spdb.comm表中一条数据
     *
     * @param common
     **/
    @Override
    public int deleteCommonByCommonCode(Common common) {
        common.setCommonCode(common.getCommonCode()+".req");
        return commonManager.deleteCommonByCommonCode(common);
    }

    /**
     * 使用MySQL的存储过程查询spdb.common表信息
     *
     * @param common
     **/
    @Override
    public ArrayList<Common> CommonInfoByCommonCode(Common common) {
        return commonManager.CommonInfoByCommonCode(common);
    }


}
