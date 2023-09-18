import java.util.*;

class Median_of_Two_Sorted_Array {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a[] = new int[n];
        int b[] = new int[m];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        for (int i = 0; i < m; i++)
            b[i] = in.nextInt();
        // double ans = Brute_Force(a, b, n, m);
        double ans = Better(a, b, n, m);
        System.out.println(ans);
        in.close();
    }

    // Time Complexity: O(n+m)
    // Space Complexity: O(n+m)
    static double Brute_Force(int a[], int b[], int n, int m) {
        int c[] = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
        }
        while (i < n)
            c[k++] = a[i++];
        while (j < m)
            c[k++] = b[j++];
        if ((n + m) % 2 == 0)
            return (c[(n + m) / 2] + c[(n + m) / 2 - 1]) / 2.0;
        else
            return c[(n + m) / 2];
    }

    // Time Complexity: O(n+m)
    // Space Complexity: O(1)
    static double Better(int a[], int b[], int n, int m) {
        int i = 0, j = 0, k = 0;
        int m1 = -1, m2 = -1;
        int x = (n + m) / 2;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                if (k == x - 1)
                    m1 = a[i];
                if (k == x)
                    m2 = a[i];
                k++;
                i++;
            } else {
                if (k == x - 1)
                    m1 = b[j];
                if (k == x)
                    m2 = b[j];
                k++;
                j++;
            }
        }
        while (i < n) {
            if (k == x - 1)
                m1 = a[i];
            if (k == x)
                m2 = a[i];
            k++;
            i++;
        }
        while (j < m) {
            if (k == x - 1)
                m1 = b[j];
            if (k == x)
                m2 = b[j];
            k++;
            j++;
        }
        if ((n + m) % 2 == 0) {
            return (m1 + m2) / 2.0;
        } else {
            return m2;
        }
    }
}