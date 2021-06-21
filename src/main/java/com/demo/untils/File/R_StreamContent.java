package com.demo.untils.File;


import com.alibaba.fastjson.JSON;
import com.demo.message.ErrorCodeAndMsg;
import com.demo.message.GlobalException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @author  A-8626 沙建斌  2021-05-24-23:21
 * @discription: 读取流Stream中的内容
 * @version  1.0
 */
@Component(value = "StreamContent")
public class R_StreamContent {


    /**
     * 读取HttpRequest body中内容.读取的是post请求参数
     */

    public JSONObject httpRequestBody(HttpServletRequest request){
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream =null;
        BufferedReader bufferedReader =null;

            try{
                inputStream = request.getInputStream();
                if(inputStream !=null) {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    char[] charBuffer = new char[128];
                    int bytesRead = -1;
                    while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                        stringBuilder.append(charBuffer, 0, bytesRead);
                    }
                }
                stringBuilder.append("");
            }catch (IOException e){
                e.printStackTrace();
            }finally{
                /**
                 * 资源关闭
                 */
                if(inputStream !=null){
                        try {
                            inputStream.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                }

                if (bufferedReader !=null){
                    try {
                        bufferedReader.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("****"+stringBuilder);
        /**
         * 创建返回的JSON对象
         */
        JSONObject jsonObject = null;
        try{
            jsonObject = new JSONObject(stringBuilder.toString());
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;

    }

    /**
     * @author A-8626 沙建斌
     * @description 读取字符类型的文件 例如: .txt .xml .xsl
     * @param filePath 文件路径
     * @return content {@link java.lang.String}
     */
    public String readFileContent(String filePath) throws GlobalException {
        String content = "";
        StringBuilder stringBuilder = new StringBuilder();
        FileReader fileReader =null;
        BufferedReader bufferedReader = null;

        /**根据filePath创建File对象**/
        File file = new File(filePath);
            if(file.isDirectory()) {
                System.out.println("ErrorCodeAndMsg:"+ErrorCodeAndMsg.IS_DIRECTORY);
                throw new GlobalException(ErrorCodeAndMsg.IS_DIRECTORY);
            }

            if(!file.exists()){
                throw new GlobalException(ErrorCodeAndMsg.FILE_NOT_FIND);
            }

            try {

                bufferedReader = new BufferedReader(new FileReader(filePath),298);
                String result = "";
                while ((result=bufferedReader.readLine()) !=null){
                    stringBuilder.append(result);
                }
            }catch (Exception e){
                throw new GlobalException(ErrorCodeAndMsg.NETWORK_ERROR);
            }finally {
                //关闭流
                if(fileReader!=null){
                    try{
                        fileReader.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                if(bufferedReader != null){
                    try{
                        bufferedReader.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            content = stringBuilder.toString();
        return  content;
    }
}
