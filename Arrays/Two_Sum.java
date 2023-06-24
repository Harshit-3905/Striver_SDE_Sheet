import java.util.HashMap;
import java.util.*;

class Two_Sum {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        // Brute_Force(a, target, n);
        Optimised(a, target, n);
        in.close();
    }

    // Time Complexity : O(n^2)
    public static void Brute_Force(int[] a, int target, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] == target) {
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public static void Optimised(int[] a, int target, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - a[i])) {
                System.out.println(map.get(target - a[i]) + " " + (i + 1));
                return;
            }
            map.put(a[i], i + 1);
        }
        System.out.println(-1);
    }
}