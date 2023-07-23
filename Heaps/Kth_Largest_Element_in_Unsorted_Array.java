import java.util.*;

class Kth_Largest_Element_in_Unsorted_Array {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        // int ans1 = Solution1(nums, k);
        int ans2 = Solution2(nums, k);
        System.out.println(ans2);
        in.close();
    }

    static int Solution1(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - k];
    }

    static int Solution2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++)
            pq.add(nums[i]);
        for (int i = 1; i < k; i++)
            pq.poll();
        return pq.poll();
    }
}