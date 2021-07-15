package com.demo.comm.entity;


import java.util.Objects;

public class Common {

  private String commonCode;
  private String checkField;
  private String isNecessary;
  private java.sql.Timestamp createTime;


  public String getCommonCode() {

    return commonCode;
  }

  public void setCommonCode(String commonCode) {

    this.commonCode = commonCode;
  }


  public String getCheckField() {

    return checkField;
  }

  public void setCheckField(String checkField)
  {
    this.checkField = checkField;
  }


  public String getIsNecessary()
  {
    return isNecessary;
  }

  public void setIsNecessary(String isNecessary) {

    this.isNecessary = isNecessary;
  }


  public java.sql.Timestamp getCreateTime() {

    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {

    this.createTime = createTime;
  }

  /**重写equals**/
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Common common = (Common) o;
    return commonCode.equals(common.commonCode) &&
            checkField.equals(common.checkField) &&
            isNecessary.equals(common.isNecessary) &&
            createTime.equals(common.createTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commonCode, checkField, isNecessary, createTime);
  }
}
