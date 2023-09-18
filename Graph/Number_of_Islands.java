class Number_of_Islands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == false && grid[i][j] == '1') {
                    backtrack(grid, vis, i, j, m, n);
                    ans++;
                }
            }
        }
        return ans;
    }

    void backtrack(char grid[][], boolean vis[][], int i, int j, int m, int n) {
        vis[i][j] = true;
        int r[] = { 1, -1, 0, 0 };
        int c[] = { 0, 0, 1, -1 };
        for (int k = 0; k < 4; k++) {
            int x = i + r[k];
            int y = j + c[k];
            if (isSafe(grid, x, y, m, n) && vis[x][y] == false) {
                backtrack(grid, vis, x, y, m, n);
            }
        }
    }

    boolean isSafe(char grid[][], int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == '1';
    }
}