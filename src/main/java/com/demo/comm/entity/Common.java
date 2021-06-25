package com.demo.comm.entity;


import java.util.Objects;

public class Common {

  private String commCode;
  private String field;
  private String type;
  private String flag;

  public String getCommCode() {
    return commCode;
  }

  public void setCommCode(String commCode) {
    this.commCode = commCode;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Common common = (Common) o;
    return Objects.equals(commCode, common.commCode) &&
            Objects.equals(field, common.field) &&
            Objects.equals(type, common.type) &&
            Objects.equals(flag, common.flag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commCode, field, type, flag);
  }
}
