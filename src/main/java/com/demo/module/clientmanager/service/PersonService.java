package com.demo.module.clientmanager.service;

import com.demo.message.ErrorCodeAndMsg;
import com.demo.message.GlobalException;
import com.demo.module.clientmanager.entry.Person;
import com.demo.module.clientmanager.mapper.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("personService")
public class PersonService implements PersonManager {

    @Autowired
    private  PersonManager personManager;

    /** 根据id查询person信息*/
    @Override
    public ArrayList<Person> getPersonInfo(String id,int offset,int limit) {
        ArrayList<Person> arrayList = personManager.getPersonInfo(id, offset, limit);
            /**查询无记录**/
            if(arrayList.size()<=0){
                throw new GlobalException(ErrorCodeAndMsg.IS_NULL_RECORD);
            }
        return arrayList;
    }
}
