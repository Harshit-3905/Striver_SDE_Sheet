import java.util.*;

class Nth_Root_of_Number {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int ans = BruteForce(n, m);
        // int ans = Optimised(n, m);
        System.out.println(ans);
        in.close();
    }

    // Time Complexity : O(nm)
    static int BruteForce(int n, int m) {
        for (int i = 1; i <= m; i++) {
            int x = 1;
            for (int j = 1; j <= n; j++) {
                x *= i;
            }
            if (x == m)
                return i;
        }
        return -1;
    }

    // Time Complexity : O(nlog m)
    static int Optimised(int n, int m) {
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = 1;
            for (int i = 1; i <= n; i++) {
                x *= mid;
            }
            if (x > m)
                high = mid - 1;
            else if (x < m)
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}