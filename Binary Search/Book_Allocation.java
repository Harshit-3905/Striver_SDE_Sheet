import java.util.*;

class Book_Allocation {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int students = in.nextInt();
        int pages[] = new int[n];
        for (int i = 0; i < n; i++)
            pages[i] = in.nextInt();
        System.out.println(Solution(pages, n, students));
        in.close();
    }

    static int Solution(int pages[], int n, int students) {
        if (students > n)
            return -1;
        int low = 0, high = 0;
        for (int x : pages) {
            low = Math.max(x, low);
            high += x;
        }
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = 1;
            int curr = pages[0];
            for (int i = 1; i < n; i++) {
                curr += pages[i];
                if (curr > mid) {
                    curr = pages[i];
                    x++;
                }
            }
            if (x <= students) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }
}