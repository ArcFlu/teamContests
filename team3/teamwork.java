import java.util.*;

public class teamwork
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();

        for (int currCase = 0; currCase < numCases; currCase++)
        {
            int numCows = input.nextInt();
            int maxTeamSize = input.nextInt();
            long[] skill = new long[numCows+1];
            long[] answer = new long[numCows+1];
            for (int i = 1; i <= numCows; i++)
                skill[i] = input.nextLong();
            
            for (int i = 1; i <= numCows; i++)
            {
                answer[i] = skill[i];
                long max = skill[i];
                for (int j = 1; i-j+1 > 0 && j <= maxTeamSize; j++)
                {
                    if (answer[i] < answer[i-j] + j*max)
                        answer[i] = answer[i-j] + j*max;
                    if (max < skill[i-j])
                        max = skill[i-j];
                }
            }

            System.out.println(answer[numCows]);
        }
    }
}