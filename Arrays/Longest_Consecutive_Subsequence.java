import java.util.*;

class Longest_Consecutive_Subsequence {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        // int ans = Solution1(nums);
        int ans = Solution2(nums);
        System.out.println(ans);
        in.close();
    }

    // Time Complexity : O(nlogn)
    static int Solution1(int[] nums) {
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

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    static int Solution2(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(nums[i]);
        int ans = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i] - 1))
                continue;
            else {
                int x = nums[i];
                curr = 0;
                while (set.contains(x)) {
                    curr++;
                    x++;
                }
                ans = Math.max(ans, curr);
            }
        }
        return ans;
    }
}