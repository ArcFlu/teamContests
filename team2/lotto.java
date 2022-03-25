import java.util.*;

public class lotto {
    public static long[][] matrix;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int col = scan.nextInt();
        int maxNum = scan.nextInt();
        matrix = new long[2000][10];
        for (int i = 0; i < 2000; i++){
            matrix[i][0] = i + 1;
            System.out.println(Arrays.toString(matrix[i]));
        }

        int curSum = 1;
        int curIncrement = 0;
        boolean flag = false;

        for (int i = 1; i < 2000; i++){
            matrix[i][1] = matrix[i - 1][1] + curSum + curIncrement;
            if (flag){
                curIncrement++;
                flag = false;
            }
            else
                flag = true;
            System.out.println(Arrays.toString(matrix[i]));
        }

        curSum = 1;
        curIncrement = 0;
        flag = false;

        for (int i = 3; i < 20; i++){
            matrix[i][2] = matrix[i - 1][2] + curIncrement + curSum;
            if (flag){
                curIncrement += 1;
                flag = false;
            }
            else
                flag = true;
            System.out.println(Arrays.toString(matrix[i]));
        }

        // System.out.println(Arrays.deepToString(matrix));
        while (col != 0 && maxNum != 0){
            System.out.println(matrix[col - 1][maxNum - 1]);
            col = scan.nextInt();
            maxNum = scan.nextInt();
        }
    }

}
