import java.util.*;

public class robot {
    public static double[][] distanceArray;
    public static double[][] pointsArray;
    public static double[] dpArray;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTargets = scan.nextInt();
        while (numTargets != 0){
            distanceArray = new double[numTargets + 2][numTargets + 2];
            // 0 == x coordinate, 1 == y coordinate, 2 == penalty
            pointsArray = new double[numTargets + 2][3];
            pointsArray[0][0] = 0;
            pointsArray[0][1] = 0;
            pointsArray[0][2] = 0;

            pointsArray[numTargets + 1][0] = 100;
            pointsArray[numTargets + 1][1] = 100;
            pointsArray[numTargets + 1][2] = 0;


            for (int i = 1; i < numTargets + 1; i++){
                pointsArray[i][0] = scan.nextDouble();
                pointsArray[i][1] = scan.nextDouble();
                pointsArray[i][2] = scan.nextDouble() + pointsArray[i - 1][2];
            }

            pointsArray[numTargets + 1][2] = pointsArray[numTargets][2];
            // calculate cost
            for (int i = 0; i < numTargets + 1; i++){
                for (int j = i + 1; j < numTargets + 2; j++){
                    distanceArray[i][j] = pointsArray[j - 1][2] - pointsArray[i][2]
                            + calcDist(pointsArray[i][0], pointsArray[i][1], pointsArray[j][0], pointsArray[j][1]);
                }
            }

            dpArray = new double[numTargets + 2];
            for (int i = 1; i < numTargets + 2; i++){
                double curMin = Double.MAX_VALUE;
                for (int j = 0; j < i; j++){
                    curMin = Math.min(curMin, dpArray[j] + distanceArray[j][i] + 1);
                }
                dpArray[i] = curMin;
            }

//            System.out.println(Arrays.deepToString(pointsArray));
//            System.out.println(Arrays.deepToString(distanceArray));
//            System.out.println(Arrays.toString(dpArray));
//            System.out.println("!");

            System.out.printf("%.3f\n", dpArray[numTargets + 1]);
            numTargets = scan.nextInt();
        }
    }
    public static double calcDist(double x1, double y1, double x2, double y2){
        return (Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
    }
}
