import java.util.*;

class String_Hashing {

    static int mod = 1000000007;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        System.out.println(hash(s1));
        System.out.println(hash(s2));
        in.close();
    }

    static int hash(String s) {
        int n = s.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans * 31 + (s.charAt(i) - 'a' + 1)) % mod;
        }
        return (int) ans;
    }

    static Pair get_hash(String s) {
        int n = s.length();
        long h1 = 0;
        long h2 = 0;
        for (int i = 0; i < n; i++) {
            h1 = (h1 * 31 + (s.charAt(i) - 'a' + 1)) % mod;
            h2 = (h2 * 29 + (s.charAt(i) - 'a' + 1)) % mod;
        }
        Pair p = new Pair((int) h1, (int) h2);
        return p;
    }
}

class Pair {
    int first = 0;
    int second = 0;

    Pair(int x, int y) {
        first = x;
        second = y;
    }
}