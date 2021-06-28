package com.demo.comm.result;

import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.demo.comm.entity.Common;
import com.demo.message.ErrorCodeAndMsg;
import com.demo.message.GlobalException;
import com.demo.untils.Exception.Singleton;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.lang.reflect.Method;
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
            if(commons.getFlag().equals("Y")){
                boolean include = commons.getField().contains(".");
                String filed = "";
                try{

                    /**
                     * 匹配当前单字段
                     * try catch语句中只要try语句中抛出异常后都会被catch内捕获进行处理,因此在这里只要抛出异常即可。
                     */
                    if(!include && requestJson.getString(commons.getField()).isEmpty()){
                        filed = commons.getField();
                        throw  new RuntimeException();
                    }

                    /**
                     * 匹配list
                     */
                    if(include){
                        String [] strings = commons.getField().split("\\.");
                        System.out.println(requestJson.getString("ClientInfo"));
                        for (int i = 0;i<strings.length;i++){
                           filed = strings[i];

                            /**
                             *     {
                             *         "ClientInfo": [
                             *             {
                             *                 "ClientNo": 1400121424,
                             *                 "age": 28,
                             *                 "name": "张小龙"
                             *             }
                             *         ],
                             *
                             *         "offset": "1",
                             *         "limit":"1"
                             *     }
                             *
                             * 这里需要循环JSONArray对象获取ClientNo是否为空。数据库配置的是ClientInfo.ClientNo  Y
                             */
                            requestJson.getJSONArray(strings[i]);

                        }
                    }
                }catch (Exception e){
                    throw  new GlobalException(ErrorCodeAndMsg.ErrorCodeAndMsg.fieldIsNotNull("FIN001",filed+"不能为空"));
                }
            }


        }

        return true;
    }
}
