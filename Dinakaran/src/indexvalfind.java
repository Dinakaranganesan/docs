
import java.util.Scanner;

public class indexvalfind {

    public static void main(String[] args) {
        int[] arr = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int[] arr1 = new int[5];
        boolean b = true;
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(" enter the element");
            arr1[i] = scn.nextInt();
        }
        int j = 0;
        for (int i = 3; i < 8; i++) {
            if (arr[i] == arr1[j]) {
                b = true;

                j++;
            } else {
                b = false;
                break;
            }

        }
        if (b == true) {
            System.out.println("all elements are there in the given array");
        } else {
            System.out.println("elements are Not there in the given array ");
        }

    }
}
