import java.util.*;

public class welcome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numPeople = scan.nextInt();
        while (numPeople != 0){
            HashMap<Character, Integer[]> firstLast = new HashMap<>();
            HashMap<Character, Integer[]> lastFirst = new HashMap<>();
            int[] firstCount = new int[26];
            int[] lastCount = new int[26];

            for (int i = 0; i < numPeople; i++){
                String tempFirstName = scan.next();
                String tempLastName = scan.next();
                Character firstChar = tempFirstName.charAt(0);
                Character lastChar = tempLastName.charAt(0);
                int firstNum = firstChar - 'A';
                int lastNum = firstChar - 'A';

                // Insert first names into reference list
                reference(firstLast, firstChar, lastNum);

                // Insert last names into reference list
                reference(lastFirst, lastChar, firstNum);
            }
            System.out.println(firstLast);
            System.out.println(lastFirst);

            numPeople = scan.nextInt();
        }
    }

    private static void reference(HashMap<Character, Integer[]> lastFirst, Character lastChar, int firstNum) {
        if (!lastFirst.containsKey(lastChar)){
            Integer[] newArray = new Integer[26];
            newArray[firstNum] = 1;
            lastFirst.put(lastChar, newArray);
        }
        else{
            Integer[] tempArray = lastFirst.get(lastChar);
            tempArray[firstNum]++;
            lastFirst.put(lastChar, tempArray);
        }
    }
}
