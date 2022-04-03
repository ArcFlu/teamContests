import java.util.*;

public class mixedset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n < numCases; n++){
            int maxInt = scan.nextInt();
            int desiredLength = scan.nextInt();
            int desiredRank = scan.nextInt();
            int[] permArray = new int[desiredLength];
            permArray[0] = 1;

            int rank = 0;
            int index = 1;
            int diff = 1;
            while (rank < desiredRank){
                if (index != desiredLength - 1){
                    permArray[index] = permArray[index - 1] + diff;
                    diff++;
                }
            }
        }
    }
}
