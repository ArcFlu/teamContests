import java.net.Inet4Address;
import java.util.*;

public class railroad {
    public static void main(String[] args) {
        Scanner scnr = new Scanner (System.in);
        LinkedList<trainYard> q = new LinkedList<trainYard>();

        int n = scnr.nextInt();
        int m = scnr.nextInt();

        while (n != 0 || m != 0) {

            LinkedList<Integer> c1 = new LinkedList<Integer>();
            for (int i = 0; i < n; i++) {
                c1.offer(scnr.nextInt());
                //System.out.println(c1.peekLast());
            }

            LinkedList<Integer> c2 = new LinkedList<Integer>();
            for (int i = 0; i < m; i++) {
                c2.offer(scnr.nextInt());
                //System.out.println(c2.peekLast());
            }

            LinkedList<Integer> w = new LinkedList<Integer>();
            for (int i = 0; i < n+m; i++) {
                w.offer(scnr.nextInt());
                //System.out.println(w.peekLast());
            }

            q.offer(new trainYard(c1, c2, w));
            boolean didIt = false;

            while (!q.isEmpty()) {
                trainYard curr = q.pop();

                if (curr.wanted.isEmpty()) {
                    didIt = true;
                    break;
                }

                LinkedList<Integer> tempC1 = new LinkedList<Integer>(curr.car1);
                LinkedList<Integer> tempC2 = new LinkedList<Integer>(curr.car2);
                LinkedList<Integer> tempW = new LinkedList<Integer>(curr.wanted);
                if (tempC1.size() > 0)
                    tempC1.removeLast();
                if (tempC2.size() > 0)
                    tempC2.removeLast();
                tempW.removeLast();

                // if both cars could be taken, add both possibilites to the queue
                if (curr.wanted.peekLast() == curr.car1.peekLast() && curr.wanted.peekLast() == curr.car2.peekLast()) {
                    q.offer(new trainYard(tempC1, curr.car2, tempW));
                    q.offer(new trainYard(curr.car1, tempC2, tempW));
                }

                // if only car 1 could be taken, take car 1
                else if (curr.wanted.peekLast() == curr.car1.peekLast())
                    q.offer(new trainYard(tempC1, curr.car2, tempW));

                // if only car 2 could be taken, take car 2
                else if (curr.wanted.peekLast() == curr.car2.peekLast())
                    q.offer(new trainYard(curr.car1, tempC2, tempW));

                // if neither car can be taken, we just continue to next iteration
                // we already pop'd this case out of q so if it's empty now then it was a bad route
                // check other routes. if no other routes then not possible
            }

            if (didIt)
                System.out.println("possible");
            else
                System.out.println("not possible");

            n = scnr.nextInt();
            m = scnr.nextInt();
        }

    }

    static class trainYard {
        LinkedList<Integer> car1;
        LinkedList<Integer> car2;
        LinkedList<Integer> wanted;

        trainYard (LinkedList<Integer> c1, LinkedList<Integer> c2, LinkedList<Integer> w) {
            car1 = new LinkedList<Integer>(c1);
            car2 = new LinkedList<Integer>(c2);
            wanted = new LinkedList<Integer>(w);
        }

    }

}
