import java.util.*;

public class sticks2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n < numCases; n++){
            int initSize = scan.nextInt();
            int numCuts = scan.nextInt();
            int[] cutArr = new int[numCuts];

            for (int j = 0; j < numCuts; j++){
                cutArr[j] = scan.nextInt();
            }

            int[][] dpMinCost = new int[numCuts][numCuts];
            int[][] stickLength = new int[numCuts][numCuts];

            for (int i = 0; i < numCuts; i++){
                dpMinCost[i][i] = initSize;
                if (cutArr[i] < Math.floor((double)initSize/2))
                    stickLength[i][i] = initSize - cutArr[i];
                else
                    stickLength[i][i] = cutArr[i];
            }

            for (int i = numCuts - 1; i > -1; i--){
                for (int j = i + 1; j < numCuts; j++){
                    stickLength[i][j] = cutArr[j] - cutArr[i];
                }
            }
            System.out.println(Arrays.deepToString(stickLength));

            for (int i = numCuts - 1; i > -1; i--){
                    int k = 0;
                for (int j = i + 1; j < numCuts; j++){
                    int prevStickLength = stickLength[i][j - 1];
                    int downStickLength = stickLength[i + 1][j];

                    // the cost of choosing the current one and the prev stick is
                        // prevStickCost + prevStickLength
                    int prevStickCost = dpMinCost[i][j - 1] + prevStickLength;
                    int downStickCost = dpMinCost[i + 1][j] + downStickLength;


                    // if we choose the right stick, then we take the size of the right stick/down one
                        // length = initSize - cutArr[j];
                    // else, we choose the left stick, so we take the size of the left stick/prev one
                        // length = cutArr[i];

                    if (downStickCost < prevStickCost){
                        // stickLength[i][j] = initSize - cutArr[j];
                        dpMinCost[i][j] = downStickCost;
                    }
                    else{
                        // stickLength[i][j] = cutArr[i];
                        dpMinCost[i][j] = prevStickCost;
                    }

                    k += 1;

                }
            }
            System.out.println(dpMinCost[0][numCuts - 1]);
        }
    }
}
