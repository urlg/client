package com.demo.module.selectTable.controller;

import com.demo.module.selectTable.entity.AllTable;
import com.demo.module.selectTable.entity.RequestAllTableParam;
import com.demo.module.selectTable.sevice.AllTableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("Table")
@RestController
@CrossOrigin
public class AllTableInfo {
    @Resource
    private AllTableService allTableService;

    /**
     * 查询所有的表名
     * @return
     */
    @PostMapping("SD00001")
    ArrayList<AllTable> getTableName(@RequestBody RequestAllTableParam param){
        return  allTableService.getTableName(param.getOffset(),param.getLimit());
    }
}
