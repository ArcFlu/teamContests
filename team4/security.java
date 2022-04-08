import java.util.*;

public class security {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n < numCases;n++){
            int numRooms = scan.nextInt();
            int dx = scan.nextInt();
            int dy = scan.nextInt();
            int[] roomsArray = new int[numRooms];

            int minRoom = Integer.MAX_VALUE;
            int maxRoom = Integer.MIN_VALUE;
            for (int i = 0; i < numRooms; i++){
                roomsArray[i] = scan.nextInt();
            }

            Arrays.sort(roomsArray);
            int[][] dpMinCost = new int[numRooms][numRooms];

            for (int i = 0; i < numRooms - 1; i++){
                for (int j = i + 1; j < i + 2; j++){
                    dpMinCost[i][j] = (dx * (roomsArray[j]%100 - roomsArray[i]%100) + dy * (roomsArray[j]/100 - roomsArray[i]/100));
                }
            }


            for (int i = dpMinCost.length - 1; i > -1; i--) {
                for (int j = i + 2; j < dpMinCost.length; j++) {
                    int minCost = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++){
                        int sum = 0;
                        int sum2 = 0;
                        sum = dpMinCost[i][k] + (dx * (roomsArray[j]%100 - roomsArray[i]%100) + dy * (roomsArray[j]/100 - roomsArray[i]/100));
                        sum2 = dpMinCost[k][j] + (dx * (roomsArray[j]%100 - roomsArray[i]%100) + dy * (roomsArray[j]/100 - roomsArray[i]/100));
                        minCost = Math.min(sum, minCost);
                    }
                    dpMinCost[i][j] = minCost;
                }
            }
            System.out.println(Arrays.deepToString(dpMinCost));
            System.out.println(dpMinCost[0][numRooms - 1]);

        }
    }
}
