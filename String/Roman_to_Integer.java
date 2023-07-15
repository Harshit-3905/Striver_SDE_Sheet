import java.util.*;

class Roman_to_Integer {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int ans = Solution(s);
        System.out.println(ans);
        in.close();
    }

    static int Solution(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'M')
                ans += 1000;
            else if (ch == 'D')
                ans += 500;
            else if (ch == 'C') {
                if (i != n - 1 && s.charAt(i + 1) == 'D') {
                    ans += 400;
                    i++;
                } else if (i != n - 1 && s.charAt(i + 1) == 'M') {
                    ans += 900;
                    i++;
                } else
                    ans += 100;
            } else if (ch == 'L')
                ans += 50;
            else if (ch == 'X') {
                if (i != n - 1 && s.charAt(i + 1) == 'L') {
                    ans += 40;
                    i++;
                } else if (i != n - 1 && s.charAt(i + 1) == 'C') {
                    ans += 90;
                    i++;
                } else
                    ans += 10;
            } else if (ch == 'V')
                ans += 5;
            else if (ch == 'I') {
                if (i != n - 1 && s.charAt(i + 1) == 'V') {
                    ans += 4;
                    i++;
                } else if (i != n - 1 && s.charAt(i + 1) == 'X') {
                    ans += 9;
                    i++;
                } else
                    ans++;
            }
        }
        return ans;
    }
}