class Egg_Dropping_Puzzle {
    static int Recursion(int n, int k) {
        if (n == 1)
            return k;
        if (k <= 1)
            return k;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            ans = Math.min(ans, Math.max(Recursion(n - 1, i - 1), Recursion(n, k - i)) + 1);
        }
        return ans;
    }

    static int Memoization(int n, int k, int dp[][]) {
        if (n == 1)
            return k;
        if (k <= 1)
            return k;
        if (dp[n][k] != -1)
            return dp[n][k];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            ans = Math.min(ans, Math.max(Memoization(n - 1, i - 1, dp), Memoization(n, k - i, dp)) + 1);
        }
        return dp[n][k] = ans;
    }
}