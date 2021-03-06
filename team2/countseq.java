import java.util.*;

public class countseq
{
	// Code borrowed from Guha's notes.
	// Modified to find amount of subsequences (doesn't work).
	public static int lcsdyn(String x, String y) {

		int i,j;
		int lenx = x.length();
		int leny = y.length();
		int[][] table = new int[lenx+1][leny+1];

		// Initialize table that will store LCS's of all prefix strings.
		// This initialization is for all empty string cases.
		for (i=0; i<=lenx; i++)
			table[i][0] = 0;
		for (i=0; i<=leny; i++)
			table[0][i] = 0;

		// Fill in each LCS value in order from top row to bottom row,
		// moving left to right.
		for (i = 1; i<=lenx; i++) {
			for (j = 1; j<=leny; j++) {

				// If last characters of prefixes match, add one to former value.
				if (x.charAt(i-1) == y.charAt(j-1))
					table[i][j] = 1+table[i-1][j];

				// Otherwise, take the maximum of the two adjacent cases.
				else
					table[i][j] = Math.max(table[i][j-1], table[i-1][j]);

				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}

		// This is our answer.
		return table[lenx-1][leny-1];
	}

	public static int rec(String s, String t)
	{
		if (s.length() == 0 || t.length() == 0)
			return 0;

		if (s.charAt(0) == t.charAt(0))
			if (t.length() == 1)
				return 1 + rec(s.substring(1), t);
			else
				return rec(s.substring(1), t.substring(1)) + rec(s.substring(1), t);

		return rec(s.substring(1), t);
	}

	public static long dyn(String s, String t)
	{
		int sLen = s.length();
		int tLen = t.length();
		long [][] dp = new long[tLen+1][sLen+1];

		for (int i = 1; i <= tLen; i++)
		{
			int booster = 1;
			for (int j = 1; j <= sLen; j++)
			{
				if (t.charAt(i-1) == s.charAt(j-1))
					if (i == 1)
						dp[i][j] = booster++;
					else
						dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
				else
					dp[i][j] = dp[i][j-1];

				// System.out.print(dp[i][j]+" ");
			}
			// System.out.println();
		}

		return dp[tLen][sLen];
	}

	public static void testing(String s, String t)
	{
		System.out.println(s + " " + t);
		// System.out.println("Recursion: " + rec(s, t));
		System.out.println("Dynamic: " + dyn(s, t));
		System.out.println();
	}

	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);

		long numCases = input.nextLong();
		while (input.hasNext())
		{
			String s = input.next();
			String t = input.next();

			// testing(s, t);

			System.out.println(dyn(s, t));
		}
	}
}
