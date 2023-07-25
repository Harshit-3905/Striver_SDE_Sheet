import java.util.*;

class Knapsack {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int W = in.nextInt();
        int wt[] = new int[n];
        int val[] = new int[n];
        for (int i = 0; i < n; i++)
            wt[i] = in.nextInt();
        for (int i = 0; i < n; i++)
            val[i] = in.nextInt();
        // int ans = Recursion(wt, val, n - 1, W);
        int dp[][] = new int[n][W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++)
                dp[i][j] = -1;
        }
        // int ans = Memoization(wt, val, n - 1, W, dp);
        // int ans = Tabulation(wt, val, n - 1, W);Harshit@3905
        // int ans = Space_Optimised(wt, val, n - 1, W);
        int ans = Space_Optimised1(wt, val, n - 1, W);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int wt[], int val[], int i, int W) {
        if (i == -1)
            return 0;
        int notpick = Recursion(wt, val, i - 1, W);
        int pick = Integer.MIN_VALUE;
        if (wt[i] <= W) {
            pick = val[i] + Recursion(wt, val, i - 1, W - wt[i]);
        }
        return Math.max(pick, notpick);
    }

    static int Memoization(int wt[], int val[], int i, int W, int[][] dp) {
        if (i == -1)
            return 0;
        if (dp[i][W] != -1)
            return dp[i][W];
        int notpick = Memoization(wt, val, i - 1, W, dp);
        int pick = Integer.MIN_VALUE;
        if (wt[i] <= W) {
            pick = val[i] + Memoization(wt, val, i - 1, W - wt[i], dp);
        }
        dp[i][W] = Math.max(pick, notpick);
        return dp[i][W];
    }

    static int Tabulation(int wt[], int val[], int n, int W) {
        int dp[][] = new int[n][W + 1];
        for (int i = 0; i <= W; i++) {
            if (wt[0] <= i)
                dp[0][i] = val[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                int notpick = dp[i - 1][j];
                int pick = Integer.MIN_VALUE;
                if (wt[i] <= j)
                    pick = val[i] + dp[i - 1][j - wt[i]];
                dp[i][j] = Math.max(pick, notpick);
            }
        }
        return dp[n - 1][W];
    }

    static int Space_Optimised(int wt[], int val[], int n, int W) {
        int prev[] = new int[W + 1];
        int curr[] = new int[W + 1];
        for (int i = 0; i <= W; i++) {
            if (wt[0] <= i)
                prev[i] = val[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                int notpick = prev[j];
                int pick = Integer.MIN_VALUE;
                if (wt[i] <= j)
                    pick = val[i] + prev[j - wt[i]];
                curr[j] = Math.max(pick, notpick);
            }
            for (int j = 0; j <= W; j++)
                prev[j] = curr[j];
        }
        return prev[W];
    }

    static int Space_Optimised1(int wt[], int val[], int n, int W) {
        int curr[] = new int[W + 1];
        for (int i = 0; i <= W; i++) {
            if (wt[0] <= i)
                curr[i] = val[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = W; j >= 0; j--) {
                int notpick = curr[j];
                int pick = Integer.MIN_VALUE;
                if (wt[i] <= j)
                    pick = val[i] + curr[j - wt[i]];
                curr[j] = Math.max(pick, notpick);
            }
        }
        return curr[W];
    }

}