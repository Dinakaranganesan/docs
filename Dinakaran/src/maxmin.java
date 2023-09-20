
import java.util.Scanner;
public class maxmin {
 int l=0;
 int lar(int b[])
    {
        for(int k=0;k<b.length;k++)
        {
        if(l<b[k])
        {
            l=b[k];
        }
       
        }
    return l;}
        
 int sml(int b[])
 {int s=b[0];
        for(int k=0;k<b.length;k++)
        {
        if(s>b[k])
        {
            s=b[k];
        }
       
        }
    return s;}
    
public static void main(String[] args) {
        Scanner s=new Scanner(System.in);  
        System.out.println("Enter the Size of the array");
        int size=s.nextInt();
 int []a=new int[size];
 for(int i=0;i<a.length;i++)
 {
     System.out.println("Enter the array elements");
    a[i]=s.nextInt();
        
        }
 maxmin h=new maxmin();
 h.lar(a);
 h.sml(a);
    System.out.println("The largest element in the array"+h.lar(a));
    System.out.println("The smallest element in the array"+h.sml(a));
// for(int j=0;j<a.length;j++){
//     System.out.println("The array elements"+a[j]);
// }
         
    }
}