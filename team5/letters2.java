import java.util.*;

public class letters2 {
    public static HashMap<Character, ArrayList<Integer>> tilesMap;
    public static ArrayList<String> wordsPossible;
    public static int[] scoreWords;
    public static ArrayList<HashMap<Character, ArrayList<Integer>>> savedMaps;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();

        for (int n = 0; n < numCases; n++){

            int numTiles = scan.nextInt();
            tilesMap = new HashMap<>();

            //tilesMap init, check for newLine error
            for (int i = 0; i < numTiles; i++){
                String curChar = scan.next();
                int curCharScore = scan.nextInt();

                Character thisChar = curChar.charAt(0);
                if (!tilesMap.containsKey(thisChar)){
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(curCharScore);
                    tilesMap.put(thisChar,tempList);
                }
                else{
                    ArrayList<Integer> tempList = tilesMap.get(thisChar);
                    tempList.add(curCharScore);
                    Collections.sort(tempList);
                    tilesMap.put(thisChar, tempList);
                }

                // consume nextLine if needed
            }

            int numWords = scan.nextInt();
            wordsPossible = new ArrayList<>();
            for (int i = 0; i < numWords; i++){
                wordsPossible.add(scan.next());
            }

            scoreWords = new int[numWords];



        }
    }

    public static int findScore(String curWord){
        HashMap<Character, ArrayList<Integer>> tempMap = new HashMap<>(tilesMap);
        int curScore = 0;
        for (int i = 0; i < curWord.length(); i++){
            char curChar = curWord.charAt(i);
            if (!tempMap.containsKey(curChar))
                return -1;
            else{
                ArrayList<Integer> curCharList = tempMap.get(curChar);
                if (curCharList.size() == 0)
                    return -1;

                curScore += curCharList.get(curCharList.size() - 1);
                curCharList.remove(curCharList.size() - 1);
            }
        }

        return curScore;
    }

}
