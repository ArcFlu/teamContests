import java.util.*;

public class bullseye {
    public static void main(String[] args) {

        Scanner scnr = new Scanner (System.in);

        int k = scnr.nextInt();

        for (int i = 1; i <= k; i++) {
            long rad = scnr.nextLong();
            long paint = scnr.nextLong();

            long high = 707106780;
            long low = 1;

            while (high != low) {
                long mid = low + (high - low)/2;

                //System.out.println("high: " + high + " low: " + low);

                long used = checkMid(mid, rad);

                if ((paint - used) < 0)
                    high = mid -1;
                else
                    low = mid;

            }

            System.out.println("Case #" + i + ": " + high);

        }

    }

    static long checkMid(long mid, long rad) {
        long used = (mid*rad) + (mid*((mid*2)-1));
        return used;
    }

}
