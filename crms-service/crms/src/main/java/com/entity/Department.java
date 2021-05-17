package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    private String department_name;
    private int department_age;
    private char department_sex;
    private String department_address;
    private String department_occupation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getDepartment_age() {
        return department_age;
    }

    public void setDepartment_age(int department_age) {
        this.department_age = department_age;
    }

    public char getDepartment_sex() {
        return department_sex;
    }

    public void setDepartment_sex(char department_sex) {
        this.department_sex = department_sex;
    }

    public String getDepartment_address() {
        return department_address;
    }

    public void setDepartment_address(String department_address) {
        this.department_address = department_address;
    }

    public String getDepartment_occupation() {
        return department_occupation;
    }

    public void setDepartment_occupation(String department_occupation) {
        this.department_occupation = department_occupation;
    }
}
