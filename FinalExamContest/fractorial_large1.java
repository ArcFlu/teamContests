import java.util.*;

public class fractorial_large1 {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        int c = scnr.nextInt();
        for (int k = 0; k < c; k++) {

            int a = scnr.nextInt();
            int b = scnr.nextInt();

            long den = (long)Math.pow(a, b);

            for (int i = 0; ; i++)
                if (factorial(i) % den == 0) {
                    System.out.println(i);
                    break;
                }

        }

    }

    static long factorial (long n) {
        if (n == 0)
            return 1;
        return n * factorial(n-1);
    }

}
