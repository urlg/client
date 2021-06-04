package com.demo.module.selectTable.sevice;

import com.demo.module.selectTable.entity.AllTable;
import com.demo.module.selectTable.mapper.AllTableMapper;
import com.demo.untils.File.R_StreamContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("allTableService")
public class AllTableService {
    @Resource
    private  AllTableMapper allTableMapper;
    @Autowired
    private R_StreamContent readStreamContent;
    public ArrayList <AllTable> getTableName(Integer offset,Integer limit){
        return allTableMapper.getTableName(offset,limit);
    }
}
