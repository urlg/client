package com.demo.untils.File;


import com.demo.message.ErrorCodeAndMsg;
import com.demo.message.GlobalException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @author  A-8626 沙建斌  2021-05-24-23:21
 * @discription: 读取流Stream中的内容
 * @version  1.0
 */
@Component(value = "readStreamContent")
public class R_StreamContent {


    /**
     * 读取HttpRequest body中内容
     */

    public  String readHttpRequestContent(HttpServletRequest request){
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
