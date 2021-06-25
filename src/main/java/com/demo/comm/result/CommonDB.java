package com.demo.comm.result;

import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.demo.comm.entity.Common;
import com.demo.message.ErrorCodeAndMsg;
import com.demo.message.GlobalException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 对数据库查询返回的数据进行处理
 */
@Component("commonDB")
public class CommonDB {

    /**
     * 对查询返回的所有字段进行必输检查
     *  field字段格式最多支持2级数组
     *      field
     *      client
     *      client.user
     *      client.user.name
     */
    public  boolean FieldCheck(ArrayList<Common> arrayList, JSONObject requestJson){

        for(Common commons:arrayList ){
            if(commons.getFlag().equals("Y")){

                /**判断是否是list格式**/
                if(commons.getField().contains(".")){
                        System.out.println("ssssssssss");
                }

                /**匹配单字段**/
                try{
                    System.out.println("body"+ requestJson.get("body"));
                    if(requestJson.get(commons.getField()) == null || requestJson.get(commons.getField()) == ""){
                        throw new GlobalException(ErrorCodeAndMsg.IS_NOT_READY);
                    }
                }catch (Exception e){
                    throw  new GlobalException(ErrorCodeAndMsg.TRANS_FAILD);
                }
            }
        }
        return true;
    }
}
