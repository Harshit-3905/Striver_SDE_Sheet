import java.util.*;

class Word_Break {

    static void Recursion(String s, int n, int i, HashSet<String> d, ArrayList<String> ans, String x) {
        if (i == n) {
            ans.add(x);
            return;
        }
        String t = "";
        for (int j = i; j < n; j++) {
            t += s.charAt(j);
            if (d.contains(t))
                Recursion(s, n, j + 1, d, ans, x + t + " ");
        }
    }

    int Memoization(String s, int i, int x, HashSet<String> set, int dp[][]) {
        if (i == s.length()) {
            if (x == i || set.contains(s.substring(x, i)))
                return 1;
            else
                return 0;
        }
        if (dp[i][x] != -1)
            return dp[i][x];
        // System.out.println(s.substring(x,i+1));
        if (set.contains(s.substring(x, i + 1)))
            return dp[i][x] = (Memoization(s, i + 1, x, set, dp) | Memoization(s, i + 1, i + 1, set, dp));
        else
            return dp[i][x] = Memoization(s, i + 1, x, set, dp);
    }
}