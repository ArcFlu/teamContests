import java.util.*;

public class speed3 {
    public static double[] distancesArray;
    public static double[] speedArray;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numSections = scan.nextInt();
        double maxTime = scan.nextDouble();
        distancesArray = new double[numSections];
        speedArray = new double[numSections];
        for (int i = 0; i < numSections; i++) {
            distancesArray[i] = scan.nextDouble();
            speedArray[i] = scan.nextDouble();
        }

        double finalTime = 0;
        double negativeSign = 1;
        double tempTime = calcTime(0, negativeSign);
        if (tempTime < maxTime)
            negativeSign = -1;
        finalTime = tempTime;


        double lowerBound = 0;
        double higherBound = Double.MAX_VALUE;
        double midPoint = lowerBound + (higherBound - lowerBound) / 2;
        while (Math.abs(higherBound - lowerBound) > 0.0000000001) {
            midPoint = lowerBound + (higherBound - lowerBound) / 2;
            finalTime = calcTime(midPoint, negativeSign);
            System.out.println(finalTime);
            System.out.println("lower: " + lowerBound + "~~~Upper: " + higherBound) ;
            System.out.println(midPoint);
            if (negativeSign == 1) {
                if (finalTime > maxTime)
                    higherBound = midPoint;
                else if (finalTime < maxTime)
                    lowerBound = midPoint;
                else {
                    break;
                }
            } else {
                if (finalTime > maxTime)
                    lowerBound = midPoint;
                else if (finalTime < maxTime)
                    higherBound = midPoint;
                else {
                    break;
                }
            }
        }

        System.out.printf("%.9f", midPoint);
    }

    public static double calcTime ( double c, double negativeSign){
        double tempTime = 0;
        for (int i = 0; i < distancesArray.length; i++) {
            double currSpeed = speedArray[i] + (c * negativeSign);
            if (currSpeed == 0)
                continue;
            else
                tempTime += distancesArray[i] / currSpeed;
        }
        return tempTime;
    }
}