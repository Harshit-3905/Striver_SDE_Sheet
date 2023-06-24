import java.util.Scanner;

class Best_Time_To_Buy_and_Sell_Stock {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        // int ans = Brute_Force(n, a);
        // int ans = Better(n, a);
        int ans = Optimised(n, a);
        System.out.println(ans);
        in.close();
    }

    // Time Complexity : O(n^2)
    static int Brute_Force(int n, int a[]) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, a[j] - a[i]);
            }
        }
        return ans;
    }

    // Time Complexity : O(n)
    static int Better(int n, int a[]) {
        int ans = 0;
        int max = a[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            ans = Math.max(ans, max - a[i]);
            if (a[i] > max)
                max = a[i];
        }
        return ans;
    }

    // Time Complexity : O(n)
    static int Optimised(int n, int a[]) {
        int low = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < low)
                low = a[i];
            ans = Math.max(ans, a[i] - low);
        }
        return ans;
    }
}