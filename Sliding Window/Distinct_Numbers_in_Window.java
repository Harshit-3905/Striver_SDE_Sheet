import java.util.*;

class Distinct_Numbers_in_Window {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int ans[] = new int[n - x + 1];
        Solution(a, n, ans, x);
        for (int i = 0; i < n - x + 1; i++)
            System.out.print(ans[i] + " ");
        in.close();
    }

    static void Solution(int a[], int n, int ans[], int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < x; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        ans[0] = map.size();
        for (int i = x; i < n; i++) {
            if (map.get(a[i - x]) == 1)
                map.remove(a[i - x]);
            else
                map.put(a[i - x], map.get(a[i - x]) - 1);
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            ans[i - x + 1] = map.size();
        }
    }
}