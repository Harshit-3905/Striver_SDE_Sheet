
import java.util.*;

class Kth_Largest_Element {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        // int ans = Solution1(n, a, k);
        int ans = Solution2(n, a, k);
        System.out.println(ans);
        in.close();
    }

    // Time Complexity : O(nlogn)
    static int Solution1(int n, int a[], int k) {
        Arrays.sort(a);
        return a[n - k];
    }

    // Time Complexity : O(nlogn)
    static int Solution2(int n, int a[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++)
            pq.add(a[i]);
        while (k-- > 1)
            pq.poll();
        return pq.poll();
    }
}