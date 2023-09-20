
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Sorter {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
        //size to array
        System.out.println("Enter the Size of the Array");
        int size=sc.nextInt();
          int [] b=new int[size];
        for(int i=0;i<b.length;i++)
        {
            System.out.print("Enter the Elements "+i+" " +"is" +" ");
        b[i]=sc.nextInt();
        }
      
      
        System.out.println("1.Bubble Sort");
        System.out.println("2.Insertion sort");
        System.out.println("3.Selection sort");
        System.out.println("Enter the number  for which type of sort");
        int select=sc.nextInt();
        switch(select)
        {
            case  1:
              int []a=  bubbleSort(b);
            //  int bb[] = b;
                for(int temp:a){
                    System.out.println(temp);
                }
                /*for (int i = 0; i < c.length; i++) {
                    System.out.print(c[i]+" ");
                    
                }*/
                break;
            
        
            case 2:
            int []i=    insertionSort(b);
                for(int ins:i){
                    System.out.println(ins);
            }
                break;
            case 3:
                int []s=selectionSort(b);
                for(int sel:s){
                    System.out.println(sel);
                }
        
                
           default :System.out.println("Enter the correct no");
        
    }}
              
             public static int[] bubbleSort(int a[])
            {
             
               for (int i = 0; i < a.length-1; i++) {
                  for(int j=0;j<a.length-1-i;j++){
                       if(a[j]>a[j+1])
                       {
                          int temp=a[j];
                          a[j]=a[j+1];
                          a[j+1]=temp;
                          
                          
                       }
                           
                   }
                   
                 
                
              // for (int i = 0; i < a.length; i++) {
               //  System.out.print(a[i]+" ");
                // }
            }
               return a;
            }
            
             public static int[] insertionSort(int a[])
             {
                 for(int i=1;i<a.length;i++)
                 {
                     int storef=a[i];
                     int j=i-1;
                     while(j>=0 && a[j]>storef)
                     {
                         a[j+1]=a[j];
                        j--;
                     }
                     a[j+1]=storef;
                 }
                 return a;
             }
         public static    int[] selectionSort(int[] b)
      {
         for(int i=0;i<b.length;i++)
         {
             int tempsmall=i;
             for(int j=i+1;j<b.length;j++)
             {
                  if(b[j]<b[tempsmall])
                  {
                     tempsmall=j;         
                  }
             }
             
             if(i!=tempsmall)
             {
                  b[i]=b[i]+b[tempsmall];
                  b[tempsmall]=b[i]-b[tempsmall];
                  b[i]=b[i]-b[tempsmall];
              //System.out.println("--i--"+i+" "+sor[i]+"--"+tempsmall+" "+sor[tempsmall]);
             }  
             //int t=sor[i];
             //sor[i]=sor[tempsmall];
            // sor[tempsmall]=t;
         
         }
          
         return b;
      }
}
                     
      
                   
                   
            
    
    
          
            
 

   