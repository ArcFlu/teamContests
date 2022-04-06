import java.util.*;

public class mixedset
{
    // need static variables to ensure consistency
    static int[] solution;
    static int count;

    // Working recursive solution.
    // Encounters a stack overflow error on large inputs.
    public static boolean findSolution (int n, int s, int k)
    {
        if (count == k)
            return true;
        else if (count > k)
            return false;

        bump(n, s);
        HashSet<Integer> set = new HashSet<>();
        for (int i = s-1; i >= 1; i--)
        {
            for (int j = i-1; j >= 0; j--)
            {
                if (set.add(solution[i] - solution[j]) == false)
                {
                    bump(n, s);
                    return findSolution(n, s, k);
                }
            }
        }

        count++;
        return findSolution(n, s, k);
    }

    // Experimental solution.
    public static boolean findSolutionExperimental (int n, int s, int k)
    {
        HashSet<Integer> set = new HashSet<>();
        boolean flag = true;
        while (flag)
        {
            if (count == k)
                return true;
            
            bump(n, s);
            boolean isValid = true;
            for (int i = s-1; i >= 1; i--)
            {
                for (int j = i-1; j >= 0; j--)
                {
                    if (set.add(solution[i] - solution[j]) == false)
                    {
                        bump(n, s);
                        isValid = false;
                        break;
                    }
                }
                if (!isValid)
                {
                    break;
                }
            }

            if (isValid)
                count++;
            
            set = new HashSet<>();
            // System.out.print(solution[s-1] + " ");
        }

        return false;
    }

    // Increases the array by 1.
    // Adjusts array if the increase is not at the end of the array.
    public static void bump(int upperBound, int length)
    {
        for (int i = length-1; i >= 0; i--)
        {
            if (solution[i] < upperBound && i == length-1)
            {
                solution[i]++;
                return;
            }
            else if (solution[i] < upperBound)
            {
                solution[i]++;
                for (int j = i+1; j < length; j++)
                    solution[j] = solution[i];
                return;
            }
        }
    }

    // Prints the array nicely.
    public static void printSolution()
    {
        for (int i = 0; i < solution.length; i++)
        {
            System.out.print(solution[i]);
            if (i < solution.length)
                System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int currCase = 1; currCase <= numCases; currCase++)
        {
            int n = input.nextInt(); // upper bound of values
            int s = input.nextInt(); // how many values we're working with
            int k = input.nextInt(); // how deep to search before returning
            solution = new int[s];
            for (int i = 1; i <= s; i++)
                solution[i-1] = i;

            count = 0;

            if (findSolution(n, s, k))
                printSolution();
            else
                System.out.println("No solution found.");
        }
    }
}
