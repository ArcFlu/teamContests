import java.util.*;

class russell {

    public static void main(String[] args) {
        Scanner scnr = new Scanner (System.in);

        while (scnr.hasNextDouble()) {
            point t1 = new point(scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble());
            point t2 = new point(scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble());
            point t3 = new point(scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble());
            point r = new point(scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble());
            point v = new point(scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble());
            
            //System.out.println("===================");

            plane signPlane = new plane (t1, t2, t3);

            //check if russell and his view are on the same or opposite sides of the sign
            double rDistance = signPlane.distance(r);
            double vDistance = signPlane.distance(v);

            //System.out.println(rDistance);
            //System.out.println(vDistance);
            //System.out.println(signPlane.d);

            // if the distance between russell and the plane and the distance between
            //   his view and the plane have the same polarity, then he can see it
            if ((rDistance > signPlane.d && vDistance > signPlane.d) || (rDistance < signPlane.d && vDistance < signPlane.d)) {
                System.out.println("Yes");
                continue;
            }

            vector line = new vector(r, v);
            double t = getT(signPlane, line);
            point poi = line.getPoint(t);
            //System.out.println("" + poi.x + " " + poi.y + " " + poi.z);
            
            double A1 = angle(new vector (poi, t1), new vector (poi, t2));
            double A2 = angle(new vector (poi, t2), new vector (poi, t3));
            double A3 = angle(new vector (poi, t3), new vector (poi, t1));

            double total = A1+A2+A3;
            //System.out.println("" + A1 + " " + " + " + A2 + " " + " + " + A3 + " " + " = " + total);

            //System.out.println(Math.abs((Math.PI*2) - total));
          
            if (Math.abs((Math.PI*2) - total) < 0.000000001)
                System.out.println("No");
            else
                System.out.println("Yes");

        }

    }

    static double angle (vector v, vector u) {
        double num = v.dot(u);
        double den = v.mag() * u.mag();
        double cos =  num / den;
        return Math.acos(cos);
    }

    static double getT (plane p, vector v) {
        double num = p.d - (p.normal.i*v.start.x) - (p.normal.j*v.start.y) - (p.normal.k*v.start.z);
        double den = (p.normal.i*v.i) + (p.normal.j*v.j) + (p.normal.k*v.k);
        return num/den;
    }

    static class point {

        double x, y, z;

        point (double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        point (point p) {
            this.x = p.x;
            this.y = p.y;
            this.z = p.z;
        }

    }

    static class vector {

        double i, j, k;
        point start;

        vector (point a, point b) {

            this.i = b.x - a.x;
            this.j = b.y - a.y;
            this.k = b.z - a.z;

            this.start = new point(a.x, a.y, a.z);

        }

        vector (vector v) {
            this.i = v.i;
            this.j = v.j;
            this.k = v.k;

            this.start = new point(v.start.x, v.start.y, v.start.z);
        }

        vector (double i, double j, double k, point a) {
            this.i = i;
            this.j = j;
            this.k = k;

            this.start = new point(a);

        }

        double mag () {
            double res = Math.pow(this.i, 2) + Math.pow(this.j, 2) + Math.pow(this.k, 2);
            return Math.sqrt(res);
        }

        void scale(double magnitude) {
            this.i = this.i * magnitude;
            this.j = this.j * magnitude;
            this.k = this.k * magnitude;
        }

        point getPoint (double distance) {
            this.scale(distance);
            return new point(this.start.x+this.i, this.start.y+this.j, this.start.z+this.k);
        }

        vector cross (vector o) {

            double iComp = (this.j*o.k) - (this.k*o.j);
            double jComp = (this.k*o.i) - (this.i*o.k);
            double kComp = (this.i*o.j) - (this.j*o.i);

            return (new vector(iComp, jComp, kComp, this.start));

        }

        double dot (vector o) {

            double iComp = this.i * o.i;
            double jComp = this.j * o.j;
            double kComp = this.k * o.k;

            return (iComp + jComp + kComp);

        }

    }

    static class plane {

        vector normal;
        point onPlane;
        double d;

        plane (point p1, point p2, point p3) {
            this.onPlane = new point(p2);

            vector v1 = new vector (p2, p1);
            vector v2 = new vector (p2, p3);

            this.normal = v1.cross(v2);

            this.d = (onPlane.x * this.normal.i) + (onPlane.y * this.normal.j) + (onPlane.z * this.normal.k);
        }

        double distance (point p) {
            return (p.x * this.normal.i) + (p.y * this.normal.j) + (p.z * this.normal.k);
        }

    }

}