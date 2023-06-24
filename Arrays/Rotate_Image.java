import java.util.Scanner;

class Rotate_Image {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        transpose(n, a);
        rotate(n, a);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        in.close();
    }

    static void transpose(int n, int a[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int t = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = t;
            }
        }
    }

    static void rotate(int n, int a[][]) {
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int t = a[j][i];
                a[j][i] = a[j][n - i - 1];
                a[j][n - i - 1] = t;
            }
        }
    }
}