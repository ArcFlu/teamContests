import java.util.*;

public class mixedset {
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

        int start = 0;
        if (currentIndex > 0) start = comboArray[k-1] + 1;

        for (int i = start; i < maxInt; i++) {
            if (!used[i]) {
                used[i] = true;
                comboArray[currentIndex] = i;
                recursiveNextRank(comboArray, used, currentIndex + 1);
                used[i] = false;
            }
        }
    }
}
