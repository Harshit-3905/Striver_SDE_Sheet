import java.util.*;

class Print_All_Permutation {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        ArrayList<String> ans = new ArrayList<>();
        boolean freq[] = new boolean[n];
        Solution1(s, freq, ans, "");
        for (String t : ans)
            System.out.println(t);
        List<List<Integer>> ans2 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n2 = in.nextInt();
        for (int i = 0; i < n2; i++)
            list.add(in.nextInt());
        Solution2(ans2, list, 0, n);
        for (List<Integer> y : ans2) {
            for (int x : y)
                System.out.print(x + " ");
            System.out.println();
        }
        in.close();
    }

    static void Solution1(String s, boolean freq[], ArrayList<String> ans, String x) {
        if (x.length() == s.length()) {
            ans.add(x);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[i] == false) {
                freq[i] = true;
                Solution1(s, freq, ans, x + s.charAt(i));
                freq[i] = false;
            }
        }
    }

    static void Solution2(List<List<Integer>> ans, List<Integer> list, int i, int n) {
        if (i == n - 1) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < n; j++) {
            int t = list.get(j);
            list.set(j, list.get(i));
            list.set(i, t);
            Solution2(ans, list, i + 1, n);
            t = list.get(j);
            list.set(j, list.get(i));
            list.set(i, t);
        }
    }
}