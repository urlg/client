package com.demo.comm.commonDB;

import com.demo.comm.service.CommonService;
import com.demo.message.ErrorCodeAndMsg;
import com.demo.message.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * common_db 进行操作
 * **/
@RestController
@RequestMapping("common")
public class CommonControler {

    @Autowired
    CommonService commonService;

    /**
     * 查询common_db表所有列信息
     * **/
    @ResponseBody
    @PostMapping("common001")
    public Response getAllCommonInfo(){

        return new Response(commonService.getAllCommonInfo());
    }

    /**向spdb.common表中增加一条数据**/
    @ResponseBody
    @PostMapping("common002")
    public Response insertCommon(){
        commonService.insertCommon("QryPerson0002.req","clientNo","N");
        return new Response();
    }
}
