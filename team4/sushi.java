import java.util.*;

public class sushi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n < numCases; n++){
            int numCars = scan.nextInt();
            int[] travelTimes = new int[numCars];
            ArrayList<Integer> travelTimesList = new ArrayList<>();
            for (int i = 0; i < numCars; i++){
                travelTimes[i] = scan.nextInt();
                travelTimesList.add(travelTimes[i]);
            }
            int[] eatingTimes = new int[numCars * 4];
            for (int i = 0; i < numCars * 4; i++){
                eatingTimes[i] = scan.nextInt();
            }
            Arrays.sort(eatingTimes);
            Arrays.sort(travelTimes);
            Collections.sort(travelTimesList);
            Collections.reverse(travelTimesList);
//
//            System.out.println(Arrays.toString(eatingTimes));
//            System.out.println(travelTimesList);

            int[] finalTimes = new int[numCars];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < numCars * 4; i+=4){
                finalTimes[i/4] += travelTimesList.get(i/4) + eatingTimes[i + 3];
//                System.out.println(i + 3);
//                System.out.println(i/4);
                max = Math.max(max, finalTimes[i/4]);
            }


//            System.out.println(Arrays.toString(finalTimes));
            System.out.println("Trip #" + (n + 1) + ": " + max);
        }
    }
}
