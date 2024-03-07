class Palindromic_Partitioning {
    static int Recursion(String str, int low, int high) {
        if (high == str.length()) {
            if (low == high)
                return 0;
            else if (isPalindrome(str, low, high - 1))
                return 1;
            else
                return Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        if (isPalindrome(str, low, high))
            ans = Math.min(1 + Recursion(str, high + 1, high + 1), ans);
        ans = Math.min(ans, Recursion(str, low, high + 1));
        return ans;
    }

    static int Memoization(String str, int low, int high, int dp[][]) {
        if (high == str.length()) {
            if (low == high)
                return 0;
            else if (isPalindrome(str, low, high - 1))
                return 1;
            else
                return Integer.MAX_VALUE;
        }
        if (dp[low][high] != -1)
            return dp[low][high];
        int ans = Integer.MAX_VALUE;
        if (isPalindrome(str, low, high))
            ans = Math.min(1 + Memoization(str, high + 1, high + 1, dp), ans);
        ans = Math.min(ans, Memoization(str, low, high + 1, dp));
        return dp[low][high] = ans;
    }

    static int Tabulation(String str) {
        int n = str.length();
        int dp[][] = new int[n + 1][n + 1];
        for (int low = 0; low < n; low++) {
            if (isPalindrome(str, low, n - 1))
                dp[low][n] = 1;
            else
                dp[low][n] = Integer.MAX_VALUE;
        }
        for (int low = n - 1; low >= 0; low--) {
            for (int high = n - 1; high >= 0; high--) {
                dp[low][high] = Integer.MAX_VALUE;
                if (isPalindrome(str, low, high))
                    dp[low][high] = Math.min(1 + dp[high + 1][high + 1], dp[low][high]);
                dp[low][high] = Math.min(dp[low][high], dp[low][high + 1]);
            }
        }
        return dp[0][0] - 1;
    }

    static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}
