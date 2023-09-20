

import java.util.Scanner;
public class negpos{
    static boolean t=false;
    static void altern(int[] a){
       for(int i=0;i<a.length-1;i++){
          if((a[i]>0) && (a[i+1]<0) || ((a[i]<0) && (a[i+1]>0))){
              t=true;
          }
          else
          {
              t=false;
              break;
          }
       
       }
       if(t==true)
       {
           System.out.println(t);
       }
       else
            System.out.println(t);
    }
    
    public static void main(String[] args) {
           Scanner scn=new Scanner(System.in);
           int size=scn.nextInt();
           int[] arr=new int[size];
           for(int i=0;i<arr.length;i++){
               System.out.println("enter the element");
              arr[i]=scn.nextInt();
           }
           altern(arr);
    }
}

