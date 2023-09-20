/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Count {
    public static void main(String[] args) {
        String a="aabbcd";
        
        for(int i=0;i<a.length();i++)
        
        {int count=1;
            for (int j = i+1; j <a.length(); j++) {
                if(a.charAt(i)==a.charAt(j))
                {
                    count++;
                    System.out.println(a.charAt(i));
                    System.out.println(count);
                   
                }  
                 
            }
            
        }
    }
}
