import java.util.*;

class Longest_Common_Prefix {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = in.next();
        }
        String ans = longestCommonPrefix1(strs);
        // String ans = longestCommonPrefix2(strs);
        System.out.println(ans);
        in.close();
    }

    // Time Complexity : O(n^2)
    public static String longestCommonPrefix1(String[] strs) {
        String ans = "";
        String prefix = "";
        String first = strs[0];
        int len = first.length();
        for (int i = 0; i < len; i++) {
            prefix += first.charAt(i);
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                ans = prefix;
            else
                break;
        }
        return ans;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        Trie root = new Trie();
        root.insert(root, strs[0]);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < strs.length; i++) {
            ans = Math.min(root.insert(root, strs[i]), ans);
        }
        if (ans == Integer.MAX_VALUE)
            return "";
        else
            return strs[0].substring(0, ans);
    }

    class Trie {
        Trie children[];
        boolean eow;

        Trie() {
            children = new Trie[26];
            Arrays.fill(children, null);
            eow = false;
        }

        int insert(Trie root, String s) {
            int ans = 0;
            Trie curr = root;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                int index = s.charAt(i) - 'a';
                if (curr.children[index] != null)
                    ans++;
                else
                    curr.children[index] = new Trie();
                curr = curr.children[index];
            }
            curr.eow = true;
            return ans;
        }
    }

}