import java.util.*;

class Four_Sum {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        List<List<Integer>> ans = Brute_Force(a, target);
        for (List<Integer> y : ans) {
            for (int x : y)
                System.out.print(x + " ");
            System.out.println();
        }
        in.close();
    }

    // Time Complexity : O(n^4)
    static List<List<Integer>> Brute_Force(int[] nums, int target) {
        int n = nums.length;
        HashSet<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            Collections.sort(list);
                            ans.add(list);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }

    // Time Complexity : O(n^3)
    static List<List<Integer>> Optimised(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n) {
                int k = j + 1, l = n - 1;
                while (k < l) {
                    long x = 0l + nums[i] + nums[j] + nums[k] + nums[l];
                    if (x == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        ans.add(list);
                        int y = nums[k];
                        while (k < n && nums[k] == y)
                            k++;
                        y = nums[l];
                        while (l > k && nums[l] == y)
                            l--;
                    } else if (x > target)
                        l--;
                    else
                        k++;
                }
                int y = nums[j];
                while (j < n && nums[j] == y)
                    j++;
            }
            int y = nums[i];
            while (i < n && nums[i] == y)
                i++;
        }
        return ans;
    }
}