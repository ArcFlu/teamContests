import java.util.*;

public class squirrels {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n < numCases; n++){
            int numTrees = scan.nextInt();
            double[][] pointsArray = new double[numTrees][numTrees];
            for (int i = 0 ; i <numTrees; i++){
                pointsArray[i][0] = scan.nextDouble();
                pointsArray[i][1] = scan.nextDouble();
            }
            double[][] distArray = new double[numTrees][numTrees];
            double minDist = Integer.MAX_VALUE;

            for (int i = 0; i < numTrees; i++){
                for (int j = 0; j < numTrees; j++){
                    if (i == j)
                        continue;
                    if (j > i)
                        distArray[i][j] = calcDist(pointsArray[i][0], pointsArray[i][1], pointsArray[j][0], pointsArray[j][1]);
                    else
                        distArray[i][j] = distArray[j][i];

                    minDist = Math.min(minDist, distArray[i][j]);
                }
            }

            double total = Math.pow(minDist/2, 2) * 3.141592653589793;
            System.out.println("Campus #" + (n + 1) + ":");
            System.out.printf("Maximum territory area = %.3f\n\n", total);
        }
    }
    public static double calcDist(double x1, double y1, double x2, double y2){
        return (Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1),2)));
    }
}
