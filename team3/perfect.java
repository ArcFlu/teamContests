import java.util.*;

public class perfect {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int c = scnr.nextInt();
        for (int k = 0; k < c; k++) {
            int b = scnr.nextInt();
            int z = scnr.nextInt();

            int i = 2;
            while (true) {
                int y = (int) Math.pow(b, i);
                //System.out.println(y);
                if (y > z) {
                    System.out.println("NO");
                    break;
                }
                if (y == z) {
                    System.out.println("YES");
                    break;
                }
                i++;
            }
//            double y = (Math.log(z) / Math.log(b));
//            //System.out.println(y);
//            if (y%1 == 0 && b != z)
//                System.out.println("YES");
//            else
//                System.out.println("NO");
        }
    }
}
