import java.util.*;

class Coin_Change {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int amount = in.nextInt();
        int coins[] = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = in.nextInt();
        // int ans = Recursion(n - 1, coins, amount);
        int dp[][] = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++)
                dp[i][j] = -1;
        }
        // int ans = Memoization(n - 1, coins, amount, dp);
        // int ans = Tabulation(coins, amount);
        // int ans = Space_Optimised(coins, amount);
        int ans = Space_Optimised1(coins, amount);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int n, int[] coins, int amount) {
        if (n == 0) {
            if (amount % coins[n] == 0)
                return amount / coins[n];
            return 1000000000;
        }
        int notTake = Recursion(n - 1, coins, amount);
        int take = 1000000000;
        if (amount >= coins[n])
            take = 1 + Recursion(n, coins, amount - coins[n]);
        return Math.min(take, notTake);
    }

    static int Memoization(int n, int[] coins, int amount, int[][] dp) {
        if (n == 0) {
            if (amount % coins[n] == 0)
                return amount / coins[n];
            return 1000000000;
        }
        if (dp[n][amount] != -1)
            return dp[n][amount];
        int notTake = Memoization(n - 1, coins, amount, dp);
        int take = 1000000000;
        if (amount >= coins[n])
            take = 1 + Memoization(n, coins, amount - coins[n], dp);
        dp[n][amount] = Math.min(take, notTake);
        return dp[n][amount];
    }

    static int Tabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = 1000000000;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int nottake = dp[i - 1][j];
                int take = 1000000000;
                if (j >= coins[i])
                    take = 1 + dp[i][j - coins[i]];
                dp[i][j] = Math.min(take, nottake);
            }
        }
        if (dp[n - 1][amount] != 1000000000)
            return dp[n - 1][amount];
        else
            return -1;
    }

    static int Space_Optimised(int coins[], int amount) {
        int n = coins.length;
        int prev[] = new int[amount + 1];
        int curr[] = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                prev[i] = i / coins[0];
            else
                prev[i] = 1000000000;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int nottake = prev[j];
                int take = 1000000000;
                if (j >= coins[i])
                    take = 1 + curr[j - coins[i]];
                curr[j] = Math.min(take, nottake);
            }
            for (int j = 0; j <= amount; j++) {
                prev[j] = curr[j];
            }
        }
        if (prev[amount] != 1000000000)
            return prev[amount];
        else
            return -1;
    }

    static int Space_Optimised1(int coins[], int amount) {
        int n = coins.length;
        int curr[] = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                curr[i] = i / coins[0];
            else
                curr[i] = 1000000000;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int nottake = curr[j];
                int take = 1000000000;
                if (j >= coins[i])
                    take = 1 + curr[j - coins[i]];
                curr[j] = Math.min(take, nottake);
            }
        }
        if (curr[amount] != 1000000000)
            return curr[amount];
        else
            return -1;
    }
}
