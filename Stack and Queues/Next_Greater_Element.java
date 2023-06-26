import java.util.Scanner;
import java.util.Stack;

class Next_Greater_Element {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        // int ans[] = Brute_Force(n, a);
        int ans[] = Optimised(n, a);
        for (int x : ans) {
            System.out.print(x + " ");
        }
        in.close();
    }

    // Time Complexity : O(n^2)
    static int[] Brute_Force(int n, int a[]) {
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[i]) {
                    x = a[j];
                    break;
                }
            }
            ans[i] = x;
        }
        return ans;
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    static int[] Optimised(int n, int a[]) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < a[i])
                st.pop();
            if (st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(a[i]);
        }
        return ans;
    }
}