package com.demo.module.operationTable.entity;

import java.io.Serializable;

/**
 * (Department)实体类
 *
 * @author makejava
 * @since 2021-05-18 22:54:07
 */
public class Department implements Serializable {
    private static final long serialVersionUID = -30957178491855817L;
    
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