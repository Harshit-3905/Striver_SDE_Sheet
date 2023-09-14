import java.util.*;

class Median_of_Row_Wise_Sorted_Matrix {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int arr[][] = new int[m][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = in.nextInt();
        // int ans = Brute_Force(arr, m, n);
        int ans = Optimised(arr, m, n);
        System.out.println(ans);
        in.close();
    }

    // Time Complexity : O(m*n*log(m*n))
    // Space Complexity : O(m*n)
    static int Brute_Force(int arr[][], int m, int n) {
        int temp[] = new int[n * n];
        int k = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                temp[k++] = arr[i][j];
        Arrays.sort(temp);
        return temp[(n * n) / 2];
    }

    // Time Complexity : O(n*log(m)*log(max-min))
    // Space Complexity : O(1)
    static int Optimised(int arr[][], int m, int n) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            min = Math.min(min, arr[i][0]);
            max = Math.max(max, arr[i][n - 1]);
        }
        int desired = (m * n + 1) / 2;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;
            for (int i = 0; i < m; i++)
                place += Arrays.binarySearch(arr[i], mid);
            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }
}