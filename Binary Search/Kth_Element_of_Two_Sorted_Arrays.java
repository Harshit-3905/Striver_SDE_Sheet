import java.util.*;

class Kth_Element_of_Two_Sorted_Arrays {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[m];
        int b[] = new int[n];
        for (int i = 0; i < m; i++)
            a[i] = in.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = in.nextInt();
        int ans = BruteForce(a, b, m, n, k);
        System.out.println(ans);
        in.close();
    }

    // Time Complexity : O(m+n)
    static int BruteForce(int a[], int b[], int m, int n, int k) {
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (a[i] < b[j]) {
                k--;
                if (k == 0)
                    return a[i];
                i++;
            } else {
                k--;
                if (k == 0)
                    return b[j];
                j++;
            }
        }
        while (i < m) {
            k--;
            if (k == 0)
                return a[i];
            i++;
        }
        while (j < n) {
            k--;
            if (k == 0)
                return b[j];
            j++;
        }
        return -1;
    }
}