import java.util.*;

class Combination_Sum {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        HashSet<ArrayList<Integer>> ans = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        Solution(a, n, 0, list, ans, sum);
        for (ArrayList<Integer> y : ans) {
            for (int x : y) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        in.close();
    }

    static void Solution(int a[], int n, int c, ArrayList<Integer> list, HashSet<ArrayList<Integer>> ans,
            int sum) {
        if (c == sum) {
            ArrayList<Integer> l = new ArrayList<>(list);
            Collections.sort(l);
            ans.add(l);
            return;
        }
        if (c > sum)
            return;
        for (int j = 0; j < n; j++) {
            list.add(a[j]);
            Solution(a, n, c + a[j], list, ans, sum);
            list.remove(list.size() - 1);
        }
    }
}