// Used to Search Pattern in a Given Text 

class Rabin_Karp {
    static int mod1 = 1000000007;
    static int mod2 = 1000000009;

    static long hash(String s, long mod_new, long p) {
        long h = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            h = (h * p + (c - 'a' + 1)) % mod_new;
        }

        return h;
    }

    static long rabinKarp(String s, String pat, long mod1, long mod2) {
        int n = s.length();
        int m = pat.length();

        long cnt = 0;

        long hash_t2 = hash(pat, mod1, 31);
        long hash_t2_new = hash(pat, mod2, 37);

        long hash_t1 = hash(s.substring(0, m), mod1, 31);
        long hash_t1_new = hash(s.substring(0, m), mod2, 37);

        if (hash_t1 == hash_t2 && hash_t1_new == hash_t2_new)
            cnt++;

        long p1 = 1, p2 = 1;

        for (int i = 0; i < m - 1; i++) {
            p1 = (p1 * 31) % mod1;
            p2 = (p2 * 37) % mod2;
        }

        for (int l = 1, r = m; r < n; l++, r++) {
            long del1 = ((s.charAt(l - 1) - 'a' + 1) * p1) % mod1;
            long del2 = ((s.charAt(l - 1) - 'a' + 1) * p2) % mod2;
            long add = (s.charAt(r) - 'a' + 1);

            hash_t1 = ((hash_t1 - del1 + mod1) * 31 + add) % mod1;
            hash_t1_new = ((hash_t1_new - del2 + mod2) * 37 + add) % mod2;
            if (hash_t1 == hash_t2 && hash_t1_new == hash_t2_new)
                cnt++;
        }

        return cnt;
    }

}