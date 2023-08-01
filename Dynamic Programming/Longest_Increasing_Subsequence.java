import java.util.*;

class Longest_Increasing_Subsequence {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        // int ans = Recursion(nums, -1, 0);
        // int dp[][] = new int[n + 1][n + 1];
        // for (int i = 0; i <= n; i++)
        // Arrays.fill(dp[i], -1);
        // int ans = Memoization(nums, 0, 1, dp);
        // int ans = Tabulation(nums);
        int ans = Space_Optimised(nums);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int nums[], int last, int index) {
        if (index == nums.length)
            return 0;
        if (last == -1) {
            return Math.max(1 + Recursion(nums, index, index + 1), Recursion(nums, -1, index + 1));
        } else {
            if (nums[index] > nums[last])
                return Math.max(1 + Recursion(nums, index, index + 1), Recursion(nums, last, index + 1));
            else
                return Recursion(nums, last, index + 1);
        }
    }

    static int Memoization(int nums[], int last, int index, int[][] dp) {
        if (index == nums.length + 1)
            return 0;
        if (dp[index][last] != -1)
            return dp[index][last];
        if (last == 0) {
            dp[index][last] = Math.max(1 + Memoization(nums, index, index + 1, dp),
                    Memoization(nums, last, index + 1, dp));
        } else {
            if (nums[index - 1] > nums[last - 1])
                dp[index][last] = Math.max(1 + Memoization(nums, index, index + 1, dp),
                        Memoization(nums, last, index + 1, dp));
            else
                dp[index][last] = Memoization(nums, last, index + 1, dp);
        }
        return dp[index][last];
    }

    static int Tabulation(int nums[]) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int notTake = dp[i + 1][j + 1];
                int take = Integer.MIN_VALUE;
                if (j == -1 || nums[i] > nums[j])
                    take = 1 + dp[i + 1][i + 1];
                dp[i][j + 1] = Math.max(notTake, take);
            }
        }
        return dp[0][0];
    }

    static int Space_Optimised(int nums[]) {
        int n = nums.length;
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int notTake = next[j + 1];
                int take = Integer.MIN_VALUE;
                if (j == -1 || nums[i] > nums[j])
                    take = 1 + next[i + 1];
                curr[j + 1] = Math.max(notTake, take);
            }
            next = curr;
        }
        return next[0];
    }
}