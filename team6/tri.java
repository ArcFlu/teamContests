import java.util.*;

public class tri {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int counter = 1;
        while (scnr.hasNextInt()) {
            int n = scnr.nextInt();

            Edge[] arr = new Edge[n*3];
            for (int i = 0; i < n*3; i++) {
                arr[i] = new Edge(i, scnr.nextInt());
            }

            int cost = dijkstra(1, (n*3)-2, arr, arr[1].w);

            System.out.println("" + counter + ". " + cost);
            counter++;
        }

    }

    static int dijkstra (int s, int d, Edge[] g, int startWeight) {
        boolean[] visited = new boolean[g.length];
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.add(new Edge(s, startWeight));

        while (!pq.isEmpty()) {
            Edge at = pq.poll();
            if (visited[at.e]) continue;
            visited[at.e] = true;

            if (at.e == d) return at.w;

            for (Edge adj : getAdj(at.e, g))
                if (!visited[adj.e]) pq.add(new Edge(adj.e, adj.w + at.w));
        }
        return (int) 1e9;
    }

    static Edge[] getAdj(int i, Edge[] g) {

        if (i%3 == 0) {
            return new Edge[]{g[i+1], g[i+3], g[i+4]};
        }
        else if (i%3 == 1) {
            return new Edge[]{g[i+1], g[i+2], g[1+3], g[i+4]};
        }
        else { // if i % 3 == 2
            return new Edge[]{g[i+2], g[i+3]};
        }

    }

    static class Edge implements Comparable<Edge> {
        int e, w;

        Edge (int edges, int weight) {
            this.e = edges;
            this.w = weight;
        }

        public int compareTo(Edge o) {
            return this.w - o.w;
        }

    }

}
