import java.util.*;

class Unique_Paths {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        // int ans = Recursion(m - 1, n - 1);
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        // int ans = Memoization(m - 1, n - 1, dp);
        // int ans = Tabulation(m, n);
        int ans = Space_Optimised(m, n);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int m, int n) {
        if (m == 0 && n == 0)
            return 1;
        int top = 0;
        int left = 0;
        if (m > 0)
            top = Recursion(m - 1, n);
        if (n > 0)
            left = Recursion(m, n - 1);
        return left + top;
    }

    static int Memoization(int m, int n, int[][] dp) {
        if (m == 0 && n == 0)
            return 1;
        int top = 0;
        int left = 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (m > 0)
            top = Memoization(m - 1, n, dp);
        if (n > 0)
            left = Memoization(m, n - 1, dp);
        dp[m][n] = left + top;
        return dp[m][n];
    }

    static int Tabulation(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < n; i++)
            dp[0][i] = 1;
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    static int Space_Optimised(int m, int n) {
        int dp[] = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}