import java.util.*;

public class christmas {
    public static long[] daysArray;
    public static long[] sumsArray;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        daysArray = new long[1000000];
        sumsArray = new long[1000000];
        fillArrays();
        int nextDay = scan.nextInt();
        while (nextDay != 0){
            System.out.println(daysArray[nextDay - 1]);
            nextDay = scan.nextInt();
        }
    }

    public static void fillArrays(){
        daysArray[0] = 1;
        sumsArray[0] = 1;
        for (int i = 1; i < 1000000; i++){
            sumsArray[i] = sumsArray[i - 1] + (i + 1);
            daysArray[i] = daysArray[i - 1] + sumsArray[i];
        }
    }
}
