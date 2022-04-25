import java.util.*;

public class jumpman {
    public static int[][] blockHeights;
    public static int[][] blockGold;
    public static int jumpRange;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n < numCases; n++){
            int numRows = scan.nextInt();
            int numCols = scan.nextInt();
            jumpRange = scan.nextInt();
            int startX = scan.nextInt();
            int startY = scan.nextInt();
            blockHeights = new int[numRows][numCols];
            blockGold = new int[numRows][numCols];

            for (int i = 0; i < numRows; i++){
                for (int j = 0; j < numCols; j++){
                    blockHeights[i][j] = scan.nextInt();
                }
            }
            for (int i = 0; i < numRows; i++){
                for (int j = 0; j < numCols; j++){
                    blockGold[i][j] = scan.nextInt();
                }
            }

            boolean[][] blockVisited = new boolean[numRows][numCols];
            blockVisited = recursive(blockVisited, startX - 1, startY - 1);
        }
    }

    public static boolean[][] recursive(boolean[][] blockVisited, int nextX, int nextY){
        blockVisited[nextX][nextY] = true;


        // going up
        if (nextY - 1 > 0 && !blockVisited[nextX][nextY - 1]){
            if (blockHeights[nextX][nextY - 1] - blockHeights[nextX][nextY] > jumpRange)
            blockVisited = recursive(blockVisited, nextX, nextY - 1);
        }

        // going left
        if (nextX - 1 > 0 && !blockVisited[nextX - 1][nextY] ){
            blockVisited = recursive(blockVisited, nextX - 1, nextY);
        }

        // going right
        if (nextX + 1 < blockVisited.length && !blockVisited[nextX + 1][nextY] ){
            blockVisited = recursive(blockVisited, nextX + 1, nextY);
        }

        // going down
        if (nextY + 1 < blockVisited[0].length && !blockVisited[nextX][nextY + 1]){
            blockVisited = recursive(blockVisited, nextX + 1, nextY);
        }


        return blockVisited;
    }

}

