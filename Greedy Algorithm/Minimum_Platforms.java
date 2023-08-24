import java.util.*;

class Minimum_Platforms {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int dep[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        for (int i = 0; i < n; i++)
            dep[i] = in.nextInt();
        System.out.println(Solution(arr, dep, n));
        in.close();
    }

    // Time Complexity : O(nlogn)
    static int Solution(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            } else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }
            if (plat_needed > result)
                result = plat_needed;
        }
        return result;
    }
}