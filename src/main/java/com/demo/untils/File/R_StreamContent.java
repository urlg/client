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

        /***
         * @description 字节流
         */
        InputStream inputStream =null;

        /***
         * @description 处理流 缓冲流 默认构造函数具有8kb的缓存区
         */
        BufferedReader bufferedReader =null;

        /***
         * @description 处理流 将字节流转换为字符流
         */
        InputStreamReader inputStreamReader = null;

        try{
                inputStream = request.getInputStream();
                if(inputStream !=null) {

                    inputStreamReader = new InputStreamReader(inputStream);
                    bufferedReader = new BufferedReader(inputStreamReader);

                    /**
                     * 读取数据
                     *
                     *      首先bufferedReader.read(charBuffer)一次性读取bufferedReader缓存大小的数据。放在缓冲区。
                     *      接着将bufferedReader缓存区的数据刷新到charBuffer数组中，如果charBuffer数组大小未被填充满则继续调用bufferedReader.read(charBuffer)
                     *      再次填充charBuffer数组,直至charBuffer数组填充满,此时返回读取的字节个数然后继续上述过程直至数据源读取完毕。
                     *
                     *      stringBuilder.append(charBuffer, 0, bytesRead)将指定字节数组内的数据(数据值为二进制转换成的int类型)转换为StringBuilder对象
                     */
                    char[] charBuffer = new char[10];
                    int bytesRead = -1;
                    while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {

                        /***
                         * 每次charBuffer被填充满后则将填充的字节数组转换StringBuild对象并拼接StringBuilder对象
                         */
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
