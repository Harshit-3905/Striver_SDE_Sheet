import java.util.*;

class Longest_Consecutive_Subsequence {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        int ans = Solution(nums);
        System.out.println(ans);
        in.close();
    }

    static int Solution(int[] nums) {
        if (nums.length == 0)
            return 0;
        int ans = 1;
        Arrays.sort(nums);
        int curr = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                continue;
            if (nums[i] - nums[i - 1] == 1)
                curr++;
            else
                curr = 1;
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}