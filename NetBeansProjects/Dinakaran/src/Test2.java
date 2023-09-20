
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bas200181
 */
public class Test2 {

  public static void main1(String[] args) {
    int[] a = {123, 145, 678, 564};
    int[] b = new int[0];
    int count = 0;

    //  int count=0;
    for (int i = 0; i < a.length; i++) {
      int temp = a[i];
      while (temp != 0) {
        b = Arrays.copyOf(b, b.length + 1);
        b[b.length - 1] = temp % 10;
        temp = temp / 10;

      }

    }
    for (int i = 0; i < b.length; i++) {
      count = 1;
      for (int j = i + 1; j < b.length; j++) {
        if (b[i] == b[j]) {
          count++;
          b[j] = 0;
        }
      }
      if (count >= 1 && b[i] != 0) {
        System.out.println(b[i] + "Contains" + count);
      }
    }

  }

  public static void main(String[] args) {
    String s = "All is well is well";

    char[] ch = s.toCharArray();
    String temp = " ";
    String glo = "";
    //glo =s.replace("is", " ");
    glo = s.replace('i', ' ');
    System.out.println(glo);
    for (int i = 0; i < ch.length; i++) {
      if (ch[4] == 'i' && ch[5] == 's') {
        ch[4] = ' ';
        ch[5] = ' ';
      }

    }
    for (int i = 0; i < ch.length; i++) {
      if (ch[i] != ' ') {
        temp = temp + ch[i];
      }

    }
    //System.out.println(temp);

  }
}
