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
        int c[] = new int[m + n];
        int i = 0, j = 0;
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
        int len = n + m;
        int gap = (len / 2) + (len % 2);
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                if (left < n && right >= n) {
                    swapIfGreater(a, b, left, right - n);
                } else if (left >= n) {
                    swapIfGreater(a, b, left - n, right - n);
                } else {
                    swapIfGreater(a, b, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    public static void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
}
