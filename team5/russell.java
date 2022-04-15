import java.sql.SQLOutput;
import java.util.*;

public class russell {
    public static void main(String[] args) {
        Scanner scnr = new Scanner (System.in);

        while (scnr.hasNextDouble()) {
            point t1 = new point(scnr.nextDouble(),scnr.nextDouble(),scnr.nextDouble());
            point t2 = new point(scnr.nextDouble(),scnr.nextDouble(),scnr.nextDouble());
            point t3 = new point(scnr.nextDouble(),scnr.nextDouble(),scnr.nextDouble());
            point r = new point(scnr.nextDouble(),scnr.nextDouble(),scnr.nextDouble());
            point v = new point(scnr.nextDouble(),scnr.nextDouble(),scnr.nextDouble());

            vector v1 = new vector (t2, t1);
            vector v2 = new vector (t3, t1);

            line l = new line (r.x, r.y, r.z, v.x, v.y, v.z);

            vector n = v1.crossProd(v2);

            plane p = new plane(n.i, n.j, n.k, t1.x, t1.y, t1.z);

            double num = p.d-((p.x*l.x)+(p.y*l.y)+(p.z*l.z));
            double den = ((p.x*l.v.i)+(p.y*l.v.j)+(p.z*l.v.k));
//            System.out.println("" + p.x + " " + p.y + " " + p.z + " " + p.d);
            double poi_lam = num/den;
//            System.out.println(poi_lam);

            point poi = l.getPoint(poi_lam);

            double A1 = angel(t1, poi, t2);
            double A2 = angel(t2, poi, t3);
            double A3 = angel(t3, poi, t1);

            double res = (A1+A2+A3);

//            System.out.println("ANGLES: " + A1 + " " + A2 + " " + A3 + " " + res);

            if (Math.abs((2 * Math.PI) - res) <= 1e-9)
                System.out.println("No");
            else
                System.out.println("Yes");

        }

    }

    static double angel (point p1, point p2, point p3) {

        vector v1 = new vector (p2, p1);
        vector v2 = new vector (p2, p3);

//        System.out.println("" + p1.x + p1.y + p1.z);
//        System.out.println("" + p2.x + p2.y + p2.z);
//        System.out.println("" + p3.x + p3.y + p3.z);

        double num = (v1.i*v2.i) + (v1.j*v2.j) + (v1.k*v2.k);
        double den = Math.sqrt(Math.pow(v1.i, 2) + Math.pow(v1.j, 2) + Math.pow(v1.k, 2))
                * Math.sqrt(Math.pow(v2.i, 2) + Math.pow(v2.j, 2) + Math.pow(v2.k, 2));

        return Math.acos(num/den);
    }

    static class point {
        double x, y, z;
        point (double X, double Y, double Z) {
            x = X;
            y = Y;
            z = Z;
        }
    }

    static class vector {
        double i, j, k;
        vector (double X, double Y, double Z) {
            i = X;
            j = Y;
            k = Z;
        }

        vector (point p1, point p2) {
            i = p2.x-p1.x;
            j = p2.y-p1.y;
            k = p2.z-p1.z;
        }

        vector crossProd (vector o) {
            double xComp = (this.j*o.k) - (this.k*o.j);
            double yComp = (this.k*o.i) - (this.i*o.k);
            double zComp = (this.i*o.j) - (this.j*o.i);

            return new vector (xComp, yComp, zComp);
        }

    }

    static class plane {
        double x, y, z, d;
        plane (double X, double Y, double Z, double PX, double PY, double PZ) {
            x = X;
            y = Y;
            z = Z;
            d = (X*PX) + (Y*PY) + (Z*PZ);
        }
    }

    static class line {
        double x, y, z;
        vector v;
        line (double x1, double y1, double z1, double x2, double y2, double z2) {
            x = x1;
            y = y1;
            z = z1;
            v = new vector(new point(x1, y1, z1), new point(x2, y2, z2));
        }

        point getPoint(double lam) {
            double rx = this.x + (this.v.i*lam);
            double ry = this.y + (this.v.j*lam);
            double rz = this.z + (this.v.k*lam);

            return new point(rx, ry, rz);
        }

    }

}


