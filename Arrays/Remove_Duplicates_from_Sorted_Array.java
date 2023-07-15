import java.util.*;

class Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        int ans = Solution(a);
        for (int i = 0; i < ans; i++)
            System.out.print(a[i] + " ");
        in.close();
    }

    // Time Complexity : O(n)
    static int Solution(int[] nums) {
        int ind = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                nums[ind++] = nums[i];
        }
        return ind;
    }
}