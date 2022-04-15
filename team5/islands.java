import java.util.*;

public class islands {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n < numCases; n++){
            int currentCase = scan.nextInt();
            int[] inputArray = new int[12];
            for (int i = 0; i < 12; i++){
                inputArray[i] = scan.nextInt();
            }

            int islandCount = 0;
            int prevStart = 0;
            int prevEnd = 0;
            for (int i = 1; i < 12; i++){
                prevStart = inputArray[i - 1];
                int curStart = inputArray[i];
                if (curStart <= prevStart)
                    continue;
                else{
                    for (int j = 10; j >= i; j--){
                        prevEnd = inputArray[j + 1];
                        for (int k = j; k >= i; k--){
                            int curEnd = inputArray[k];
                            if (curEnd <= prevEnd || curEnd <= prevStart){
                                break;
                            }
                            if (k == i){
                                islandCount++;
                            }
                        }
                    }
                }
            }
            System.out.println(currentCase + " " + islandCount);
        }
    }
}
