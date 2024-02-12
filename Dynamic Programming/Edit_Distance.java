public class Edit_Distance {
    int Recursion(int i, int j, String word1, String word2) {
        if (j == word2.length())
            return word1.length() - i;
        if (i == word1.length())
            return word2.length() - j;
        if (word1.charAt(i) == word2.charAt(j))
            return Recursion(i + 1, j + 1, word1, word2);
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, 1 + Recursion(i, j + 1, word1, word2));
        ans = Math.min(ans, 1 + Recursion(i + 1, j, word1, word2));
        ans = Math.min(ans, 1 + Recursion(i + 1, j + 1, word1, word2));
        return ans;
    }

    int Memoization(int i, int j, String word1, String word2, int dp[][]) {
        if (j == word2.length())
            return word1.length() - i;
        if (i == word1.length())
            return word2.length() - j;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j))
            return Memoization(i + 1, j + 1, word1, word2, dp);
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, 1 + Memoization(i, j + 1, word1, word2, dp));
        ans = Math.min(ans, 1 + Memoization(i + 1, j, word1, word2, dp));
        ans = Math.min(ans, 1 + Memoization(i + 1, j + 1, word1, word2, dp));
        return dp[i][j] = ans;
    }

    public int Tabulation(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][n] = m - i;
        for (int j = 0; j <= n; j++)
            dp[m][j] = n - j;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1];
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j + 1]);
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i + 1][j]);
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i + 1][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public int Space_Optimized(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] curr = new int[n + 1];
        for (int j = 0; j <= n; j++)
            curr[j] = n - j;
        for (int i = m - 1; i >= 0; i--) {
            int[] next = new int[n + 1];
            next[n] = m - i;
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j))
                    next[j] = curr[j + 1];
                else {
                    next[j] = 1 + Math.min(curr[j + 1], Math.min(curr[j], next[j + 1]));
                }
            }
            curr = next;
        }
        return curr[0];
    }
}
