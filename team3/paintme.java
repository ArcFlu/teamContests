import java.util.*;

public class paintme {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int numApartments = scan.nextInt();
    int width = scan.nextInt();
    int length = scan.nextInt();
    int height = scan.nextInt();
    int area = scan.nextInt();
    int numDoors = scan.nextInt();
    while (numApartments != 0 || width != 0 || length != 0 || height != 0 || area != 0 || numDoors != 0){
        int ceilingArea = width * length;
        int widthWalls = 2 * width * height;
        int lengthWalls = 2 * length * height;
        int totalArea = ceilingArea + widthWalls + lengthWalls;

        for (int i = 0; i < numDoors; i++){
            totalArea -= (scan.nextInt() * scan.nextInt());
        }

        totalArea *= numApartments;

        double numPaintCans = 0;
        numPaintCans = Math.ceil((double)totalArea/(double)area);


//        if (totalArea % area > 0 && totalArea != area)
//            numPaintCans = totalArea/area + 1;
//        else
//            numPaintCans = totalArea/area;

        System.out.println((int)numPaintCans);

        numApartments = scan.nextInt();
        width = scan.nextInt();
        length = scan.nextInt();
        height = scan.nextInt();
        area = scan.nextInt();
        numDoors = scan.nextInt();
    }

    }
}
