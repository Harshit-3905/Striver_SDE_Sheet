import java.util.*;

class Largest_Rectangle_in_a_Histogram {

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int Solution1(int[] heights) {
        int n = heights.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i - 1;
            int curr = heights[i];
            while (j >= 0 && heights[j] >= heights[i]) {
                curr += heights[i];
                j--;
            }
            j = i + 1;
            while (j < n && heights[j] >= heights[i]) {
                curr += heights[i];
                j++;
            }
            ans = Math.max(ans, curr);
        }
        return ans;
    }

    // Time Complexity: O(3*n)
    // Space Complexity: O(3*n)
    public int Solution2(int[] heights) {
        int n = heights.length;
        int ans = 0;
        Stack<Integer> s = new Stack<>();
        int prev[] = new int[n];
        int next[] = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = heights[i];
            while (!s.isEmpty() && heights[s.peek()] >= curr)
                s.pop();
            if (s.isEmpty())
                prev[i] = -1;
            else
                prev[i] = s.peek();
            s.push(i);
        }
        s.clear();
        for (int i = n - 1; i >= 0; i--) {
            int curr = heights[i];
            while (!s.isEmpty() && heights[s.peek()] >= curr)
                s.pop();
            if (s.isEmpty())
                next[i] = n;
            else
                next[i] = s.peek();
            s.push(i);
        }
        for (int i = 0; i < n; i++) {
            int area = heights[i] * (next[i] - prev[i] - 1);
            ans = Math.max(area, ans);
        }
        return ans;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int Solution3(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while ((!stack.isEmpty()) && (i == n || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.peek()];
                stack.pop();
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }
        return maxArea;
    }
}