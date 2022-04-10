import java.util.*;
 
class forest {

  public static void main(String[] args) {

    Scanner scnr = new Scanner(System.in);

    int n = scnr.nextInt();
    int c = scnr.nextInt();

    Point[] trees = new Point[n];
    
    for (int i = 0; i < n; i++)
      trees[i] = new Point(scnr.nextInt(), scnr.nextInt());

    double par;
    double area;
    
    if (n == 1) {
      par = 0;
      area = Math.PI * Math.pow(c, 2);
    }

    else if (n == 2) {
      par = (trees[0].distanceTo(trees[1])*2);
      area = (trees[0].distanceTo(trees[1]) * (c*2)) + (Math.PI * Math.pow(c, 2));
    }

    else {
      ArrayList<Point> outside = convexHull(trees, n);

      par = 0;
      area = 0;

      for (int i = 0; i < outside.size(); i++) {
        int ip1 = (i+1)%outside.size();
        par += outside.get(i).distanceTo(outside.get(ip1));
        area += ((outside.get(i).x*outside.get(ip1).y) - (outside.get(ip1).x*outside.get(i).y));
        area += ((outside.get(i).distanceTo(outside.get(ip1)) * (c*2)));
      }
      
      area = area * 0.5;
      area += (Math.PI * Math.pow(c, 2));

    }

    par += (Math.PI * 2 * c);
    System.out.printf("%.2f %.2f\n", par, area);
    
  }

  public static int orientation(Point p, Point q, Point r) {
      int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);
    
      if (val == 0) return 0;  // collinear
      return (val > 0)? 1: 2; // clock or counterclock wise
  }
     
  // Prints convex hull of a set of n points.
  public static ArrayList<Point> convexHull(Point points[], int n) {
      // There must be at least 3 points
      if (n < 3) return null;
    
      // Initialize Result
      ArrayList<Point> hull = new ArrayList<Point>();
    
      // Find the leftmost point
      int l = 0;
      for (int i = 1; i < n; i++)
          if (points[i].x < points[l].x)
              l = i;
    
      // Start from leftmost point, keep moving
      // counterclockwise until reach the start point
      // again. This loop runs O(h) times where h is
      // number of points in result or output.
      int p = l, q;
      do {
          // Add current point to result
          hull.add(points[p]);
    
          // Search for a point 'q' such that
          // orientation(p, q, x) is counterclockwise
          // for all points 'x'. The idea is to keep
          // track of last visited most counterclock-
          // wise point in q. If any point 'i' is more
          // counterclock-wise than q, then update q.
          q = (p + 1) % n;
           
          for (int i = 0; i < n; i++) {
             // If i is more counterclockwise than
             // current q, then update q
             if (orientation(points[p], points[i], points[q]) == 2)
                 q = i;
          }
    
          // Now q is the most counterclockwise with
          // respect to p. Set p as q for next iteration,
          // so that q is added to result 'hull'
          p = q;
    
      } while (p != l);  // While we don't come to first point

    return hull;
  
  }
}

class Point {
  
  int x, y;
  
  Point(int x, int y){
    this.x=x;
    this.y=y;
  }

  public double distanceTo(Point o) {
    double a = Math.pow(o.x - this.x, 2);
    double b = Math.pow(o.y - this.y, 2);
    return (Math.sqrt(a+b));
  }
  
}