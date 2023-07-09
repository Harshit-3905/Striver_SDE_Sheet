import java.util.*;

class Merge_Overlapping_Intervals {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<int[]> input = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a[] = new int[2];
            a[0] = in.nextInt();
            a[1] = in.nextInt();
            input.add(a);
        }
        Collections.sort(input, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(input.get(0));
        Solution(n, input, ans);
        for (int x[] : ans) {
            System.out.println(x[0] + " " + x[1]);
        }
        in.close();
    }

    static void Solution(int n, List<int[]> input, List<int[]> ans) {
        for (int i = 1; i < n; i++) {
            int[] b = ans.get(ans.size() - 1);
            int[] a = input.get(i);
            if (a[0] <= b[1]) {
                b[0] = Math.min(b[0], a[0]);
                b[1] = Math.max(b[1], a[1]);
            } else {
                int y[] = new int[2];
                y[0] = a[0];
                y[1] = a[1];
                ans.add(y);
            }
        }
    }
}