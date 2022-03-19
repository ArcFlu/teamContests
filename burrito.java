import java.util.*;

public class burrito {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int i = 0; i < numCases; i++){
            int chickenCubes = scan.nextInt();
            int steakCubes = scan.nextInt();
            int attendees = scan.nextInt();
            // go through all attendees except last
            for (int j = 0; j < attendees - 1; j++){
                int curChicken = scan.nextInt();
                int curSteak = scan.nextInt();
                int tempChick = chickenCubes - curChicken;
                if (tempChick < 0)
                    chickenCubes = 0;
                else
                    chickenCubes = tempChick;

                int tempSteak = steakCubes - curSteak;
                if (tempSteak < 0)
                    steakCubes = 0;
                else
                    steakCubes = tempSteak;
            }

            int lastChick = scan.nextInt();
            int lastSteak = scan.nextInt();

            if (chickenCubes > lastChick)
                System.out.print(lastChick);
            else
                System.out.print(chickenCubes);

            System.out.print(" ");

            if (steakCubes > lastSteak)
                System.out.print(lastSteak);
            else
                System.out.print(steakCubes);

            System.out.println();
        }
    }
}
