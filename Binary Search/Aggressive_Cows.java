import java.util.*;

class Aggressive_Cows {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        int ans = Solution(nums, n, k);
        System.out.println(ans);
        in.close();
    }

    static int Solution(int stalls[], int n, int k) {
        int low = 1;
        Arrays.sort(stalls);
        int ans = -1;
        int high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int c = 1;
            int last = stalls[0];
            for (int i = 1; i < n; i++) {
                if (stalls[i] - last >= mid) {
                    c++;
                    last = stalls[i];
                }
                if (c >= k)
                    break;
            }
            if (c >= k) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }
}