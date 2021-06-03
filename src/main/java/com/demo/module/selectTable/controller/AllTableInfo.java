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
import java.util.ArrayList;

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
    public Response getTableName(@RequestBody RequestAllTableParam param){
        String s = readStreamContent.readFileContent("d:/db.txt");
        //System.out.println("controller"+s);

        return  new Response(allTableService.getTableName(param.getOffset(),param.getLimit()));
    }
}
