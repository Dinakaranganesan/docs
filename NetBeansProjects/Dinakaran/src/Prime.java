/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Prime {
    
    void prime(int n){
        int count=0;
    int k=0;
    //int l;
    int [] prime=new int[n];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                if(i%j==0)
                {
                   count++;
                }}
                if(count==2)
                   {
                       System.out.println(i);
                       prime[k]=i;
                       k++;
                       
                
                
            }count=0;
            }
//         for(int i=0;i<prime.length;i++)
//        {
//            System.out.println(prime[i]+" ");
//        }
            
             
        
    }
    public static void main(String[] args) {
        Prime p=new Prime();
        p.prime(70);
       
        
    }
}
