import java.util.*;

public class teamwork
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int i = 0; i < numCases; i++)
        {
            int numCows = input.nextInt();
            int maxTeamSize = input.nextInt();
            long[] arr = new long[numCows];
            for (int j = 0; j < numCows; j++)
                arr[j] = input.nextLong();

            Arrays.sort(arr);
            int bottom = 0;
            int top = numCows-1;
            int teamSize = 1;
            for (int j = 0; j < numCows; j++)
            {
                if (bottom >= top)
                    break;

                if (arr[bottom] < arr[top])
                {
                    arr[bottom] = arr[top];
                    teamSize++;
                    bottom++;
                }
                if (teamSize >= maxTeamSize)
                {
                    top--;
                    teamSize = 1;
                }
            }

            long total = 0;
            for (int j = 0; j < numCows; j++)
                total += arr[j];

            System.out.println(total);
        }
    }
}