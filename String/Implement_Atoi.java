import java.util.*;

class Implement_Atoi {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int ans = Solution(s);
        System.out.println(ans);
        in.close();
    }

    static int Solution(String s) {
        int ans = 0;
        boolean neg = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '-')
                neg = true;
            else if (ch >= '0' && ch <= '9') {
                ans = ans * 10 + (ch - '0');
            }
        }
        if (neg)
            ans *= -1;
        return ans;
    }
}