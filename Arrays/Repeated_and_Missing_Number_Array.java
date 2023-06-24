import java.util.Scanner;

class Repeated_and_Missing_Number_Array {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        // int ans[] = Brute_Force(n, a);
        // int ans[] = Better(n, a);
        int ans[] = Optimised(n, a);
        System.out.println(ans[0] + " " + ans[1]);
        in.close();
    }

    // Time Complexity : O(n^2)
    static int[] Brute_Force(int n, int a[]) {
        int[] ans = new int[2];
        for (int i = 1; i < n; i++) {
            int c = 0;
            for (int x : a) {
                if (x == i)
                    c++;
            }
            if (c == 0)
                ans[1] = i;
            else if (c == 2)
                ans[0] = i;
        }
        return ans;
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    static int[] Better(int n, int a[]) {
        int p[] = new int[n];
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            p[a[i] - 1]++;
            if (p[a[i] - 1] == 2)
                ans[0] = a[i];
        }
        for (int i = 0; i < n; i++)
            if (p[i] == 0) {
                ans[1] = i + 1;
                break;
            }
        return ans;
    }

    // Time Complexity : O(n)
    // Formula-Based
    static int[] Optimised(int n, int a[]) {
        int[] ans = new int[2];
        int x = 0, y = 0;
        int sum = 0, sums = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            sums += a[i] * a[i];
        }
        int sumr = (n * (n + 1)) / 2;
        int sumsr = (n * (n + 1) * ((2 * n) + 1)) / 6;
        x = (((sumsr - sums) / (sumr - sum)) + (sumr - sum)) / 2;
        y = x - sumr + sum;
        ans[1] = x;
        ans[0] = y;
        return ans;
    }
}