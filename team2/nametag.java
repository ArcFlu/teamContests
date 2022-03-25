import java.util.*;

public class nametag {
    public static char[] cut (String s, int index) {
        char[] arr = new char[s.length()];
        for (int j = 0; j < s.length(); j++) {
            arr[j] = s.charAt((index + j) % s.length());
        }
        return arr;
    }

    public static boolean compareString (char[] s1, char[] s2) {
        for (int i = 0; i < s1.length; i++)
        {
            if (s1[i] < s2[i])
                return true;
            else if (s1[i] > s2[i])
                return false;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numCases = input.nextInt();

        for (int i = 0; i < numCases; i++) {
            String s = input.next();
            int lowestIndex = 0;
            int lowestAlpha = 300;
            int length = s.length();
            char[] newString = new char[length];

            for (int j = 0; j < length; j++) {
                if (s.charAt(j) - 97 < lowestAlpha) {
                    lowestAlpha = s.charAt(j) - 97;
                    lowestIndex = j;
                    newString = cut(s, lowestIndex);
                }
                else if (s.charAt(j) - 97 == lowestAlpha) {
                    char[] tempArr = cut(s, j);
                    if (compareString(tempArr, newString)) {
                        newString = tempArr;
                    }
                }
            }

//            for (int j = 0; j < length; j++) {
//                if ((s.charAt(j) - 97) < lowestAlpha) {
//                    lowestIndex = j;
//                    lowestAlpha = s.charAt(j) - 97;
//                }
//                else if ((s.charAt(j) - 97) == lowestAlpha) {
//                    if (j + 1 < length) {
//                        if (s.charAt(j+1) - 97 < s.charAt(lowestIndex + 1) - 97) {
//                            lowestIndex = j;
//                            lowestAlpha = s.charAt(j) - 97;
//                        }
//                    }
//                    else if (lowestIndex + 1 < length) {
//                        if (s.charAt(0) < s.charAt(lowestIndex + 1)) {
//                            lowestIndex = j;
//                            lowestAlpha = s.charAt(j) - 97;
//                        }
//                    }
//                }
//            }

            if (lowestAlpha == 300) {
                System.out.println(s);
                continue;
            }

            for (int j = 0; j < length; j++) {
                System.out.print(newString[j]);
            }
            System.out.println();
        }
    }
}
