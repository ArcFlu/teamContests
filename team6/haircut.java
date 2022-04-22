import java.util.*;

public class haircut {
    public static int findBarber (int numBarbers, int placeInLine, double[] barbers) {
        if (numBarbers >= placeInLine)
            return placeInLine;

        if (numBarbers == 1)
            return 1;

        int currCustomer = numBarbers;
        double minute = 1;
        while (true) {
            for (int j = 0; j < numBarbers; j++) {
                if (minute % barbers[j] == 0) {
                    currCustomer++;
                    if (currCustomer == placeInLine) {
                        return (j+1);
                    }
                }
            }
            minute += 1;
//            System.out.println(minute);
        }
    }

    public static int findBarberBetter(int numBarbers, int placeInLine, double[] barbers, double fastestTime) {
        if (numBarbers >= placeInLine)
            return placeInLine;
        if (numBarbers == 1)
            return 1;

        int currCustomer = numBarbers;
        double round = 1;
        double time = (double)fastestTime;
        double[] ogTimes = Arrays.copyOf(barbers, numBarbers);
        while (true) {
            for (int i = 0; i < numBarbers; i++) {
                if (time >= barbers[i]) {
                    currCustomer++;
                    if (currCustomer == placeInLine) {
                        // System.out.println(round);

                        return (i+1);
                    }
                    barbers[i] += ogTimes[i];
                    // System.out.println("Barber " + (i+1) + " update: " + barbers[i]);
                    // System.out.println("ogTimes " + ogTimes[i]);
                }
            }
            round++;
            time = (double)fastestTime * round;
            System.out.println("round: " + round + " || time: " + time);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int currCase = 1; currCase <= numCases; currCase++) {
            int numBarbers = input.nextInt();
            int placeInLine = input.nextInt();
            double[] barbers = new double[numBarbers];
            double fastestTime = 1000000;
            for (int i = 0; i < numBarbers; i++) {
                barbers[i] = input.nextDouble();
                if (barbers[i] < fastestTime)
                    fastestTime = barbers[i];
                // System.out.println("Barber #" + (i+1) + ": " + barbers[i]);
            }
            // System.out.println(fastestTime);
            // System.out.println(placeInLine);

           // int myBarber = findBarber(numBarbers, placeInLine, barbers);
            int myBarber = findBarberBetter(numBarbers, placeInLine, barbers, fastestTime);
            System.out.println("Case #" + currCase + ": " + myBarber);
            // System.out.println();
        }
    }
}
