import java.util.*;

class Rotten_Oranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int count = 0;
        Queue<Oranges> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    count++;
                else if (grid[i][j] == 2)
                    q.add(new Oranges(i, j, 0));
            }
        }
        int ans = 0;
        int r[] = { 1, -1, 0, 0 };
        int c[] = { 0, 0, 1, -1 };
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                Oranges p = q.poll();
                int x = p.x;
                int y = p.y;
                for (int k = 0; k < 4; k++) {
                    if (isSafe(x + r[k], y + c[k], n, m, grid, vis)) {
                        q.add(new Oranges(x + r[k], y + c[k], p.t + 1));
                        vis[x + r[k]][y + c[k]] = true;
                        ans = Math.max(ans, p.t + 1);
                        count--;
                    }
                }
            }
        }
        if (count != 0)
            return -1;
        return ans;
    }

    boolean isSafe(int i, int j, int n, int m, int grid[][], boolean vis[][]) {
        return i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == 1 && vis[i][j] == false;
    }
}

class Oranges {
    int x;
    int y;
    int t;

    Oranges(int a, int b, int c) {
        x = a;
        y = b;
        t = c;
    }
}