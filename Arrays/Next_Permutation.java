import java.util.*;

class Next_Permutaion {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        Solution(nums);
        for (int x : nums)
            System.out.print(x + " ");
        in.close();
    }

    static void Solution(int[] nums) {
        int n = nums.length;
        int ind = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            reverse(nums, 0, n - 1);
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > nums[ind]) {
                    int t = nums[i];
                    nums[i] = nums[ind];
                    nums[ind] = t;
                    break;
                }
            }
            reverse(nums, ind + 1, n - 1);
        }
    }

    static void reverse(int nums[], int low, int high) {
        while (low < high) {
            int t = nums[low];
            nums[low] = nums[high];
            nums[high] = t;
            low++;
            high--;
        }
    }
}