package com.demo.comm.service;

import com.demo.comm.entity.Common;
import com.demo.comm.mapper.CommonManager;
import com.demo.message.ErrorCodeAndMsg;
import com.demo.message.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@SuppressWarnings("all")
@Service("commonService")
public class CommonService implements CommonManager {


    @Autowired
    CommonManager commonManager;
    @Override
    public ArrayList <Common>getCommonInfo(String commcode) {
        ArrayList arrayList = commonManager.getCommonInfo(commcode);

        /**
         * 查询无记录
         */
        if(arrayList.size()<1){
            throw new GlobalException(ErrorCodeAndMsg.IS_NULL_RECORD);
        }
        return arrayList;
    }


}
