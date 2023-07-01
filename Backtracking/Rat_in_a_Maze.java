import java.util.*;

class Rat_in_a_Maze {
    static ArrayList<String> ans;

    // Time Complexity: O(2^(n^2))
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int grid[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        ans = new ArrayList<>();
        solve(m, n, grid);
        for (String s : ans)
            System.out.println(s);
        in.close();
    }

    static void solve(int m, int n, int grid[][]) {
        if (grid[0][0] == 0)
            return;
        String s = "";
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        backtracking(0, 0, m, n, grid, vis, s);
    }

    static void backtracking(int i, int j, int m, int n, int[][] grid, boolean vis[][], String s) {
        if (i == m - 1 && j == n - 1) {
            ans.add(s);
            return;
        }
        int r[] = { 1, -1, 0, 0 };
        int c[] = { 0, 0, 1, -1 };
        char ch[] = { 'D', 'U', 'R', 'L' };
        for (int k = 0; k < 4; k++) {
            int x = i + r[k];
            int y = j + c[k];
            if (isSafe(x, y, m, n, grid) && vis[x][y] == false) {
                vis[x][y] = true;
                backtracking(x, y, m, n, grid, vis, s + ch[k]);
                vis[x][y] = false;
            }
        }
    }

    static boolean isSafe(int x, int y, int m, int n, int[][] grid) {
        return x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1;
    }
}