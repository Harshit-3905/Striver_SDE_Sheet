public class Maximum_Sum_LIS {
    public int maxSumIS(int arr[], int n) {
        int dp[] = new int[n];
        int ans = 0;
        dp[0] = arr[0];
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], arr[i] + dp[j]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
