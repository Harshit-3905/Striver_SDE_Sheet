import java.util.*;

class Combination_Sum_II {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        Arrays.sort(a);
        HashSet<ArrayList<Integer>> ans = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        Solution(a, n, 0, 0, list, ans, sum);
        for (ArrayList<Integer> y : ans) {
            for (int x : y) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        in.close();
    }

    static void Solution(int a[], int n, int i, int c, ArrayList<Integer> list, HashSet<ArrayList<Integer>> ans,
            int sum) {
        if (i == n) {
            if (c == sum) {
                ArrayList<Integer> l = new ArrayList<>(list);
                ans.add(l);
            }
            return;
        }
        Solution(a, n, i + 1, c, list, ans, sum);
        if (c + a[i] <= sum) {
            list.add(a[i]);
            Solution(a, n, i + 1, c + a[i], list, ans, sum);
            list.remove(list.size() - 1);
        }
    }
}