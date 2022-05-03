import java.util.*;

public class candy2 {

    static HashSet<Integer> seen = new HashSet<Integer>();

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int c = scnr.nextInt();
        for (int k = 0; k < c; k++) {
            int n = scnr.nextInt();

            int[][] candies = new int[n][2];
            for (int i = 0; i < n; i++) {
                candies[i][0] = scnr.nextInt();
                candies[i][1] = scnr.nextInt();
            }

            seen.clear();
            seen.add(candies[0][0]);
            seen.add(candies[0][1]);

            for (int i = 1; i < n; i++) {
                HashSet<Integer> tmp = new HashSet<Integer>();
                for (int val : seen) {
                    tmp.add(val + candies[i][0]);
                    tmp.add(val + candies[i][1]);
                }
                seen = tmp;
            }

            System.out.println(seen.size());
        }

    }
}
