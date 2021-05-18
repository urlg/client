package com.demo.controller;

import com.demo.entity.Department;
import com.demo.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Department)表控制层
 *
 * @author makejava
 * @since 2021-05-18 22:54:07
 */
@RestController
@RequestMapping("/")
public class DepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Department selectOne(Integer id) {
        System.out.println("id"+id);
        return departmentService.queryById(id);
    }

}