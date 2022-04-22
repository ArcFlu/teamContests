import java.util.*;

public class speed2 {
    // distance maps to speed via index
    public static double[] distancesArray;
    public static double[] speedArray;
    public static double maxTime;
    public static double answerTime;

      public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numSections = scan.nextInt();
        maxTime = scan.nextDouble();
        distancesArray = new double[numSections];
        speedArray = new double[numSections];
        for (int i = 0; i < numSections; i++){
            distancesArray[i] = scan.nextDouble();
            speedArray[i] = scan.nextDouble();
        }

        double finalTime = 0;

        // test at 0, if answer is false, that means we are overestimating so C is negative
          // if true, then we are underestimating so C is positive.
        boolean negativeSign = calculation(0.0, 0.0, 0.0);


        double minBound = 0;
        double maxBound = Double.MAX_VALUE;
        if (!negativeSign)
            maxBound *= -1;

      double midpoint = minBound + (maxBound - minBound)/2;
          while (Math.abs(minBound - maxBound) > 0.0000001 ){
            boolean temp = false;
            midpoint = minBound + (maxBound - minBound)/2;

            if (negativeSign)
                temp = calculation(minBound, maxBound, midpoint);
            else
                temp = calculation(maxBound, minBound, midpoint);

            if (negativeSign){
                if (temp)
                    maxBound = answerTime;
                else
                    minBound = answerTime;
            }
            else{
                if (temp)
                    minBound = answerTime;
                else
                    maxBound = answerTime;
            }


            System.out.println(midpoint);
        }
    }

    public static boolean calculation(double minBound, double maxBound, double midpoint){
          int tempTotal = 0;
          for (int i = 0; i < distancesArray.length; i++){
              tempTotal += distancesArray[i] * (midpoint * speedArray[i]);
              if (tempTotal >= maxTime){
                  // flag to say that we're overestimating
                  answerTime = tempTotal;
                  return false;
              }
          }

          // true means that we are going less than the time, so we can continue cutting the max bounds to the mid
        if (tempTotal > maxTime){
            answerTime = tempTotal;
            return false;
        }
        else{
            answerTime = tempTotal;
            return true;
        }
    }
}
