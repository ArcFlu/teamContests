import java.util.*;

public class balloons {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n < numCases; n++){
            int numProblems = scan.nextInt();
            int colorXNot = scan.nextInt();
            int colorYNot = scan.nextInt();
            int[] array = new int[numProblems];
            for (int i =0 ;i < numProblems; i++){
                array[i] = scan.nextInt();
            }

            if (array[0] == colorXNot && array[numProblems - 1] == colorYNot)
                System.out.println("BOTH");
            else if (array[0] == colorXNot && array[numProblems - 1] != colorYNot){
                System.out.println("EASY");
            }
            else if (array[0] != colorXNot && array[numProblems - 1] == colorYNot){
                System.out.println("HARD");
            }
            else
                System.out.println("OKAY");

        }
    }
}
