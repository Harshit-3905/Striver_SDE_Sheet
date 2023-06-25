import java.util.Scanner;

class Rat_in_a_Maze {
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
        ArrayList<String> ans = solve(m, n, grid);
        in.close();
    }

    static ArrayList<String> solve(int m, int n, int grid[][]) {

    }
}