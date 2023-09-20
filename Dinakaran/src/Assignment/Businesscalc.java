package Assignment;


import Assignment.Calculator2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Businesscalc extends Calculator2 {
    
        double emi() {
        System.out.println("Principal of Loan Amount");
        double a = s.nextDouble();
        System.out.println("Rate of interest");
        double b = s.nextDouble();
        System.out.println("Loan teram in years");
        int n = s.nextInt();
         double E;
      double w=((b/12)/100);
      double w1=1+w;
      double q=Math.pow(w1, n*12);
      E=a*w*(q/(q-1));
      return E;
  }
}
