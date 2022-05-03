import java.util.*;

public class candy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n > numCases; n++){
            int numShops = scan.nextInt();
            int[] arrayDiffs = new int[numShops];
            int[][] pairs = new int[numShops][2];
            int firstColSum = 0;
            for (int i = 0; i < numShops; i++){
                pairs[i][0] = scan.nextInt();
                pairs[i][1] = scan.nextInt();
                arrayDiffs[i] = pairs[i][1] - pairs[i][0];
                firstColSum += pairs[i][0];
            }

            for (int i = 0 ; i < numShops; i++){
                firstColSum += arrayDiffs[i];
                recursive(i, firstColSum, numShops);
            }
        }
    }

    public static void recursive(int positionIndex, int currentSum, int numShops){
        if (currentSum)
        for (int i = positionIndex; i < numShops; i++){

        }
    }
}
