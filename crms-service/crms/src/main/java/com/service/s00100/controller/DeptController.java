package com.service.s00100.controller;

import com.entity.Department;
import com.mapper.DepartMentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class DeptController {

    @Autowired
    DepartMentMapper departMentMapper;
    Department department;

    @RequestMapping(value = "/dept")
    @ResponseBody
    public List getDepartment( String id){
        //对传入的编号进行判空处理，为空查询所有数据***w为空查询所有数据有点问题？？？

        //用hashMap组装数据
        HashMap hashMap=new HashMap();


        //用List组装返回数据
        List recv = new ArrayList();
        int i;
        int j;
        if(id.isEmpty()){
                ArrayList arrayList= (ArrayList) departMentMapper.getDeptAll();
                recv.add(arrayList);
            return recv;
        }else {
            ArrayList department= (ArrayList) departMentMapper.getDeptAll();
            hashMap.put("ID",department);
            recv.add(hashMap);
            return recv;
        }
    }

    /*************************************************************
     * 功能：根据id更新名称
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public int updateDept(String department_name,String id){
        return departMentMapper.updateDept(department_name,Integer.parseInt(id));
    }

    @RequestMapping(value = "/insertDept")
    @ResponseBody
    public int insetDept(
            int id,
            String department_name,
            int department_age,
            char department_sex,
            String department_address,
            String department_occupation){
        department =new Department();
        department.setId(id);
        department.setDepartment_name(department_name);
        department.setDepartment_sex(department_sex);
        department.setDepartment_address(department_address);
        department.setDepartment_age(department_age);
        department.setDepartment_occupation(department_occupation);
        return departMentMapper.insertDept(department);
    }
}
