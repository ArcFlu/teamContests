import java.util.*;

public class speed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numSegments = scan.nextInt();
        int totalTime = scan.nextInt();
        int[][] milesTimeArray = new int[numSegments][2];
        double lowestSpeed = Double.MAX_VALUE;
        for (int i = 0; i < numSegments; i++){
            milesTimeArray[i][0] = scan.nextInt();
            milesTimeArray[i][1] = scan.nextInt();
            lowestSpeed = Math.min(milesTimeArray[i][1], lowestSpeed);
        }
        double low = -lowestSpeed;
        double high = 2_000_000;
        double tempTime = 0;


        double midPoint = low + (high - low) / 2;

        while ((high - low) > 1e-9){
            midPoint = (low + high) / 2;
            tempTime = 0;
            for (int i = 0; i < numSegments; i++){
                double tempSegment = milesTimeArray[i][0];
                double tempSpeed = milesTimeArray[i][1];
                tempTime += tempSegment / (tempSpeed + midPoint);
            }

            if (tempTime < totalTime){
                high = midPoint;
            }
            else if (tempTime > totalTime)
                low = midPoint;
            else
                break;


        }

        System.out.printf("%.9f\n", midPoint);

    }
}
