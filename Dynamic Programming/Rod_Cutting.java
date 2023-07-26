import java.util.*;

class Rod_Cutting {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int price[] = new int[n];
        for (int i = 0; i < n; i++)
            price[i] = in.nextInt();
        // int ans = Recursion(n - 1, n, price);
        int dp[][] = new int[n][n + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        // int ans = Memoization(n - 1, n, price, dp);
        // int ans = Tabulation(n - 1, n, price);
        // int ans = Space_Optimised(n - 1, n, price);
        int ans = Space_Optimised1(n - 1, n, price);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int n, int amount, int[] price) {
        if (n == 0) {
            if (amount > 0)
                return price[0] * amount;
            return 0;
        }
        int nottake = Recursion(n - 1, amount, price);
        int take = Integer.MIN_VALUE;
        if (amount >= n + 1)
            take = price[n] + Recursion(n, amount - n - 1, price);
        return Math.max(take, nottake);
    }

    static int Memoization(int n, int amount, int[] price, int dp[][]) {
        if (n == 0) {
            if (amount > 0)
                return price[0] * amount;
            return 0;
        }
        if (dp[n][amount] != -1)
            return dp[n][amount];
        int nottake = Memoization(n - 1, amount, price, dp);
        int take = Integer.MIN_VALUE;
        if (amount >= n + 1)
            take = price[n] + Memoization(n, amount - n - 1, price, dp);
        dp[n][amount] = Math.max(take, nottake);
        return dp[n][amount];
    }

    static int Tabulation(int n, int amount, int[] price) {
        int dp[][] = new int[n][n + 1];
        for (int j = 0; j <= n; j++) {
            if (j >= 1)
                dp[0][j] = price[0] * j;
            else
                dp[0][j] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                int nottake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                if (j >= i + 1)
                    take = price[i] + dp[i][j - i - 1];
                dp[i][j] = Math.max(take, nottake);
            }
        }
        return dp[n - 1][n];
    }

    static int Space_Optimised(int n, int amount, int[] price) {
        int prev[] = new int[n + 1];
        int curr[] = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            if (j >= 1)
                prev[j] = price[0] * j;
            else
                prev[j] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                int nottake = prev[j];
                int take = Integer.MIN_VALUE;
                if (j >= i + 1)
                    take = price[i] + curr[j - i - 1];
                curr[j] = Math.max(take, nottake);
            }
        }
        return prev[n];
    }

    static int Space_Optimised1(int n, int amount, int[] price) {
        int curr[] = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            if (j >= 1)
                curr[j] = price[0] * j;
            else
                curr[j] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                int nottake = curr[j];
                int take = Integer.MIN_VALUE;
                if (j >= i + 1)
                    take = price[i] + curr[j - i - 1];
                curr[j] = Math.max(take, nottake);
            }
        }
        return curr[n];
    }
}