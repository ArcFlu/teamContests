import java.util.*;

public class speed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numSegments = scan.nextInt();
        double totalTime = scan.nextDouble();
        double[][] milesTimeArray = new double[numSegments][2];
        for (int i = 0; i < numSegments; i++){
            milesTimeArray[i][0] = scan.nextDouble();
            milesTimeArray[i][1] = scan.nextDouble();
        }
        double low = Double.MIN_VALUE;
        double high = Double.MAX_VALUE;
        double tempTime = 0;


        double midPoint = low + (high - low) / 2;

        while (Math.abs(high - low) > 0.0000000001){
            midPoint = low + (high - low) / 2;
            boolean flag = false;
            tempTime = 0;
            for (int i = 0; i < numSegments; i++){
                double tempSegment = milesTimeArray[i][0];
                double tempSpeed = milesTimeArray[i][1];
                tempSpeed += midPoint;
                if (tempSpeed <= 0){
                    flag = true;
                    break;
                }

                tempTime += tempSegment / tempSpeed;
            }

            if (flag){
                low = midPoint;
                continue;
            }

            if (tempTime < totalTime){
                high = midPoint;
            }
            else if (tempTime > totalTime)
                low = midPoint;
            else
                break;

            System.out.println(high);

        }

        System.out.printf("%.9f", low);

    }
}
