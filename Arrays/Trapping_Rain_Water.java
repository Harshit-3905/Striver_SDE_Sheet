import java.util.*;

class Trapping_Rain_Water {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = in.nextInt();
        }
        System.out.println(Solution1(height));
        System.out.println(Solution2(height));
        in.close();
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    static int Solution1(int height[]) {
        int n = height.length;
        int lmax[] = new int[n];
        int rmax[] = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > max)
                max = height[i];
            lmax[i] = max;
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            rmax[i] = max;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return ans;
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    static int Solution2(int height[]) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int upr = st.pop();
                if (st.isEmpty()) {
                    break;
                }
                int distance = i - st.peek() - 1;
                int h = Math.min(height[i], height[st.peek()]) - height[upr];
                res += distance * h;
            }
            st.push(i);
        }
        return res;
    }
}