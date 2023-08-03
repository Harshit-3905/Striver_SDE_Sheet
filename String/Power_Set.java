import java.util.*;

class Power_Set {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        List<String> ans = Solution(s);
        for (String x : ans)
            System.out.print(x + " ");
        in.close();
    }

    static List<String> Solution(String s) {
        char ch[] = s.toCharArray();
        int n = ch.length;
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < (1 << n); i++) {
            StringBuilder d = new StringBuilder();
            int x = i;
            for (int j = 0; j < n; j++) {
                if (x % 2 == 1)
                    d.append(ch[j]);
                x = (x >> 1);
                if (x == 0)
                    break;
            }
            ans.add(d.toString());
        }
        Collections.sort(ans);
        return ans;
    }
}