/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

/**
 *
 * @author bas200181
 */
public class Duplicate {

  public static void main1(String[] args) {
    int count = 0;
    String s = "jobin raj jobin raj";
    char[] a = s.toCharArray();
    for (int i = 0; i < a.length; i++) {
      count = 1;
      for (int j = i + 1; j < a.length; j++) {
        if (a[i] == a[j]) {
          count++;
          a[j] = '0';
        }

      }
      if (count >= 1 && a[i] != '0' && a[i] != ' ') {
        System.out.println(a[i] + "contains" + count);
      }

    }
  }

  public static void main(String[] args) {
    String a = "Arunkumar is Action king";
    String[] arr = a.split(" ");
    String store = "";
    for (int i = 0; i < arr.length; i++) {
      if (i % 2 == 1) {
        String f = "";
        for (int j = arr[i].length()-1; j >= 0; j--) {
          f = f +arr[i].charAt(j);
        }store = store + " "+f;
      } else {
        store = store+ " "+arr[i] ;
      }
    }
    System.out.println(store);
  }
  
}
