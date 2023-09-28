import java.util.*;

class Matrix_Chain_Multiplication {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] mat = new int[n];
        for (int i = 0; i < n; i++) {
            mat[i] = in.nextInt();
        }
        // int ans = Recursion(mat, 1, n - 1);
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        // int ans = Memoization(mat, 1, n - 1, dp);
        int ans = Tabulation(mat, n);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int arr[], int low, int high) {
        if (low == high)
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = low; i < high; i++) {
            ans = Math.min(ans,
                    (arr[low - 1] * arr[i] * arr[high]) + Recursion(arr, low, i) + Recursion(arr, i + 1, high));
        }
        return ans;
    }

    static int Memoization(int arr[], int low, int high, int dp[][]) {
        if (low == high)
            return 0;
        if (dp[low][high] != -1)
            return dp[low][high];
        int ans = Integer.MAX_VALUE;
        for (int i = low; i < high; i++) {
            ans = Math.min(ans,
                    (arr[low - 1] * arr[i] * arr[high]) + Memoization(arr, low, i, dp)
                            + Memoization(arr, i + 1, high, dp));
        }
        return dp[low][high] = ans;
    }

    // Time Complexity : O(N^3)
    // Space Complexity : O(N^2)
    static int Tabulation(int arr[], int N) {
        int dp[][] = new int[N][N];
        for (int i = 0; i < N; i++)
            dp[i][i] = 0;
        for (int low = N - 1; low >= 1; low--) {
            for (int high = low + 1; high < N; high++) {
                if (low == high)
                    dp[low][high] = 0;
                else {
                    int ans = Integer.MAX_VALUE;
                    for (int i = low; i < high; i++) {
                        ans = Math.min(ans, (arr[low - 1] * arr[i] * arr[high]) + dp[low][i] + dp[i + 1][high]);
                    }
                    dp[low][high] = ans;
                }
            }
        }
        return dp[1][N - 1];
    }
}