import java.util.*;

class Pascals_Triangle {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // List<List<Integer>> ans = Brute_Force(n);
        List<List<Integer>> ans = Optimised(n);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
        in.close();
    }

    // Time Complexity : O(n^2)
    public static List<List<Integer>> Brute_Force(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if (!ans.isEmpty()) {
                List<Integer> t = ans.get(ans.size() - 1);
                for (int j = 0; j < t.size() - 1; j++) {
                    list.add(t.get(j) + t.get(j + 1));
                }
                list.add(1);
            }
            ans.add(list);
        }
        return ans;
    }

    // Time Complexity : O(n^2)
    // Formula Based
    public static List<List<Integer>> Optimised(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int x = 1;
            for (int j = 1; j < i; j++) {
                x *= (i - j);
                x /= j;
                list.add(x);
            }
            ans.add(list);
        }
        return ans;
    }
}