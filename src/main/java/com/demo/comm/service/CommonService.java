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

    @Override
    public int insertCommon(String commonCode, String checkField, String isNecessary) {
        int result;
            result =commonManager.insertCommon(commonCode,checkField,isNecessary);
        return result;
    }


}
