package com.demo.comm.result;

import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.demo.comm.entity.Common;
import com.demo.message.ErrorCodeAndMsg;
import com.demo.message.GlobalException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 对数据库查询返回的数据进行处理
 */
@Component("commonDB")
public class CommonDB {

    /**
     * 对查询返回的所有字段进行必输检查。
     * @param arrayList    DB查询返回的数据包含是否必输
     * @param requestJson  前端post请求体
     */
    public  boolean FieldCheck(ArrayList<Common> arrayList, JSONObject requestJson){

        /**
         * post请求体body不能为空
         */
        if(requestJson == null){
            throw new GlobalException(ErrorCodeAndMsg.IS_NULL_BODY);
        }

        /**
         * 循环查询返回的Common对象是否必输。如果是必输的话就对比前端是否上送此字段
         */
        for(Common commons:arrayList ) {

            /**匹配单字段 当前端字符串不存在即为null或者字符串存在但是为空的话**/
            if(commons.getFlag().equals("Y")&&!commons.getField().contains(".")){
                try{

                    boolean boo = requestJson.getString(commons.getField()).isEmpty();
                    if(boo){
                        throw new GlobalException(ErrorCodeAndMsg.TRANS_FAILD);
                    }

                }catch (Exception e){
                        throw new GlobalException(ErrorCodeAndMsg.TRANS_FAILD);
                }
            }

            /**匹配List**/
            if (commons.getField().contains(".")) {
                    System.out.println("ssssssssss");
            }

        }

        return true;
    }
}
