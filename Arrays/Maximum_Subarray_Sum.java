import java.util.*;

class Maximum_Subarray_Sum {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = in.nextInt();
        // int ans = Brute_Force(array, n);
        // int ans = Better(array, n);
        int ans = Optimised(array, n);
        System.out.println(ans);
        in.close();
    }

    // Time Complexity : O(n^3)
    public static int Brute_Force(int[] array, int n) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int curr = 0;
                for (int k = i; k <= j; k++) {
                    curr += array[k];
                }
                if (curr > ans)
                    ans = curr;
            }
        }
        return ans;
    }

    // Time Complexity : O(n^2)
    public static int Better(int[] array, int n) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j < n; j++) {
                curr += array[j];
                if (curr > ans)
                    ans = curr;
            }
        }
        return ans;
    }

    // Time Complexity : O(n)
    // Kadane Algorithm
    public static int Optimised(int[] array, int n) {
        int ans = array[0];
        int curr = array[0];
        for (int i = 1; i < n; i++) {
            curr += array[i];
            ans = Math.max(ans, curr);
            if (curr < 0)
                curr = 0;
        }
        return ans;
    }
}
