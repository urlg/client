package com.demo.module.selectTable.sevice;

import com.demo.module.selectTable.entity.AllTable;
import com.demo.module.selectTable.mapper.AllTableMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("allTableService")
public class AllTableService {
    @Resource
    private  AllTableMapper allTableMapper;
    public ArrayList <AllTable> getTableName(Integer offset,Integer limit){
        return allTableMapper.getTableName(offset,limit);
    }
}
