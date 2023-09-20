/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Entity;

/**
 *
 * @author bas200181
 */
@Entity
public class Employee {
    private String employeeName;
    private String employeeDepartment;
    private long employeeId;

    public Employee(long employeeId, String employeeName, String employeeDepartment) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeName=" + employeeName + ", employeeDepartment=" + employeeDepartment + ", employeeId=" + employeeId + '}';
    }

}
