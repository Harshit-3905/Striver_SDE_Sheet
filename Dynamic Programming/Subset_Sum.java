import java.util.*;

class Subset_Sum {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int totalSum = 0;
        for (int x : nums)
            totalSum += x;
        boolean ans;
        if ((totalSum & 1) == 1)
            ans = false;
        else {
            // ans = Recursive(nums, totalSum / 2, n - 1);
            int dp[][] = new int[n + 1][10001];
            for (int i = 0; i < n + 1; i++)
                for (int j = 0; j <= 10000; j++)
                    dp[i][j] = -1;
            for (int i = 0; i <= 10000; i++)
                dp[0][i] = 0;
            for (int i = 0; i <= n; i++)
                dp[i][0] = 1;
            // ans = Memoization(nums, totalSum / 2, n - 1, dp) == 1;
            // ans = Tabulation(nums, totalSum);
            ans = Space_Optimised(nums, totalSum);
        }
        System.out.println(ans);
        in.close();
    }

    // Time Complexity : O(2^n)
    // Space Complexity : O(n)
    static boolean Recursive(int nums[], int sum, int i) {
        if (i == -1) {
            if (sum == 0)
                return true;
            else
                return false;
        }
        if (sum == 0)
            return true;
        boolean notTake = Recursive(nums, sum, i - 1);
        boolean take = false;
        if (nums[i] <= sum)
            take = Recursive(nums, sum - nums[i], i - 1);
        return take | notTake;
    }

    // Time Complexity : O(n*totalSum)
    // Space Complexity : O(n*totalSum) + O(n)
    static int Memoization(int nums[], int sum, int i, int dp[][]) {
        if (dp[i][sum] != -1)
            return dp[i][sum];
        int notTake = Memoization(nums, sum, i - 1, dp);
        int take = 0;
        if (nums[i] <= sum)
            take = Memoization(nums, sum - nums[i], i - 1, dp);
        dp[i][sum] = take | notTake;
        return dp[i][sum];
    }

    // Time Complexity : O(n*totalSum)
    // Space Complexity : O(n*totalSum)
    static boolean Tabulation(int nums[], int totalSum) {
        int n = nums.length;
        boolean dp[][] = new boolean[n + 1][(totalSum / 2) + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum / 2; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (j >= nums[i - 1])
                    take = dp[i - 1][j - nums[i - 1]];
                dp[i][j] = take | notTake;
            }
        }
        return dp[n][totalSum / 2];
    }

    // Time Complexity : O(n*totalSum)
    // Space Complexity : O(totalSum)
    static boolean Space_Optimised(int nums[], int totalSum) {
        int n = nums.length;
        boolean pre[] = new boolean[(totalSum / 2) + 1];
        boolean cur[] = new boolean[(totalSum / 2) + 1];
        pre[0] = true;
        cur[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= totalSum / 2; j++) {
                boolean notTake = pre[j];
                boolean take = false;
                if (j >= nums[i])
                    take = pre[j - nums[i]];
                cur[j] = take | notTake;
            }
            for (int j = 1; j <= totalSum / 2; j++)
                pre[j] = cur[j];
        }
        return cur[totalSum / 2];
    }
}