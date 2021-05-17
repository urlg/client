package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Department)表控制层
 *
 * @author makejava
 * @since 2021-05-17 23:21:44
 */
@RestController
//@RequestMapping("department")
public class DepartmentController {
    /**
     * 服务对象
//     */
//    @Resource
//    private DepartmentService departmentService;
//
//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("selectOne")
//    public Department selectOne(Integer id) {
//        return this.departmentService.queryById(id);
//    }


    @PostMapping("dep")
    public String getUserName(){
        return  "HelloWorld";
    }

}