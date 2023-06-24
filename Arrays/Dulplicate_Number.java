import java.util.*;

class Dulplicate_Number {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        // int ans = Approach_1(a, n);
        int ans = Approach_2(a, n);
        System.out.println(ans);
        in.close();
    }

    // Time Complexity : O(n)
    public static int Approach_1(int a[], int n) {
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans ^= i;
        }
        for (int x : a)
            ans ^= x;
        return ans;
    }

    // Time Complexity : O(n)
    public static int Approach_2(int a[], int n) {
        int sum = 0;
        sum = (n * (n - 1)) / 2;
        int ans = 0;
        for (int x : a)
            ans += x;
        return ans - sum;
    }
}
