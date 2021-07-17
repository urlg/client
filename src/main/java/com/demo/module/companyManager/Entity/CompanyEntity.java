package com.demo.module.companyManager.Entity;


import com.demo.module.employeeManager.Entity.EmployeeInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Objects;

/**公司表
 * @author 86136**/
public class CompanyEntity {

  /**公司名称**/
  private String companyName;
  /**公司代码**/
  private long companyCode;
  /**公司部门**/
  private String companyDepartment;
  /**是否启用 Y-启用 N-未启用**/
  private String companyUsing;
  /**查询到的总条数**/
  private int totalNumber;

  /**将对象employee实体类**/
  private ArrayList<EmployeeInfo> employeeInfos;


  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public long getCompanyCode() {
    return companyCode;
  }

  public void setCompanyCode(long companyCode) {
    this.companyCode = companyCode;
  }

  public String getCompanyDepartment() {
    return companyDepartment;
  }

  public void setCompanyDepartment(String companyDepartment) {
    this.companyDepartment = companyDepartment;
  }

  public String getCompanyUsing() {
    return companyUsing;
  }

  public void setCompanyUsing(String companyUsing) {
    this.companyUsing = companyUsing;
  }

  public int getTotalNumber() {
    return totalNumber;
  }

  public void setTotalNumber(int totalNumber) {
    this.totalNumber = totalNumber;
  }

  public ArrayList<EmployeeInfo> getEmployeeInfos() {
    return employeeInfos;
  }

  public void setEmployeeInfos(ArrayList<EmployeeInfo> employeeInfos) {
    this.employeeInfos = employeeInfos;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompanyEntity that = (CompanyEntity) o;
    return companyCode == that.companyCode &&
            totalNumber == that.totalNumber &&
            companyName.equals(that.companyName) &&
            companyDepartment.equals(that.companyDepartment) &&
            companyUsing.equals(that.companyUsing) &&
            employeeInfos.equals(that.employeeInfos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyName, companyCode, companyDepartment, companyUsing, totalNumber, employeeInfos);
  }
}
