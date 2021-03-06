import java.util.*;

public class welcome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numPeople = scan.nextInt();
        while (numPeople != 0){
            FordFulkerson teamNetwork = new FordFulkerson(44);
            for (int i = 0; i < numPeople; i++){
                String firstName = scan.next();
                String lastName = scan.next();
                teamNetwork.add(teamNetwork.source, firstName.charAt(0) - 'A', 1);
                teamNetwork.add(lastName.charAt(0) - 'A' + 26, teamNetwork.sink, 1);
                teamNetwork.add(firstName.charAt(0) - 'A', lastName.charAt(0) - 'A' + 26, 1);
            }
            System.out.println(teamNetwork.ff());
            numPeople = scan.nextInt();
        }

    }
     public static class FordFulkerson {

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
}
