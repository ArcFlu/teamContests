import java.util.*;

public class fractorial_large {
    public static long fac(long n) {
        if (n == 0 || n == 1)
            return 1;

        long retval = n;
        for (long i = n-1; i > 1; i--) {
            retval *= i;
        }
        return retval;
    }

    public static long myPow (long a, long b) {
        long retval = a;
        for (long i = 1; i < b; i++)
            retval *= a;
        return retval;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inputCases = input.nextInt();
        for (int currCase = 1; currCase <= inputCases; currCase++) {
            long a = input.nextLong();
            long b = input.nextLong();
            long exp = myPow(a, b);
            System.out.println("Denominator: " + exp);
            if (exp == (long)1) {
                System.out.println(0);
                continue;
            }

            for (long i = 0; ; i++) {
                long n = fac(i);
                if (i == 20)
                    System.out.println("20 " + n);
                if (n % exp == 0) {
                    System.out.println("Factorial: " + n);
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}