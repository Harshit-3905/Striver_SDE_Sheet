import java.util.*;

class Minimum_Insertions_to_make_Palindrome {
    static int countMin(String str) {
        int n = str.length();
        // int ans = Recursion(str, 0, n - 1);
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        int ans = Memoization(str, 0, n - 1, dp);
        return ans;
    }

    static int Recursion(String str, int low, int high) {
        if (low >= high)
            return 0;
        if (str.charAt(low) == str.charAt(high))
            return Recursion(str, low + 1, high - 1);
        else
            return 1 + Math.min(Recursion(str, low + 1, high), Recursion(str, low, high - 1));
    }

    static int Memoization(String str, int low, int high, int dp[][]) {
        if (low >= high)
            return 0;
        if (dp[low][high] != -1)
            return dp[low][high];
        if (str.charAt(low) == str.charAt(high))
            return dp[low][high] = Memoization(str, low + 1, high - 1, dp);
        else
            return dp[low][high] = 1
                    + Math.min(Memoization(str, low + 1, high, dp), Memoization(str, low, high - 1, dp));
    }
}