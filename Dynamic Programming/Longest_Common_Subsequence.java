import java.util.*;

class Longest_Common_Subsequence {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String text1 = in.next();
        int n = text1.length();
        String text2 = in.next();
        int m = text2.length();
        // int ans = Recursion(text1, n - 1, text2, m - 1);
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        // int ans = Memoization(text1, n - 1, text2, m - 1, dp);
        // int ans = Tabulation(text1, text2);
        int ans = Space_Optimised(text1, text2);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(String text1, int n, String text2, int m) {
        if (n < 0 || m < 0)
            return 0;
        if (text1.charAt(n) == text2.charAt(m))
            return 1 + Recursion(text1, n - 1, text2, m - 1);
        return Math.max(Recursion(text1, n, text2, m - 1), Recursion(text1, n - 1, text2, m));
    }

    static int Memoization(String text1, int n, String text2, int m, int dp[][]) {
        if (n < 0 || m < 0)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (text1.charAt(n) == text2.charAt(m))
            dp[n][m] = 1 + Memoization(text1, n - 1, text2, m - 1, dp);
        else
            dp[n][m] = Math.max(Memoization(text1, n, text2, m - 1, dp), Memoization(text1, n - 1, text2, m, dp));
        return dp[n][m];
    }

    static int Tabulation(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    static int Space_Optimised(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int prev[] = new int[m + 1];
        int curr[] = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = Arrays.copyOf(curr, m + 1);
        }
        return prev[m];
    }
}