package com.demo.module.clientmanager.mapper;

import com.demo.module.clientmanager.entry.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("personManager")
public interface PersonManager {

    /**
     * 通过Id查询person信息
     * {@param id}
     * {@param offset} 起始笔数
     * {@param limit}  查询笔数
     */
    public ArrayList<Person> getPersonInfo(String id,int offset,int limit);
}
