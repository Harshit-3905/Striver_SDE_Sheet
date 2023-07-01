import java.util.*;

class N_Queens {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int grid[][] = new int[n][n];
        if (!backtrack(0, grid, n))
            System.out.println(-1);
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }
        in.close();
    }

    static boolean backtrack(int row, int grid[][], int n) {
        if (row == n)
            return true;
        for (int j = 0; j < n; j++) {
            if (isSafe(row, j, grid, n)) {
                grid[row][j] = 1;
                if (backtrack(row + 1, grid, n))
                    return true;
                grid[row][j] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(int i, int j, int grid[][], int n) {
        int x = i, y = j;
        while (y >= 0) {
            if (grid[x][y] == 1)
                return false;
            y--;
        }
        x = i;
        y = j;
        while (x >= 0) {
            if (grid[x][y] == 1)
                return false;
            x--;
        }
        x = i;
        y = j;
        while (y >= 0 && x >= 0) {
            if (grid[x][y] == 1)
                return false;
            x--;
            y--;
        }
        x = i;
        y = j;
        while (y < n && x >= 0) {
            if (grid[x][y] == 1)
                return false;
            x--;
            y++;
        }
        return true;
    }
}