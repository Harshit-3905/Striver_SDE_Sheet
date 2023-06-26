import java.util.*;

class Minimum_Coins {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int amount = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        int ans = solve(n, a, amount);
        System.out.println(ans);
        in.close();
    }

    // Greedy Method
    // Not Always Accurate
    // Time Complexity :O(n)
    static int solve(int n, int a[], int amount) {
        Arrays.sort(a);
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (amount >= a[i]) {
                amount -= a[i];
                ans++;
            }
        }
        return ans;
    }
}