import java.util.*;

class Subset {
    static HashSet<ArrayList<Integer>> ans;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        ans = new HashSet<>();
        // Solution1(a, n);
        ArrayList<Integer> list = new ArrayList<>();
        Solution2(a, n, 0, list);
        for (ArrayList<Integer> x : ans) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
        in.close();
    }

    // Time Complexity : O(2^N)
    static void Solution1(int a[], int n) {
        for (int i = 0; i < (1 << n); i++) {
            int x = i;
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((x & 1) == 1) {
                    list.add(a[j]);
                }
                x /= 2;
            }
            ans.add(list);
        }
    }

    // Time Complexity : O(2^N)
    // Time Complexity : O(2^N)
    static void Solution2(int a[], int n, int i, ArrayList<Integer> list) {
        if (i == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        Solution2(a, n, i + 1, list);
        list.add(a[i]);
        Solution2(a, n, i + 1, list);
        list.remove(list.size() - 1);
    }
}