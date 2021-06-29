package com.demo.comm.result;

import com.demo.comm.entity.Common;
import com.demo.message.ErrorCodeAndMsg;
import com.demo.message.GlobalException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 对common表配置的字段进行处理
 *      检查body不能为空
 *      检查必输字段是否必输   userName   Y
 *      检查list格式是否必输  clientInfo.clientNo  Y
 *      检查动态字段是否必输   如：userName存在时clientNo必输
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
                            filed = strings[0];
                            JSONArray jsonArray = requestJson.getJSONArray(filed);
                            /**如果jsonArray为空则表明必输项条件不满足**/
                            if(jsonArray.length() == 0) throw  new RuntimeException();
                            for(int k = 0;k<jsonArray.length();k++){
                                filed = strings[1];
                                if(jsonArray.getJSONObject(k).getString(strings[1]).isEmpty()){
                                    throw new RuntimeException();
                                }
                            }
                        }
                }catch (Exception e){
                    throw  new GlobalException(ErrorCodeAndMsg.ErrorCodeAndMsg.fieldIsNull("FIN001",filed+"不能为空"));
                }
            }
        }
        return true;
    }
}
