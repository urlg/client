package com.demo.module.operationTable.controller;
import com.demo.module.operationTable.entity.Department;
import com.demo.module.operationTable.entity.DeptParams;
import com.demo.module.operationTable.service.DepartmentService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * (Department)表控制层
 *
 * @author makejava
 * @since 2021-05-18 22:54:07
 *
 * @ description
 *          serviceName: operation --服务 名
 */
@RestController
@RequestMapping("operation")
@CrossOrigin
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
    @GetMapping("SC00003")
    public Department selectOne(Integer id) {
        return departmentService.queryById(id);
    };
    /**
     * 查询指定行数据
     *
     * @ param offset 查询起始位置
     * @ param limit 查询条数
     * @return 对象列表
     */
    @PostMapping("SC00004")
    //@RequestMapping(value = "SC00004",method = RequestMethod.POST)
    public List<Department> queryAll(
            @RequestBody DeptParams deptParams){
        return departmentService.queryAllByLimit( deptParams.getOffset(),deptParams.getLimit());
    }

}