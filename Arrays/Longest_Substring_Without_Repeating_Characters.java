import java.util.*;

class Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        // int ans = Brute_Force(n, s);
        // int ans = Better(n, s);
        // int ans = More_Better(n, s);
        int ans = Optimised(n, s);
        System.out.println(ans);
        in.close();
    }

    static boolean checkRepetition(String s) {
        int a[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            a[x]++;
            if (a[x] > 1)
                return true;
        }
        return false;
    }

    // Time Complexity : O(n^4)
    static int Brute_Force(int n, String s) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                StringBuilder c = new StringBuilder();
                for (int k = i; k <= j; k++) {
                    c.append(s.charAt(k));
                    if (!checkRepetition(c.toString()))
                        ans = Math.max(ans, c.length());
                }
            }
        }
        return ans;
    }

    // Time Complexity : O(n^3)
    static int Better(int n, String s) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder c = new StringBuilder();
            for (int j = i; j < n; j++) {
                c.append(s.charAt(j));
                if (!checkRepetition(c.toString()))
                    ans = Math.max(ans, c.length());
            }
        }
        return ans;
    }

    // Time Complexity : O(n^2)
    static int More_Better(int n, String s) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a[] = new int[26];
            for (int j = i; j < n; j++) {
                int x = s.charAt(j) - 'a';
                a[x]++;
                if (a[x] > 1)
                    break;
                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    static int Optimised(int n, String s) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (j < n) {
            char ch = s.charAt(j);
            if (set.contains(ch)) {
                while (s.charAt(i) != ch) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
            }
            set.add(ch);
            ans = Math.max(ans, set.size());
            j++;
        }
        return ans;
    }
}