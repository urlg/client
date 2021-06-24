package com.demo.comm.mapper;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("commonManager")
@SuppressWarnings("all")
public interface CommonManager {

    /**
     * 根据commcode查询到所有的输入字段
     *      QryPerson0001.req
     */
   public ArrayList getCommonInfo(String commcode);
}
