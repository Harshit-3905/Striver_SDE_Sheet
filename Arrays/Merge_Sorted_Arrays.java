import java.util.*;

class Merge_Sorted_Arrays {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int a[] = new int[m];
        int b[] = new int[n];
        for (int i = 0; i < m; i++)
            a[i] = in.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = in.nextInt();
        // mergeSortedArrays1(a, b, m, n);
        mergeSortedArrays2(a, b, m, n);
        for (int i = 0; i < m; i++)
            System.out.print(a[i] + " ");
        in.close();
    }

    // Time Complexity : O(m+n)
    // Space Complexity : O(m+n)
    static void mergeSortedArrays1(int a[], int b[], int m, int n) {
        int c[] = new int[m];
        int i = 0, j = 0;
        m -= n;
        int x = 0;
        while (i < m && j < n) {
            if (a[i] < b[j])
                c[x++] = a[i++];
            else
                c[x++] = b[j++];
        }
        while (i < m)
            c[x++] = a[i++];
        while (j < n)
            c[x++] = b[j++];
        for (i = 0; i < m + n; i++)
            a[i] = c[i];
    }

    // Time Complexity : O(m+n)
    // Space Complexity : O(1)
    static void mergeSortedArrays2(int a[], int b[], int m, int n) {

    }
}
