/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

/**
 *
 * @author bas200181
 */
public class Split {

  public static void main(String[] args) {
    String s = "kanneane";
    char []s1=s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      for (int j = i+1; j < s.length(); j++) {
        if(s1[i]==s1[j] && s1[j]!='0')
        {
          System.out.println(s1[j]);
          //s.replace(s.charAt(j), 'o');
          s1[j]='0';
          break;
        }
        
      }
    }
    String d=" Dina la ";
    System.out.println(d.trim());
     System.out.println(d);
    
  }
}
