import java.util.*;

class Minimum_Path_Sum {
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
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        // int ans1 = Recursion(grid, m, n, 0, 0);
        // int ans2 = Memoization(grid, m, n, 0, 0, dp);
        // int ans3 = Tabulation(grid, m, n);
        int ans4 = Space_Optimised(grid, m, n);
        System.out.println(ans4);
        in.close();
    }

    // Time Complexity : O(2^mn)
    // Space Complexity : O(m+n)
    static int Recursion(int[][] grid, int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1)
            return grid[i][j];
        int x = 100000000;
        if (i + 1 < m)
            x = Math.min(x, grid[i][j] + Recursion(grid, m, n, i + 1, j));
        if (j + 1 < n)
            x = Math.min(x, grid[i][j] + Recursion(grid, m, n, i, j + 1));
        return x;
    }

    // Time Complexity : O(m*n)
    // Space Complexity : O(m*n)+O(m*n)
    static int Memoization(int[][] grid, int m, int n, int i, int j, int dp[][]) {
        if (i == m - 1 && j == n - 1)
            return grid[i][j];
        int x = 100000000;
        if (i + 1 < m) {
            if (dp[i + 1][j] == -1)
                x = Math.min(x, grid[i][j] + Memoization(grid, m, n, i + 1, j, dp));
            else
                x = Math.min(x, grid[i][j] + dp[i + 1][j]);
        }
        if (j + 1 < n) {
            if (dp[i][j + 1] == -1)
                x = Math.min(x, grid[i][j] + Memoization(grid, m, n, i, j + 1, dp));
            else
                x = Math.min(x, grid[i][j] + dp[i][j + 1]);
        }
        dp[i][j] = x;
        return x;
    }

    // Time Complexity : O(m*n)
    // Space Complexity : O(m*n)
    static int Tabulation(int[][] grid, int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = 10000000;
                if (i - 1 >= 0)
                    x = Math.min(x, grid[i][j] + dp[i - 1][j]);
                if (j - 1 >= 0)
                    x = Math.min(x, grid[i][j] + dp[i][j - 1]);
                if (i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else
                    dp[i][j] = x;
            }
        }
        return dp[m - 1][n - 1];
    }

    // Time Complexity : O(m*n)
    // Space Complexity : O(n)
    static int Space_Optimised(int[][] grid, int m, int n) {
        int dp[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = 10000000;
                if (i - 1 >= 0)
                    x = Math.min(x, grid[i][j] + dp[j]);
                if (j - 1 >= 0)
                    x = Math.min(x, grid[i][j] + dp[j - 1]);
                if (i == 0 && j == 0)
                    dp[j] = grid[i][j];
                else
                    dp[j] = x;
            }
        }
        return dp[n - 1];
    }
}