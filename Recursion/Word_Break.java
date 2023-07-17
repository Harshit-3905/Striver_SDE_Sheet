import java.util.*;

class Word_Break {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int x = in.nextInt();
        HashSet<String> d = new HashSet();
        for (int i = 0; i < x; i++) {
            String t = in.next();
            d.add(t);
        }
        int n = s.length();
        ArrayList<String> ans = new ArrayList<>();
        Solution(s, n, 0, d, ans, "");
        for (String f : ans) {
            System.out.println(f);
        }
        in.close();
    }

    static void Solution(String s, int n, int i, HashSet<String> d, ArrayList<String> ans, String x) {
        if (i == n) {
            ans.add(x);
            return;
        }
        String t = "";
        for (int j = i; j < n; j++) {
            t += s.charAt(j);
            if (d.contains(t))
                Solution(s, n, j + 1, d, ans, x + t + " ");
        }
    }
}