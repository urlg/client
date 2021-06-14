package com.demo.module.selectTable.controller;

import com.demo.message.Response;
import com.demo.module.selectTable.entity.RequestAllTableParam;
import com.demo.module.selectTable.sevice.AllTableService;
import com.demo.untils.File.R_StreamContent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RequestMapping(value = "Table",method = RequestMethod.POST)
@RestController
//@CrossOrigin
@Slf4j
public class AllTableInfo {
    @Resource
    private AllTableService allTableService;

    @Autowired
    private R_StreamContent readStreamContent;
    /**
     * 查询所有的表名
     * @return
     */
    @PostMapping("SD00001")
    public Response getTableName(
            //@RequestBody RequestAllTableParam requestAllTableParam
            ){
        //log.error("param:*******:"+(RequestAllTableParam)param);
        return  new Response(allTableService.getTableName(0,9));
    }
}
