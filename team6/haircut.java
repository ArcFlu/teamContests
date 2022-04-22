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

    public static int findBarberBetter(int numBarbers, int placeInLine, int[] barbers, int fastestTime) {
        if (numBarbers >= placeInLine)
            return placeInLine;
        if (numBarbers == 1)
            return 1;

        int currCustomer = numBarbers;
        int round = 1;
        int time = fastestTime;
        while (true) {
            for (int i = 0; i < numBarbers; i++){
                if (time >= (barbers[i] * round)) {
                    currCustomer++;
                    if (currCustomer == placeInLine)
                        return (i+1);
                }
            }
            fastestTime *= 2;
            round++;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int currCase = 1; currCase <= numCases; currCase++) {
            int numBarbers = input.nextInt();
            int placeInLine = input.nextInt();
            int[] barbers = new int[numBarbers];
            int fastestTime = 1000000;
            for (int i = 0; i < numBarbers; i++) {
                barbers[i] = input.nextInt();
                if (barbers[i] < fastestTime)
                    fastestTime = barbers[i];
            }

//            int myBarber = findBarber(numBarbers, placeInLine, barbers);
            int myBarber = findBarberBetter(numBarbers, placeInLine, barbers, fastestTime);
            System.out.println("Case #" + currCase + ": " + myBarber);
        }
    }
}
