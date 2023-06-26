import java.util.*;

class Valid_Paranthesis {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        if (check(s, n))
            System.out.println("Valid");
        else
            System.out.println("Invalid");
        in.close();
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    static boolean check(String s, int n) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else {
                if (st.isEmpty())
                    return false;
                if (ch == ')' && st.peek() == '(')
                    st.pop();
                else if (ch == ']' && st.peek() == '[')
                    st.pop();
                else if (ch == '}' && st.peek() == '{')
                    st.pop();
                else
                    return false;
            }
        }
        if (st.isEmpty())
            return true;
        else
            return false;
    }
}