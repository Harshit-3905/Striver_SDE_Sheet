import java.util.Scanner;

class Set_Matrix_Zero {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int grid[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        // Brute_Force(grid, m, n);
        Optimised(grid, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        in.close();
    }

    // Time Complexity : O(n^2)
    // Time Complexity : O(n)
    public static void Brute_Force(int[][] grid, int m, int n) {
        boolean r[] = new boolean[m];
        boolean c[] = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    r[i] = true;
                    c[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (r[i] == true || c[j] == true)
                    grid[i][j] = 0;
            }
        }
    }

    // Time Complexity : O(n^2)
    // Time Complexity : O(1)
    public static void Optimised(int[][] grid, int m, int n) {
        boolean row = false;
        boolean col = false;
        for (int j = 0; j < n; j++)
            if (grid[0][j] == 0) {
                row = true;
                break;
            }
        for (int i = 0; i < m; i++)
            if (grid[i][0] == 0) {
                col = true;
                break;
            }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 0) {
                    grid[0][j] = 0;
                    break;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][0] = 0;
                    break;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][0] == 0 || grid[0][j] == 0)
                    grid[i][j] = 0;
            }
        }

        if (col) {
            for (int i = 0; i < m; i++)
                grid[i][0] = 0;
        }
        if (row) {
            for (int j = 0; j < n; j++)
                grid[0][j] = 0;
        }
    }
}