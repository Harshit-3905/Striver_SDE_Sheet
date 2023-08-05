import java.util.*;

class Three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        while (i < n) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int x = nums[i] + nums[j] + nums[k];
                if (x > 0)
                    k--;
                else if (x < 0)
                    j++;
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    int y = nums[j];
                    while (j < n && nums[j] == y)
                        j++;
                    y = nums[k];
                    while (k > i && nums[k] == y)
                        k--;
                }
            }
            int y = nums[i];
            while (i < n && nums[i] == y)
                i++;
        }
        return ans;
    }
}