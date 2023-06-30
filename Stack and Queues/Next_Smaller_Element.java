import java.util.*;

class Next_Smaller_Element {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        BruteForce(n, a);
        // Optimized(n, a);
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        in.close();
    }

    // Time Complexity : O(n^2)
    static void BruteForce(int n, int a[]) {
        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[i]) {
                    x = a[j];
                    break;
                }
            }
            a[i] = x;
        }
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    static void Optimized(int n, int a[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int x = a[i];
            while (!s.isEmpty() && s.peek() >= a[i])
                s.pop();
            if (!s.isEmpty()) {
                a[i] = s.peek();
            } else
                a[i] = -1;
            s.push(x);
        }
    }
}