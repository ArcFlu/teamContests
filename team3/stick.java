import java.util.*;

public class stick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int i = 0; i < numCases; i++){
            int initSize = scan.nextInt();
            int numCuts = scan.nextInt();
            int[] cutArr = new int[numCuts];

            for (int j = 0; j < numCuts; j++){
                cutArr[j] = scan.nextInt();
            }

            int[][] dp = new int[numCuts][numCuts];
        

        }
    }
}
