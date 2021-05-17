package com.example.demo.entity;

import java.io.Serializable;

/**
 * (Department)实体类
 *
 * @author makejava
 * @since 2021-05-17 23:21:39
 */
public class Department implements Serializable {
    private static final long serialVersionUID = 786325839014574985L;
    
    private Integer id;
    /**
    * 部门名称
    */
    private String name;
    
    private Integer parentid;
    
    private String deppath;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getDeppath() {
        return deppath;
    }

    public void setDeppath(String deppath) {
        this.deppath = deppath;
    }

}