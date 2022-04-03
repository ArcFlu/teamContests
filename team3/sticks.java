import java.util.*;

public class sticks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n < numCases; n++){
            int initSize = scan.nextInt();
            int numCuts = scan.nextInt();
            int[] cutArr = new int[numCuts + 2];

            for (int j = 1; j < numCuts + 1; j++){
                cutArr[j] = scan.nextInt();
            }

            cutArr[0] = 0;
            cutArr[numCuts + 1] = initSize;


            int[][] dpMinCost = new int[numCuts + 2][numCuts + 2];

//            for (int i = 0; i < numCuts; i++){
//                dpMinCost[i][i + 2] = initSize;
//            }

            // The cost from cutting from 0 - 10 is
            // 0 2 and 2 10
                // the cost from cutting from 2 - 10 is
                // 2 5 and 5 10
                    // the cost from cutting 5-10 is
                    // 5 6 and 6 10
                // 2 6 and 6 10
                    // the cost from cutting 2-6 is
                    // 2 5 and 5 6
                // the cost from cutting 0 - 2 is 0
            // so total answer for 0 2 and 2 10 is the min of the sums above ^^^
            // 0 5 and 5 10
            // 0 6 and 6 10

            for (int i = dpMinCost.length - 1; i > -1; i--) {
                for (int j = i + 2; j < dpMinCost.length; j++) {
                    int minCost = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++){
                        int sum = 0;
                        sum = dpMinCost[i][k] + dpMinCost[k][j] + (cutArr[j] - cutArr[i]);
                        minCost = Math.min(sum, minCost);
                    }
                    dpMinCost[i][j] = minCost;
                }
            }

//            for (int[] ints : dpMinCost) System.out.println(Arrays.toString(ints));
//            System.out.println(Arrays.toString(cutArr));

            System.out.println(dpMinCost[0][dpMinCost.length - 1]);
        }
    }
}
