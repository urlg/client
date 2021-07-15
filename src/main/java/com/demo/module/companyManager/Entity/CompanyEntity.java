package com.demo.module.companyManager.Entity;


import com.demo.module.employeeManager.Entity.EmployeeInfo;

import java.util.ArrayList;
import java.util.Objects;

/**公司表
 * @author 86136**/
public class CompanyEntity {

  private String companyName;
  private long companyCode;
  private String companyDepartment;
  private String companyUsing;

  /**将对象employee实体类**/
  private ArrayList<EmployeeInfo> employeeInfos;

  public ArrayList<EmployeeInfo> getEmployeeInfos() {
    return employeeInfos;
  }

  public void setEmployeeInfos(ArrayList<EmployeeInfo> employeeInfos) {
    this.employeeInfos = employeeInfos;
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CompanyEntity that = (CompanyEntity) o;
    return companyCode == that.companyCode &&
            companyName.equals(that.companyName) &&
            companyDepartment.equals(that.companyDepartment) &&
            companyUsing.equals(that.companyUsing);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyName, companyCode, companyDepartment, companyUsing);
  }
}
