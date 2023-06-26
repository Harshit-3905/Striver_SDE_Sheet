import java.util.*;

// Time Complexity : O(nlogn) 
class N_Meeting_in_Room {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i][1] = in.nextInt();
        }
        Arrays.sort(a, (x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
        int ans = 1;
        int x = 0;
        for (int i = 1; i < n; i++) {
            if (a[i][0] > a[x][1]) {
                ans++;
                x = i;
            }
        }
        System.out.println(ans);
        in.close();
    }
}