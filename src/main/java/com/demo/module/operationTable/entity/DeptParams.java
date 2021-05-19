package com.demo.module.operationTable.entity;

public class DeptParams {
    int offset;
    int limit;

    DeptParams (){}
    DeptParams(int offset,int limit){
        this.offset =offset;
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
