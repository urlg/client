package com.demo.module.selectTable.entity;

import java.sql.Date;
import java.util.Objects;

public class AllTable {
    String tableName;
    String tableType;
    int tableRows;
    Date createTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllTable allTable = (AllTable) o;
        return tableRows == allTable.tableRows &&
                tableName.equals(allTable.tableName) &&
                tableType.equals(allTable.tableType) &&
                createTime.equals(allTable.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableName, tableType, tableRows, createTime);
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public int getTableRows() {
        return tableRows;
    }

    public void setTableRows(int tableRows) {
        this.tableRows = tableRows;
    }

}
