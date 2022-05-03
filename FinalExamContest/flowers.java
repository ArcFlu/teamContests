import java.util.*;

public class flowers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();

        for (int n = 0; n < numCases; n++){
            long numTeams = scan.nextLong();
//            System.out.println(numTeams);
            long totalCents = 0;

            for (long i = 0; i < numTeams; i++){
                String teamName = scan.next();
                long solvedProblems = scan.nextLong();
                long numFlowersPerPack = scan.nextLong();
                long costPerPack = scan.nextLong();

                long numTempPacks = solvedProblems / numFlowersPerPack;
//                System.out.print(teamName + " ");
//                System.out.print(solvedProblems + " ");
//                System.out.print(numFlowersPerPack + " ");
//                System.out.println(costPerPack + " ");
                // if the number of solved problems gives you a remainder then we need to get one more
                if (solvedProblems % numFlowersPerPack != 0 && solvedProblems != 0){
                    totalCents += costPerPack * (numTempPacks + 1);
                }
                else if (solvedProblems % numFlowersPerPack == 0 && solvedProblems != 0){
                    totalCents += costPerPack * numTempPacks;
                }
//                else{
//                    continue;
//                    // solved problems == 0 so nothing
//                }
            }

            System.out.println(totalCents);
        }
    }
}
