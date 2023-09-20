/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPS;

/**
 *
 * @author bas200181
 */
public class Staff extends Person{
    private String school;
    private double pay;
    Staff(String name,String address,String school,double pay){
        super(name,address);
        this.school=school;
        this.pay=pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
    
    
    
@Override
public String toString()
{
return "Staff Person"+getName()+getAddress()+this.school+this.pay;
}
    public static void main(String[] args) {
        Staff s=new Staff("Jack","07","VSS",15000);
        System.out.println(s);
        Student t=new Student("CLement","08","MECH",2000,1999);
        System.out.println(t);
        Person u=new Person("John","09");
        System.out.println(u);
    }

}
