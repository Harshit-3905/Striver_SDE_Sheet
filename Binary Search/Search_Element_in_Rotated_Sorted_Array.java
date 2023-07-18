import java.util.*;

class Search_Element_in_Rotated_Sorted_Array {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        // int ans = Brute_Force(a, n, target);
        int ans = Optimised(a, n, target);
        System.out.println(ans);
        in.close();
    }

    // Time Complexity :O(n)
    static int Brute_Force(int a[], int n, int target) {
        for (int i = 0; i < n; i++) {
            if (a[i] == target)
                return i;
        }
        return -1;
    }

    // Time Complexity :O(logn)
    static int Optimised(int nums[], int n, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}