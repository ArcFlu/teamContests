import java.util.*;

public class segment {
    public static void main(String[] args) {

        Scanner scnr = new Scanner (System.in);

        while (scnr.hasNextDouble()) {
            double h = scnr.nextDouble();
            double k = scnr.nextDouble();
            double r = scnr.nextDouble();
            double x1 = scnr.nextDouble();
            double y1 = scnr.nextDouble();
            double x2 = scnr.nextDouble();
            double y2 = scnr.nextDouble();

            double dx = x1 - x2;
            double dy = y1 - y2;

            double a = Math.pow(dx,2) + Math.pow(dy, 2);
            double b = 2 * ((dx * (x2 - h)) + (dy * (y2 - k)));
            double c = Math.pow((x2 - h), 2) + Math.pow((y2 - k), 2) - Math.pow(r, 2);

            double discriminant = Math.pow(b, 2) - (4 * a * c);
            if (discriminant < 0){
                System.out.println("The line segment does not intersect the circle.");
                continue;
            }

            double quadratic = (-b - (Math.sqrt(discriminant))) / (2 * a);
            double quadratic2 = (-b + (Math.sqrt(discriminant))) / (2 * a);

//            System.out.println(quadratic);
//            System.out.println(quadratic2);
            if ((quadratic >= 0 && quadratic <= 1) || (quadratic2 >= 0 && quadratic2 <= 1))
                System.out.println("The line segment intersects the circle.");
            else
                System.out.println("The line segment does not intersect the circle.");

        }

    }
}
