import java.util.*;

class Sort_An_Array_0_1_2 {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        // Brute_Force(n, a);
        // Better(n, a);
        Optimal(n, a);
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        in.close();
    }

    // Time Complexity : O(nlogn)
    static void Brute_Force(int n, int a[]) {
        Arrays.sort(a);
    }

    // Time Complexity : O(2*n)
    static void Better(int n, int a[]) {
        int c0 = 0, c1 = 0, c2 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0)
                c0++;
            else if (a[i] == 1)
                c1++;
            else
                c2++;
        }
        int x = 0;
        for (int i = 0; i < c0; i++)
            a[x++] = 0;
        for (int i = 0; i < c1; i++)
            a[x++] = 1;
        for (int i = 0; i < c2; i++)
            a[x++] = 2;
    }

    // Time Complexity : O(n)
    static void Optimal(int n, int a[]) {
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (a[mid] == 0) {
                int t = a[mid];
                a[mid] = a[low];
                a[low] = t;
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else {
                int t = a[high];
                a[high] = 2;
                a[mid] = t;
                high--;
            }
        }
    }
}