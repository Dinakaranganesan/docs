/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coding;

/**
 *
 * @author bas200181
 */
public class Employee {
  private int employeeId;
  private String name;
  private double salary;

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public Employee(int employeeId, String name, double salary) {
    this.employeeId = employeeId;
    this.name = name;
    this.salary = salary;
  }
  
}
