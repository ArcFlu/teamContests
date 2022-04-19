import java.util.*;

public class ninja {
    public static void main(String[] args) {
        Scanner scnr = new Scanner (System.in);

        int c = scnr.nextInt();
        for (int k = 0; k < c; k++) {
            point p1 = new point(scnr.nextDouble(),scnr.nextDouble(),scnr.nextDouble());
            point p2 = new point(scnr.nextDouble(),scnr.nextDouble(),scnr.nextDouble());
            point p3 = new point(scnr.nextDouble(),scnr.nextDouble(),scnr.nextDouble());
            point t1 = new point(scnr.nextDouble(),scnr.nextDouble(),scnr.nextDouble());
            point t2 = new point(scnr.nextDouble(),scnr.nextDouble(),scnr.nextDouble());
            point t3 = new point(scnr.nextDouble(),scnr.nextDouble(),scnr.nextDouble());
            point t4 = new point(scnr.nextDouble(),scnr.nextDouble(),scnr.nextDouble());

            vector v1 = new vector(p1, p2);
            vector v2 = new vector(p1, p3);

            plane EVIL = new plane (p1, v1.crossProd(v2));


            double d1 = EVIL.calcD(t1);
            double d2 = EVIL.calcD(t2);
            double d3 = EVIL.calcD(t3);
            double d4 = EVIL.calcD(t4);

            if ((d1 > EVIL.d && d2 > EVIL.d && d3 > EVIL.d && d4 > EVIL.d) || (d1 < EVIL.d && d2 < EVIL.d && d3 < EVIL.d && d4 < EVIL.d))
                System.out.println("Tetra-Bot Survives!");
            else
                System.out.println("Evil Ninja Prevails!");

        }

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
        vector normal;

        plane (point p, vector n) {

            x = p.x;
            y = p.y;
            z = p.z;
            d = (p.x*n.i) + (p.y*n.j) + (p.z*n.k);
            normal = n;
        }

        double calcD (point p) {
            return (p.x*this.normal.i) + (p.y*this.normal.j) + (p.z*this.normal.k);
        }

    }

}


