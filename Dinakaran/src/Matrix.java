
import java.util.Scanner;

public class Matrix {

    static int row_a, col_a, row_b, col_b;
    static boolean flag = false;

    public static void main(String[] args) {
        Matrix m = new Matrix();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row and column of A matrix");
        row_a = sc.nextInt();
        col_a = sc.nextInt();
        System.out.println("Enter the row and column of B matrix");
        row_b = sc.nextInt();
        col_b = sc.nextInt();
        int[][] a = new int[row_a][col_a];
        int[][] b = new int[row_b][col_b];
        System.out.println("Enter the A elements");

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the B elements");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = sc.nextInt();

            }
        }
        System.out.println("1.Addition");
        System.out.println("2.Multiplication");
        System.out.println("3.Transpose");
        int select_no = sc.nextInt();
        switch (select_no) {
            case 1:
                m.addition(a, b);
                break;
            case 2:
                m.multiplication(a, b);
                break;
            case 3:
                m.transpose(a);
                break;
        }

    }

    void addition(int[][] a, int[][] b) {
        int[][] c = new int[row_a][col_b];
        if (row_a == row_b && col_a == col_b) {

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    System.out.print((c[i][j] = a[i][j] + b[i][j]) + " ");

                }
                System.out.println();
            }
            
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[i].length; j++) {
                    System.out.print(c[i][j]+ " ");

                }
                System.out.println();
            }

        } else {
            System.out.println("MATRIX FORMAT IS WRONG IN ADDITION");
        }

    }

    void multiplication(int[][] a, int[][] b) {
        int[][] d = new int[row_a][col_b];
        if (col_a == row_b) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    for (int k = 0; k < a[i].length; k++) {
                        d[i][j] = d[i][j] + (a[i][k] * b[k][j]);

                    }
                }
            }

        }

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                System.out.print(d[i][j] + " ");
                if (a[i][j] == d[i][j]) {
                    flag = true;
                }
            }
            System.out.println();
        }
        if (flag == true) {
            System.out.println("Unit Matrix");
        }
    }

    void transpose(int[][] a) {
        int[][] e = new int[row_a][col_a];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print((e[i][j] = a[j][i]) + " ");
            }
            System.out.println(" ");

        }

    }

}
