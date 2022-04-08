import java.util.*;

public class mixedset3 {
    public static int desiredRank;
    public static int desiredLength;

    public static int maxInt;
    public static int rank;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n < numCases; n++){
            maxInt = scan.nextInt();
            desiredLength = scan.nextInt();
            desiredRank = scan.nextInt();
            int[] comboArray = new int[desiredLength];
            boolean[] usedArray = new boolean[50];
            usedArray[0] = true;

            rank = 0;

            // remove differences -> iterate number until new difference -> check. If max go back.
            recursiveNextRank(comboArray, usedArray, 0);

            System.out.println(Arrays.toString(comboArray));
        }
    }

    public static boolean recursiveNextRank(int[] comboArray, boolean[] used, int currentIndex){
        if (currentIndex == desiredLength){
            boolean flag = false;
            for (int i = 0; i < comboArray.length; i++){
                if (used[comboArray[currentIndex - 1] - comboArray[i]]){
                    flag = true;
                    break;
                }
            }

            if (flag)
                rank++;

            if (rank == desiredRank)
                return true;
        }


        int start = 1;

        // find the next integer that gives a unique pairwise diff
        boolean flag = false;
        if (currentIndex > 0){
            start = comboArray[currentIndex-1] + 1;
            while (!flag){
                flag = pairDiffs(start, currentIndex, comboArray, used);
                if (!flag)
                    start++;
            }

        }


        for (int i = start; i < maxInt; i++){
            if (!used[i] && pairDiffs(i, currentIndex, comboArray, used)){
                used[i] = true;
                comboArray[currentIndex] = i;
                recursiveNextRank(comboArray, used, currentIndex + 1);
                used[i] = false;
            }
        }

        return false;
    }

    public static boolean pairDiffs(int bruh, int currentIndex, int[] comboArray, boolean[] used){
        for (int i = 1; i < currentIndex - 1; i++){
            if (used[comboArray[currentIndex] - comboArray[i]])
                return false;
        }

        return true;
    }
}
