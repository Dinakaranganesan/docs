/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class two {
    public static void main(String[] args) {
        int[] []a={{35,26,18,12,41,14},{31,19,64,88,22,19}};
        int s=12;
        int count=0;
        boolean a1=false;
       for(int i=0;i<a.length;i++)
       { 
          for( int j=0;j<a[i].length;j++)
            {count++;
                
                if(s==a[i][j])
                {
                    System.out.println("Element found");
                     a1=true;
                    break;
            }
                
            }
          if(a1==true)
                    break;
          
       }
       System.out.println(count);
      
                  
    }
}
