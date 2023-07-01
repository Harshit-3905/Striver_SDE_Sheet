import java.util.*;

class Subset_Sum {
    static ArrayList<Integer> ans;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        ans = new ArrayList<>();
        // Solution1(a, n);
        Solution2(a, n, 0, 0);
        Collections.sort(ans);
        for (int x : ans) {
            System.out.print(x + " ");
        }
        in.close();
    }

    // Time Complexity : O(2^N)
    static void Solution1(int a[], int n) {
        for (int i = 0; i < (1 << n); i++) {
            int x = i;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((x & 1) == 1)
                    sum += a[j];
                x /= 2;
            }
            ans.add(sum);
        }
    }

    // Time Complexity : O(2^N)
    // Time Complexity : O(2^N)
    static void Solution2(int a[], int n, int i, int sum) {
        if (i == n) {
            ans.add(sum);
            return;
        }
        Solution2(a, n, i + 1, sum + a[i]);
        Solution2(a, n, i + 1, sum);
    }
}