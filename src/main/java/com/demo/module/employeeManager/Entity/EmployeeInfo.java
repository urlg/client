package com.demo.module.employeeManager.Entity;


import com.demo.module.companyManager.Entity.CompanyEntity;

import java.util.Objects;

/**员工信息
 * @author 86136**/
public class EmployeeInfo {

  private long companyCode;
  private String empName;
  private long empCode;
  private java.sql.Timestamp empTime;
  private String empDepartment;
  private String empType;
  private CompanyEntity companyEntity;


  public CompanyEntity getCompanyEntity() {
    return companyEntity;
  }

  public void setCompanyEntity(CompanyEntity companyEntity) {
    this.companyEntity = companyEntity;
  }

  public int getTotalNumber() {
    return totalNumber;
  }

  public void setTotalNumber(int totalNumber) {
    this.totalNumber = totalNumber;
  }

  private int totalNumber;


  public long getCompanyCode() {
    return companyCode;
  }

  public void setCompanyCode(long companyCode) {
    this.companyCode = companyCode;
  }


  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }


  public long getEmpCode() {
    return empCode;
  }

  public void setEmpCode(long empCode) {
    this.empCode = empCode;
  }


  public java.sql.Timestamp getEmpTime() {
    return empTime;
  }

  public void setEmpTime(java.sql.Timestamp empTime) {
    this.empTime = empTime;
  }


  public String getEmpDepartment() {
    return empDepartment;
  }

  public void setEmpDepartment(String empDepartment) {
    this.empDepartment = empDepartment;
  }


  public String getEmpType() {
    return empType;
  }

  public void setEmpType(String empType) {
    this.empType = empType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EmployeeInfo that = (EmployeeInfo) o;
    return companyCode == that.companyCode &&
            empCode == that.empCode &&
            totalNumber == that.totalNumber &&
            empName.equals(that.empName) &&
            empTime.equals(that.empTime) &&
            empDepartment.equals(that.empDepartment) &&
            empType.equals(that.empType) &&
            companyEntity.equals(that.companyEntity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyCode, empName, empCode, empTime, empDepartment, empType, companyEntity, totalNumber);
  }
}
