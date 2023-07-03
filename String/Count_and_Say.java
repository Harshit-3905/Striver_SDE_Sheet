import java.util.*;

class Count_and_Say {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String ans = Solution(n, new StringBuilder("1")).toString();
        System.out.println(ans);
        in.close();
    }

    static StringBuilder Solution(int n, StringBuilder s) {
        if (n == 1)
            return s;
        StringBuilder ans = new StringBuilder();
        char ch = s.charAt(0);
        int c = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ch)
                c++;
            else {
                ans.append(c);
                ans.append(ch);
                ch = s.charAt(i);
                c = 1;
            }
        }
        ans.append(c);
        ans.append(ch);
        return Solution(n - 1, ans);
    }
}