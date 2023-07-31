import java.util.*;

class Subarray_with_K_Sum {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        int ans = Solution(nums, n);
        System.out.println(ans);
        in.close();
    }

    static int Solution(int arr[], int n) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum))
                ans = Math.max(ans, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return ans;
    }
}