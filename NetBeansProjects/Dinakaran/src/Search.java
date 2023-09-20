/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Search {
    public static void main(String[] args) {
        int[]a={35,26,18,12,41,14};
        int l=12;
        int count=0;
        
        for(int i=0;i<a.length;i++)
        {
            if(l==a[i])
            {
                System.out.println("element found");
                break;
            }
            
            count++;
        }
        
        System.out.print(count);
    }
    
}
