// Arup Guha
// 4/5/2016
// Solution to CodeChef Problem: CF224 Polygon

import java.util.*;

public class forest {

	public static void main(String[] args) throws Exception {

		// Read in the points.
		Scanner scnr = new Scanner (System.in);

    int n = scnr.nextInt();
    int c = scnr.nextInt();
    
		pt[] pts = new pt[n];
		for (int i=0; i<n; i++) {
			int x = scnr.nextInt();
			int y = scnr.nextInt();
			pts[i] = new pt(x, y);
		}

		// Set the reference point.
		int refIndex = getIndexMin(pts, n);
		pt.refX = pts[refIndex].x;
		pt.refY = pts[refIndex].y;

    double par;
    double area;
    
    if (n == 1) {
      par = 0;
      area = Math.PI * Math.pow(c, 2);
    }

    else if (n == 2) {
      par = (pts[0].dist(pts[1])*2);
      area = (pts[0].dist(pts[1]) * (c*2)) + (Math.PI * Math.pow(c, 2));
    }

    else {
      ArrayList<pt> outside = new ArrayList<pt>(grahamScan(pts, n));

      par = 0;
      area = 0;

      for (int i = 0; i < outside.size(); i++) {
        int ip1 = (i+1)%outside.size();
        par += outside.get(i).dist(outside.get(ip1));
        area += ((outside.get(i).x*outside.get(ip1).y) - (outside.get(ip1).x*outside.get(i).y));
        area += ((outside.get(i).dist(outside.get(ip1)) * (c*2)));
      }
      
      area = area * 0.5;
      area += (Math.PI * Math.pow(c, 2));

    }

    par += (Math.PI * 2 * c);
    System.out.printf("%.2f %.2f\n", par, area);
    
	}

	// Returns the point in pts with minimum y breaking tie by minimum x.
	public static int getIndexMin(pt[] pts, int n) {
		int res = 0;
		for (int i=1; i<n; i++)
			if (pts[i].y < pts[res].y || (pts[i].y == pts[res].y && pts[i].x < pts[res].x))
				res = i;
		return res;
	}

	public static Stack<pt> grahamScan(pt[] pts, int n) {

		// Sort the points by angle with reference point.
		Arrays.sort(pts);

		// Push first two points on.
		Stack<pt> myStack = new Stack<pt>();
		myStack.push(pts[0]);
		myStack.push(pts[1]);

		// Go through the rest of the points.
		for (int i=2; i<n; i++) {

			// Get last three pts.
			pt cur = pts[i];
			pt mid = myStack.pop();
			pt prev = myStack.pop();

			// Pop off the left turns.
			while (!prev.isRightTurn(mid, cur)) {
				mid = prev;
				prev = myStack.pop();
			}

			// Push back the last right turn.
			myStack.push(prev);
			myStack.push(mid);
			myStack.push(cur);
		}

		// // Add up distances around the hull.
		// double res = 0;
		// pt cur = pts[0];
		// while (myStack.size() > 0) {
		// 	pt next = myStack.pop();
		// 	res += cur.dist(next);
		// 	cur = next;
		// }

		// Return.
		return myStack;
	}
}

class pt implements Comparable<pt> {

	// Stores reference pt
	public static int refX;
	public static int refY;

	public int x;
	public int y;

	public pt(int myx, int myy) {
		x = myx;
		y = myy;
	}

	// Returns the vector from this to other.
	public pt getVect(pt other) {
		return new pt(other.x-x, other.y-y);
	}

	// Returns the distance between this and other.
	public double dist(pt other) {
		return Math.sqrt((other.x-x)*(other.x-x) + (other.y-y)*(other.y-y));
	}

	// Returns the magnitude ot this cross product other.
	public int crossProductMag(pt other) {
		return this.x*other.y - other.x*this.y;
	}

	// returns true iff this to mid to next is a right turn (180 degree is considered right turn).
	public boolean isRightTurn(pt mid, pt next) {
		pt v1 = getVect(mid);
		pt v2 = mid.getVect(next);
		return v1.crossProductMag(v2) >= 0; /*** Change to > 0 to skip collinear points. ***/
	}

	// Returns true iff this pt is the origin.
	public boolean isZero() {
		return x == 0 && y == 0;
	}

	public int compareTo(pt other) {

		pt myRef = new pt(refX, refY);
		pt v1 = myRef.getVect(this);
		pt v2 = myRef.getVect(other);

		// To avoid 0 issues.
		if (v1.isZero()) return -1;
		if (v2.isZero()) return 1;

		// Angles are different, we are going counter-clockwise here.
		if (v1.crossProductMag(v2) != 0)
			return -v1.crossProductMag(v2);

		// This should work, smaller vectors come first.
		if (myRef.dist(v1) < myRef.dist(v2)) return -1;
		return 1;
	}
}