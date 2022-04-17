import java.util.*;

// Ford Fulkerson algo taken from Guha's notes on Network Flow.
class FordFulkerson {

	// Stores graph.
	public int[][] cap;
	public int n;
	public int source;
	public int sink;

	// "Infinite" flow.
	final public static int oo = (int)(1E9);

	// Set up default flow network with size+2 vertices, size is source, size+1 is sink.
	public FordFulkerson(int size) {
		n = size + 2;
		source = n - 2;
		sink = n - 1;
		cap = new int[n][n];
	}

	// Adds an edge from v1 -> v2 with capacity c.
	public void add(int v1, int v2, int c) {
		cap[v1][v2] = c;
	}

	// Wrapper function for Ford-Fulkerson Algorithm
	public int ff() {

		// Set visited array and flow.
		boolean[] visited = new boolean[n];
		int flow = 0;

		// Loop until no augmenting paths found.
		while (true) {

			// Run one DFS.
			Arrays.fill(visited, false);
			int res = dfs(source, visited, oo);

			// Nothing found, get out.
			if (res == 0) break;

			// Add this flow.
			flow += res;
		}

		// Return it.
		return flow;
	}

	// DFS to find augmenting math from v with maxflow at most min.
	public int dfs(int v, boolean[] visited, int min) {

		// got to the sink, this is our flow.
		if (v == sink)  return min;

		// We've been here before - no flow.
		if (visited[v])  return 0;

		// Mark this node and recurse.
		visited[v] = true;
		int flow = 0;

		// Just loop through all possible next nodes.
		for (int i = 0; i < n; i++) {

			// We can augment in this direction.
			if (cap[v][i] > 0)
				flow = dfs(i, visited, Math.min(cap[v][i], min));

			// We got positive flow on this recursive route, return it.
			if (flow > 0) {

				// Subtract it going forward.
				cap[v][i] -= flow;

				// Add it going backwards, so that later, we can flow back through this edge as a backedge.
				cap[i][v] += flow;

				// Return this flow.
				return flow;
			}
		}

		// If we get here there was no flow.
		return 0;
	}
}

public class campout
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int numCases = input.nextInt();
		int totalStudents = 10;
		int totalShifts = 42;
		int maxShifts = 20;

		for (int currCase = 1; currCase <= numCases; currCase++)
		{
			if (currCase > 1)
				System.out.println();
				
			// Establishing the network.
			FordFulkerson network = new FordFulkerson(totalShifts + totalStudents);
			// Set up source.
			for (int i = 0; i < totalStudents; i++)
				network.add(totalShifts+totalStudents, i, maxShifts);
			// Set up edges for each shift.
			for (int i = 0; i < totalShifts; i++)
				network.add(totalStudents+i, totalShifts+totalStudents+1, 3);

			for (int i = 0; i < totalStudents; i++)
			{
				boolean [] available = new boolean[totalShifts];
				Arrays.fill(available, true);

				int badTimes = input.nextInt();
				for (int j = 0; j < badTimes; j++)
				{
					int day = input.nextInt();
					int start = input.nextInt();
					int end = input.nextInt();
					start = (day - 1) * 6 + (start / 4); // Represents the respective start of the shift on the day.
					end = (day - 1) * 6 + ((end + 3) / 4); // Same as above, but for the end of the shift.

					// Fill in spots to show unavailability.
					for (int k = start; k < end; k++)
						available[k] = false;
				}

				// If the student in available, connect them with the shift.
				for (int j = 0; j < totalShifts; j++)
					if (available[j])
						network.add(i, totalStudents+j, 1);
			}

			if (network.ff() == 126)
				System.out.println("Case #" + currCase + ": YES");
			else
				System.out.println("Case #" + currCase + ": NO");

		}
	}
}
