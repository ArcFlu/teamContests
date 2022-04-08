import java.util.*;

public class mixedset {
    public static int maxInt;
    public static int desiredLength;
    public static int desiredRank;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n < numCases; n++) {
            maxInt = scan.nextInt();
            desiredLength = scan.nextInt();
            desiredRank = scan.nextInt();
            int[] comboArray = new int[desiredLength];
            boolean[] useNumberArray = new boolean[51];
            boolean[] currentPairDiffs = new boolean[51];
            useNumberArray[0] = true;
            currentPairDiffs[0] = true;
            rankedRecursion(comboArray, useNumberArray, currentPairDiffs, 0);
            System.out.println(comboArray);
        }
    }

    public static boolean rankedRecursion(int[] comboArray, boolean[] useNumberArray, boolean[] currentPairDiffs, int currentIndex){
        int start = 1;
        if (currentIndex > 0)
            start = comboArray[k-1] + 1;

        for (int i = start; i < maxInt; i++) {
            if (!useNumberArray[i]) {
                useNumberArray[i] = true;
                comboArray[currentIndex] = i;
                if (rankedRecursion(comboArray, useNumberArray, currentPairDiffs, currentIndex + 1);
                    return true;
                useNumberArray[i] = false;
            }
        }
    }

    public static int nextPairDiffInt(int previousNum, boolean[] useNumberArray, boolean[] currentPairDiffs){
        int returnNum = 0;

        return returnNum;
    }
}
