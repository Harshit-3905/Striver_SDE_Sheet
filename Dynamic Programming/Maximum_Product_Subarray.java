import java.util.*;

class Maximum_Product_Subarray {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        // int ans = BruteForce(nums);
        int ans = Optimal(nums);
        System.out.println(ans);
        in.close();
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    static int BruteForce(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                ans = Math.max(ans, product);
            }
        }
        return ans;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    static int Optimal(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int pre = 1, suf = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (pre == 0)
                pre = 1;
            if (suf == 0)
                suf = 1;
            pre *= nums[i];
            suf *= nums[n - i - 1];
            ans = Math.max(ans, pre);
            ans = Math.max(ans, suf);
        }
        return ans;
    }
}