package Assignment;


import Assignment.Businesscalc;

    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Financecalc extends Businesscalc
{
      public double simpleInterest() {
        System.out.println("Principal Amount");
        double a = s.nextDouble();
        System.out.println("Rate of interest");
        double b = s.nextDouble();
        System.out.println("time  teram in years");
        double n = s.nextDouble();
        double ins;
         double ans=a*b*n;
         ins=a*(1+(b/100)*n);
   ans=ans/100;
  return ins;
  }
public double compoundInterest(){
        System.out.println("enter the principle amount");
        double p=s.nextDouble();
        System.out.println("enter the rate of interest");
        double r=s.nextDouble();
        System.out.println("number of years");
        int n=s.nextInt();
        double v=(1+(r/100));
        double a=Math.pow(v, n);
        double Total=p*v;
        System.out.println(Total);
           return Total;
}
    
}
