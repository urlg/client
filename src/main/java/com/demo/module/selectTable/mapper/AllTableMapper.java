package com.demo.module.selectTable.mapper;

import com.demo.module.selectTable.entity.AllTable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface AllTableMapper {
    /**
     * 查询mysql中的所有表
     */
    ArrayList <AllTable>getTableName(Integer offset,Integer limit);
}
