
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Union
        
{
    
    public static void main(String[] args) 
    {
        Union u=new Union();
        Scanner s=new Scanner(System .in);
        System.out.println("Enter the Size of array");
        int size=s.nextInt();
        int []a=new int[size];
        int []b=new int[size];
        int []d=new int[size];
        int []c=new int[a.length+b.length+d.length];
        System.out.println("Enter the array A elements" );
        for(int i=0;i<a.length;i++)
        {
            
            a[i]=s.nextInt();
        }
        
        System.out.println("Enter the array B elements");
        for(int j=0;j<b.length;j++)
        {
          
            b[j]=s.nextInt();
        }
        System.out.println("Enter the array D elements" );
        for(int n=0;n<d.length;n++)
        {
            d[n]=s.nextInt();
        }
        for(int k=0;k<a.length;k++)
        {
           c[k]=a[k];
        }
        for(int l=0;l<b.length;l++)
                   {
                       c[a.length+l]=b[l];
                   }
        for(int m=0;m<d.length;m++)
        {
            c[a.length+b.length+m]=d[m];
        }
        System.out.print("( ");
        for(int n=0;n<c.length;n++)
        {
            System.out.print(c[n]+",");
}
        System.out.print(")");
        
}
}