package com.demo.untils.File;


import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author  A-8626 沙建斌  2021-05-24-23:21
 * @discription: 读取流Stream中的内容
 * @version  1.0
 */
public class R_StreamContent {


    /**
     * 读取HttpRequest 对象中内容
     */

    public  String readHttpRequestContent(HttpServletRequest request) throws Exception{
        String requestBody = "";
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream =null;
        BufferedReader bufferedReader =null;

                try {
                    inputStream = request.getInputStream();
                     if(inputStream !=null){
                         bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                         char [] charBuffer = new char[128];
                         int bytesRead = -1;
                         while ((bytesRead = bufferedReader.read(charBuffer))>0){
                             stringBuilder.append(charBuffer,0,bytesRead);
                         }
                     }else {
                         stringBuilder.append("");
                     }
                }catch (IOException exception){
                    exception.printStackTrace();
                }finally {
                    //关闭资源
                        if(inputStream !=null){
                                try{
                                    inputStream.close();
                                }catch (IOException exception){
                                    exception.printStackTrace();
                                }
                        }

                        if(bufferedReader !=null){
                            try {
                                bufferedReader.close();
                            }catch (IOException exception){
                                exception.printStackTrace();
                            }
                        }
                    }
                requestBody = stringBuilder.toString();
        return requestBody;
    }
}
