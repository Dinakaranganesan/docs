/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class SumOfMultiples {
int sum=0;

        int count=0;
   int  sum(int number, int[] set) {
          
        for (int i = number-1; i>=0; i--) {
            if(i<20)
            if (i % set[0] == 0 || i % set[1] == 0) {
                sum += i;
            }
        }
        return sum; 
    }
    int digit(int num)
    {
        while(num!=0)
        {
            num=num/10;
            count++;
    }
                          while(num!=0)
            {
               int ans=num%10;
                double ans1=Math.pow(ans,count);
                 sum+=ans1;
                num=num/10;
                 }
            return sum;
    }
    public static void main(String[] args) {
        int[] a ={3,5};
        SumOfMultiples s = new SumOfMultiples();
        System.out.println(s.sum(20, a));
        System.out.println(s.digit(154));
        //System.out.println(s.sum);
    }
}
