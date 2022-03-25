import java.util.*;

public class spidey {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int c = scnr.nextInt();
        for (int k = 0; k < c; k++) {
            int v = scnr.nextInt();
            int e = scnr.nextInt();
            HashMap<Integer, ArrayList<Integer> > web = new HashMap<Integer, ArrayList<Integer> >();
            for (int i = 0; i < v; i++)
                web.put(i, new ArrayList<Integer>());
            for (int i = 0; i < e; i++) {
                int a = scnr.nextInt();
                int b = scnr.nextInt();
                web.get(a).add(b);
                web.get(b).add(a);
            }
            boolean safe = checkWeb(e, v, web);

            if (safe)
                System.out.println("Way to go, Spider-Man!");
            else
                System.out.println("It's the end of the world!");
            System.out.println("");
        }
    }

    static boolean checkWeb(int e, int v, HashMap<Integer, ArrayList<Integer> > web) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(0);
        boolean[] visited = new boolean[v];

        while (!q.isEmpty()) {
            int curr = q.pop();

            if (visited[curr])
                continue;
            else
                visited[curr] = true;

            if (web.get(curr).isEmpty())
                return false;

            for (int i = 0; i < web.get(curr).size(); i++)
                if (curr%2 == web.get(curr).get(i)%2)
                    return false;

            for (int i = 0; i < web.get(curr).size(); i++) {
                int x = web.get(curr).get(i);
                if (!visited[x])
                    q.add(x);
            }
        }

        // check that all have been visisted
        for (int i = 0; i < v; i++)
            if (!visited[i])
                return false;

        return true;
    }

}
