package com.demo.module.selectTable.entity;

public class RequestAllTableParam {
    int offset;
    int limit;
    String userId;

    RequestAllTableParam(){}
    RequestAllTableParam(int offset,int limit,String userId){
        this.offset = offset;
        this.limit = limit;
        this.userId = userId;
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
    public void setUserId(String userId){ this.userId = userId;}
    public void getUserId(String userId){this.userId = userId;}
}
