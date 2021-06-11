package com.demo.module.selectTable.controller;

import com.demo.message.Response;
import com.demo.module.selectTable.entity.AllTable;
import com.demo.module.selectTable.entity.RequestAllTableParam;
import com.demo.module.selectTable.sevice.AllTableService;
import com.demo.message.GlobalException;
import com.demo.untils.File.R_StreamContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;

@RequestMapping(value = "Table",method = RequestMethod.POST ,produces="application/json")
@RestController
@CrossOrigin
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
            @RequestBody(required = false) String param
    ){
        return  new Response(allTableService.getTableName(0,9));
    }
}
