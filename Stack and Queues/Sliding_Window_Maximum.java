import java.util.*;

class Sliding_Window_Maximum {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int k = in.nextInt();
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        int ans[] = Brute_Force(a, n, k);
        // int ans[] = Better(a, n, k);
        // int ans[] = Optimised(a, n, k);
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + " ");
        in.close();
    }

    // Time Complexity : O(n*k)
    static int[] Brute_Force(int a[], int n, int k) {
        int ans[] = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, a[j]);
            }
            ans[i] = max;
        }
        return ans;
    }

    // Time Complexity : O(n*logk)
    // Space Complexity : O(n)
    static int[] Better(int a[], int n, int k) {
        int ans[] = new int[n - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        int j = -1;
        ans[++j] = map.lastKey();
        for (int i = k; i < n; i++) {
            if (map.get(a[i - k]) == 1)
                map.remove(a[i - k]);
            else
                map.put(a[i - k], map.getOrDefault(a[i - k], 0) - 1);
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            ans[++j] = map.lastKey();
        }
        return ans;
    }

    // Time Complexity : O(n*logk)
    // Space Complexity : O(n)
    // Intuition is to maintain a decreasing deque
    static int[] Optimised(int a[], int n, int k) {
        int ans[] = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && a[dq.peekLast()] <= a[i])
                dq.removeLast();
            dq.addLast(i);
        }
        int j = -1;
        ans[++j] = a[dq.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.removeFirst();
            while (!dq.isEmpty() && a[dq.peekLast()] <= a[i])
                dq.removeLast();
            dq.addLast(i);
            ans[++j] = a[dq.peekFirst()];
        }
        return ans;
    }
}