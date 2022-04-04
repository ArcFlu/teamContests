import java.util.*;

public class railroad {
  public static void main(String[] args) {
    Scanner scnr = new Scanner (System.in);

    int n = scnr.nextInt();
    int m = scnr.nextInt();

    while (n != 0 || m != 0) {
      int[] car1 = new int[n];
      for (int i = 0; i < n; i ++)
        car1[i] = scnr.nextInt();

      int[] car2 = new int[m];
      for (int i = 0; i < m; i++)
        car2[i] = scnr.nextInt();

      int[] wanted = new int[n+m];
      for (int i = 0; i < m+n; i++)
        wanted[i] = scnr.nextInt();

      boolean[][] dp = new boolean[n+1][m+1];
      for (int j = 0; j <= m; j++)
        dp[0][j] = true;

      for (int i = 1; i <= n; i++) {
        for (int j = 0; j <=m; j++) {
          dp[i][j] = (car1[i-1] == wanted[i+j-1] && dp[i-1][j]);
          //System.out.print((car1[i-1] == wanted[i+j-1]) + "+" + dp[i-1][j] + " ");
        }
        //System.out.println();
      }

      // catch edge case
      if (n == 0) {
        boolean flag = true;
        for (int i = 0; i < m; i++)
          flag = flag && (car2[i] == wanted[i]);
        dp[n][m] = flag;
      }

      if (dp[n][m])
        System.out.println("possible");
      else
        System.out.println("not possible");

      n = scnr.nextInt();
      m = scnr.nextInt();
    }

  }
  
}