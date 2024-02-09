import java.util.ArrayList;
import java.util.Collections;

public class Printing_Longest_Increasing_Subsequence {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int nums[]) {
        int hash[] = new int[n];
        int dp[] = new int[n];
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && (1 + dp[j]) > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if (dp[i] > dp[maxi])
                maxi = i;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (true) {
            ans.add(nums[maxi]);
            if (hash[maxi] == maxi) {
                break;
            }
            maxi = hash[maxi];
        }
        Collections.reverse(ans);
        return ans;
    }
}
