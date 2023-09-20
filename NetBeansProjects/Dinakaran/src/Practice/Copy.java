/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

/**
 *
 * @author bas200181
 */
public class Copy {

  public static void main(String[] args) {
    int[] a = {12, 23, 23, 12, 34, 57, 63, 3, 3, 34};
    int count = 0;
    for (int i = 0; i < a.length; i++) {
      count = 1;
      for (int j = i + 1; j < a.length; j++) {
        if (a[i] == a[j]) {
          count++;
          a[j] = 0;
        }

      }
      if (a[i] != 0 && count > 0) {
        System.out.println(a[i] + " " + count + "" + "times");
        count = 0;
      }
    }

  }
}
