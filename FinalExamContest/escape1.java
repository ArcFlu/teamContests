import java.util.*;

public class escape1 {
    public static boolean[][] boolBoard;
    public static char[][] initBoard;
    public static int numRows;
    public static int numCols;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n < numCases; n++){
            numRows = scan.nextInt();
            numCols = scan.nextInt();
            boolBoard = new boolean[numRows][numCols];
            initBoard = new char[numRows][numCols];
            int[] kingPosition = new int[2];

            // initial board position
            for (int i = 0; i < numRows; i++){
                String thisLine = scan.next();
                for (int j = 0; j < numCols; j++){
                    char curChar = thisLine.charAt(j);
                    if (curChar != '.'){
                        boolBoard[numRows - i - 1][numCols - j - 1] = true;
                    }

                    // inverted board
                    initBoard[numRows - i - 1][numCols - j - 1] = curChar;
                }
            }

            for (int i = 0; i < numRows; i++)
                System.out.println(Arrays.toString(initBoard[i]));
            // fill taken spots

            for (int i = 0; i < numRows; i++){
                for (int j = 0; j < numCols; j++){
                    if (initBoard[i][j] == 'P')
                        Pawn(i, j);
                    else if (initBoard[i][j] == 'N')
                        Knight(i, j);
                    else if (initBoard[i][j] == 'B')
                        Bishop(i, j);
                    else if (initBoard[i][j] == 'R')
                        Rook(i, j);
                    else if (initBoard[i][j] == 'Q')
                        Queen(i, j);
                }
            }

            for (int i = 0; i < numRows; i++)
                System.out.println(Arrays.toString(boolBoard[i]));

        }
    }

    public static void Pawn(int curRow, int curCol){
        if (curRow - 1 > -1 && curCol - 1 > -1)
            boolBoard[curRow - 1][curCol - 1] = true;

        if (curRow - 1 > -1 && curCol + 1 < numCols){
            boolBoard[curRow - 1][curCol + 1] = true;
        }

        // rows == y
        // cols == x

        // for rows
        // if minus, then > -1
        // if plus, then < numRows

        // for cols
        // if minus, then > -1
        // if plus, then < numCols
    }

    public static void Knight(int curRow, int curCol){

        // top left
        if (curCol - 2 > -1 && curRow + 1 < numRows)
            boolBoard[curRow + 1][curCol - 2] = true;
        if (curCol - 1 > -1 && curRow + 2 < numRows)
            boolBoard[curRow + 2][curCol - 1] = true;

        // top right
        if (curCol + 1 < numCols && curRow + 2 < numRows)
            boolBoard[curRow + 2][curCol + 1] = true;
        if (curCol + 2 < numCols && curRow + 1 < numRows)
            boolBoard[curRow + 1][curCol + 2] = true;

        // bottom right
        if (curCol + 1 < numCols && curRow - 1 > -1)
            boolBoard[curRow + 2][curCol + 1] = true;
    }

    public static void Bishop(int curRow, int curCol){

    }

    public static void Rook(int curRow, int curCol){

    }

    public static void Queen(int curRow, int curCol){
        Bishop(curRow, curCol);
        Rook(curRow, curCol);
    }

}

