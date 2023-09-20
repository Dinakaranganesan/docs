
import java.util.Scanner;

public class Counting{
    static int count = 1;
 
    public static void main(String[] args) {
        Counting c=new  Counting();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.nextLine();
        System.out.println(c.wordCounting(str));
    }
 int wordCounting( String str)
 {        for (int i = 0; i < str.length() - 1; i++)
        {
            if ((str.charAt(i) == ' ') && (str.charAt(i + 1) != ' '))
            {
                count++;
            }
        }
        return count;
    }
}
 

    

