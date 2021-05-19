package com.demo.module.selectTable.entity;

public class RequestAllTableParam {
    int offset;
    int limit;

    RequestAllTableParam(){}
    RequestAllTableParam(int offset,int limit){
        this.offset = offset;
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
