import java.util.*;

public class escape {

    static boolean[][] valid;
    static char[][] board;
    static int row;
    static int col;

    public static void main(String[] args) {
        Scanner scnr = new Scanner (System.in);

        int c = scnr.nextInt();
        for (int k = 0; k < c; k ++) {

            row = scnr.nextInt();
            col = scnr.nextInt();

            board = new char[row][col];
            for (int i = 0; i < row; i++) {
                String line = scnr.next();
                for (int j = 0; j < col; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            //System.out.println(Arrays.deepToString(board));
            valid = new boolean[row][col];
            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == '.')
                        valid[i][j] = true;
                    if (board[i][j] == 'P')
                        pawn(i, j);
                    if (board[i][j] == 'N')
                        knight(i, j);
                    if (board[i][j] == 'B')
                        bishop(i, j);
                    if (board[i][j] == 'R')
                        rook(i, j);
                    if (board[i][j] == 'Q')
                        queen(i, j);
                    if (board[i][j] == 'K')
                        valid[i][j] = true;
                }

            for (int i = 0; i < board.length; i++){
                System.out.println(Arrays.toString(board[i]));
            }
            for (int i = 0; i < valid.length; i++){
                System.out.println(Arrays.toString(valid[i]));
            }

        }

    }

    static boolean onBoard (int i, int j) {
        return (i >= 0 && i < row) && (j >= 0 && j < col);
    }

    static void pawn (int i, int j) {
        int[] DX = {-1, 1};
        int[] DY = {-1, -1};

        for (int k = 0; k < DX.length; k++)
            if (onBoard(i+DX[k], j+DY[k]))
                valid[i+DX[k]][j+DY[k]] = false;
    }

    static void knight (int i, int j) {
        int[] DX = {-1, 1, -2, 2, -2, 2, -1, 1};
        int[] DY = {-2, -2, -1, -1, 1, 1, 2, 2};

        for (int k = 0; k < DX.length; k++)
            if (onBoard(i+DX[k], j+DY[k]))
                valid[i+DX[k]][j+DY[k]] = false;
    }

    static void bishop (int i, int j) {
        int[] DX = {-1, 1, -1, 1};
        int[] DY = {1, 1, -1, -1};

        int ti = 0;
        int tj = 0;
        for (int k = 0; k < DX.length; k++) {
            ti = i;
            tj = j;
            while (onBoard(ti + DX[k], tj + DY[k])) {
                ti = ti + DX[k];
                tj = tj + DY[k];
                if (board[ti][tj] == '.')
                    valid[ti][tj] = false;
                else
                    break;
            }
        }

    }

    static void rook (int i, int j) {
        int[] DX = {1, -1, 0, 0};
        int[] DY = {0, 0, 1, -1};

        int ti = 0;
        int tj = 0;
        for (int k = 0; k < DX.length; k++) {
            ti = i;
            tj = j;
            while (onBoard(ti + DX[k], tj + DY[k])) {
                ti = ti + DX[k];
                tj = tj + DY[k];
                if (board[ti][tj] == '.')
                    valid[ti][tj] = false;
                else
                    break;
            }
        }

    }

    static void queen (int i, int j) {
        rook(i, j);
        bishop(i, j);
    }

}
