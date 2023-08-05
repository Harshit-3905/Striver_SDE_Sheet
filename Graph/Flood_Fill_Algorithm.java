class Flood_Fill_Algorithm {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int old = image[sr][sc];
        boolean[][] vis = new boolean[image.length][image[0].length];
        vis[sr][sc] = true;
        image[sr][sc] = color;
        dfs(image, vis, sr, sc, color, old);
        return image;
    }

    void dfs(int image[][], boolean[][] vis, int i, int j, int n, int old) {
        int r[] = { 1, -1, 0, 0 };
        int c[] = { 0, 0, 1, -1 };
        for (int k = 0; k < 4; k++) {
            if (isSafe(i + r[k], j + c[k], image, old) && vis[i + r[k]][j + c[k]] == false) {
                image[i + r[k]][j + c[k]] = n;
                vis[i][j] = true;
                dfs(image, vis, i + r[k], j + c[k], n, old);
            }
        }
    }

    boolean isSafe(int i, int j, int[][] image, int old) {
        int r = image.length;
        int c = image[0].length;
        return i < r && j < c && i >= 0 && j >= 0 && image[i][j] == old;
    }
}