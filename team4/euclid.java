import java.util.*;

public class euclid {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        double Ax = scnr.nextDouble();
        double Ay = scnr.nextDouble();
        double Bx = scnr.nextDouble();
        double By = scnr.nextDouble();
        double Cx = scnr.nextDouble();
        double Cy = scnr.nextDouble();
        double Dx = scnr.nextDouble();
        double Dy = scnr.nextDouble();
        double Ex = scnr.nextDouble();
        double Ey = scnr.nextDouble();
        double Fx = scnr.nextDouble();
        double Fy = scnr.nextDouble();

        while (Ax != 0 || Ay != 0 || Bx != 0 || By != 0 || Cx != 0 || Cy != 0 || Dx != 0 || Dy != 0 || Ex != 0 || Ey != 0 || Fx != 0 || Fy != 0 ) {

            double targetArea = getArea(Ex, Ey, Dx, Dy, Fx, Fy);

            double ac = getDistance(Ax, Ay, Cx, Cy);
            double ab = getDistance(Ax, Ay, Bx, By);
            double bc = getDistance(Bx, By, Cx, Cy);

            double ac2 = Math.pow(ac, 2);
            double ab2 = Math.pow(ab, 2);
            double bc2 = Math.pow(bc, 2);

            double h = targetArea / ab;

            double theta = Math.acos((ac2 + ab2 - bc2)/(2*ac*ab));

            double L = h / Math.sin(theta);

            printAns(L, Ax, Ay, Cx, Cy, Bx, By);

            Ax = scnr.nextDouble();
            Ay = scnr.nextDouble();
            Bx = scnr.nextDouble();
            By = scnr.nextDouble();
            Cx = scnr.nextDouble();
            Cy = scnr.nextDouble();
            Dx = scnr.nextDouble();
            Dy = scnr.nextDouble();
            Ex = scnr.nextDouble();
            Ey = scnr.nextDouble();
            Fx = scnr.nextDouble();
            Fy = scnr.nextDouble();
        }


    }

    static double getArea (double Ax, double Ay, double Bx, double By, double Cx, double Cy) {
        double l1 = Ax*(By-Cy);
        double l2 = Bx*(Cy-Ay);
        double l3 = Cx*(Ay-By);
        return Math.abs((l1+l2+l3)/2);
    }

    static double getDistance(double Ax, double Ay, double Bx, double By) {
        double Dx = Ax - Bx;
        double Dy = Ay - By;

        Dx = Math.pow(Dx, 2);
        Dy = Math.pow(Dy, 2);

        return Math.sqrt(Dx + Dy);

    }

    static void printAns (double distance, double Ax, double Ay, double Cx, double Cy, double Bx, double By) {
        double Nx = Cx - Ax;
        double Ny = Cy - Ay;

        double den = getDistance(Nx, Ny, 0, 0);

        double Dx = (Nx/den)*distance;
        double Dy = (Ny/den)*distance;

        double Hx = Ax + Dx;
        double Hy = Ay + Dy;
        double Gx = Bx + Dx;
        double Gy = By + Dy;

        System.out.printf("%.3f %.3f %.3f %.3f\n", Gx, Gy, Hx, Hy);


    }

}
