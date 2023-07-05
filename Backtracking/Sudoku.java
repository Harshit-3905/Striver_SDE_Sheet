import java.util.*;

class Sudoku {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = 9;
        char board[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        if (solve(board, 0, 0)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } else
            System.out.println("NOT POSSIBLE");
        in.close();
    }

    static boolean solve(char[][] board, int i, int j) {
        if (j == 9) {
            if (i == 8)
                return true;
            i++;
            j = 0;
        }
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                if (isSafe(board, i, j, k)) {
                    board[i][j] = (char) (k + '0');
                    if (solve(board, i, j + 1))
                        return true;
                    board[i][j] = '.';
                }
            }
        } else {
            if (solve(board, i, j + 1))
                return true;
        }
        return false;
    }

    static boolean isSafe(char[][] board, int i, int j, int k) {
        for (int x = 0; x < 9; x++) {
            if (board[i][x] == (char) (k + '0'))
                return false;
            if (board[x][j] == (char) (k + '0'))
                return false;
        }
        int x = 0, y = 0;
        if (i >= 0 && i <= 2) {
            x = 0;
            if (j >= 0 && j <= 2)
                y = 0;
            if (j >= 3 && j <= 5)
                y = 3;
            if (j >= 6 && j <= 8)
                y = 6;
        }
        if (i >= 3 && i <= 5) {
            x = 3;
            if (j >= 0 && j <= 2)
                y = 0;
            if (j >= 3 && j <= 5)
                y = 3;
            if (j >= 6 && j <= 8)
                y = 6;
        }
        if (i >= 6 && i <= 8) {
            x = 6;
            if (j >= 0 && j <= 2)
                y = 0;
            if (j >= 3 && j <= 5)
                y = 3;
            if (j >= 6 && j <= 8)
                y = 6;
        }
        for (int p = x; p < x + 3; p++)
            for (int q = y; q < y + 3; q++)
                if (board[p][q] == (char) (k + '0'))
                    return false;
        return true;
    }
}