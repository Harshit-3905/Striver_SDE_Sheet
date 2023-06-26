import java.util.*;

class Max_Consecutive_One {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        int ans = solve(n, a);
        System.out.println(ans);
        in.close();
    }

    // Time Complexity : O(n)
    static int solve(int n, int a[]) {
        int ans = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0)
                curr = 0;
            else
                curr++;
            ans = Math.max(curr, ans);
        }
        return ans;
    }
}