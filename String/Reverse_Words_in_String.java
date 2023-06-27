import java.util.*;

class Reverse_Words_in_String {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        // String ans = Solution1(s);
        String ans = Solution2(s);
        System.out.println(ans);
        in.close();
    }

    // Time Compleity : O(n)
    // Space Compleity : O(n)
    static String Solution1(String s) {
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]);
            ans.append(" ");
        }
        return ans.toString().trim();
    }

    // Time Compleity : O(n)
    // Space Compleity : O(n)
    static String Solution2(String s) {
        int n = s.length();
        Stack<String> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            StringBuilder word = new StringBuilder();
            while (i < n && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                i++;
            }
            st.push(word.toString());
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
            ans.append(" ");
        }
        return ans.toString().trim();
    }
}