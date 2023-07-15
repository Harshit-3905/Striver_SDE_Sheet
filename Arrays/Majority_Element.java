import java.util.*;

class Majority_Element {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        // int ans1 = Solution1(n, a);
        int ans2 = Solution2(n, a);
        System.out.println(ans2);
        in.close();
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    static int Solution1(int n, int a[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            if (x.getValue() >= n / 2)
                return x.getKey();
        }
        return -1;
    }

    // Time Complexity : O(n)
    // Space Complexity : O(1)
    static int Solution2(int n, int a[]) {
        int x = a[0];
        int c = 1;
        for (int i = 1; i < n; i++) {
            if (c == 0)
                x = a[i];
            if (a[i] == x)
                c++;
            else
                c--;
        }
        return x;
    }
}