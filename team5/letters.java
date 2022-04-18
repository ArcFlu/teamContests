import java.util.*;

public class letters {
    public static int maxScore;
    public static int maxPossibleTilesScore;
    public static int[] totalFrequency;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n < numCases; n++){
            maxPossibleTilesScore = 0;
            int numTiles = scan.nextInt();
            HashMap<Character, ArrayList<Integer>> tilesLeft = new HashMap<>();
            totalFrequency = new int[26];

            for (int i = 0; i < numTiles; i++){
                Character curChar = scan.next().charAt(0);
                int curCharScore = scan.nextInt();
                maxPossibleTilesScore += curCharScore;

                totalFrequency[curChar - 'a'] += 1;

                if (!tilesLeft.containsKey(curChar)) {
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(curCharScore);
                    tilesLeft.put(curChar, tempList);
                }
                else {
                    ArrayList<Integer> tempList = tilesLeft.get(curChar);
                    tempList.add(curCharScore);
                    Collections.sort(tempList);
                    Collections.reverse(tempList);
                    tilesLeft.put(curChar, tempList);
                }
            }

            int numWords = scan.nextInt();
            ArrayList<String> wordsList = new ArrayList<>();
            for (int i = 0; i < numWords; i++){
                wordsList.add(scan.next());
            }

            maxScore -= maxPossibleTilesScore;

            recursion(tilesLeft, wordsList, 0, maxPossibleTilesScore, totalFrequency);

            System.out.println(maxScore);
        }
    }

    public static void recursion(HashMap<Character, ArrayList<Integer>> tilesLeft, ArrayList<String> wordsList, int totalScore, int curMaxTileScore, int[] bruhFrequency){
        HashMap<Character, ArrayList<Integer>> bruh = new HashMap<>(tilesLeft);

        for (int i = 0; i < wordsList.size(); i++){
            String curWord = wordsList.get(i);
            int curScore = 0;
            ArrayList<Character> storedCharacters = new ArrayList<>();
            ArrayList<Integer> storedScore = new ArrayList<>();
            int tempSubScore = 0;

            int[] curFrequency = new int[26];
            for (int j = 0; j < curWord.length(); j++){
                char curChar = curWord.charAt(j);
                curFrequency[curChar - 'a'] += 1;
            }

            boolean flag = false;
            for (int j = 0; j < 26; j++){
                if (curFrequency[j] > bruhFrequency[j]){
                    flag = true;
                    break;
                }
            }

            if (flag)
                continue;

            for (int j = 0; j < 26; j++){
                bruhFrequency[j] -= curFrequency[j];
            }

            for (int j = 0; j < 26; j++){
                char curChar = (char) (j + 'a');
                for (int k = 0; k < curFrequency[curChar - 'a']; k++) {
                    ArrayList<Integer> tempList = tilesLeft.get(curChar);
                    int tileScore = tempList.remove(0);
                    curScore += tileScore;
                    tempSubScore += tileScore;
                    tilesLeft.put(curChar, tempList);
                    storedCharacters.add(curChar);
                    storedScore.add(tileScore);
                }
            }

            curMaxTileScore -= tempSubScore;
            totalScore += curScore;
            maxScore = Math.max(maxScore,  totalScore - curMaxTileScore);
            recursion(tilesLeft, wordsList, totalScore, curMaxTileScore, bruhFrequency);

            // reset then continue in loop
            curMaxTileScore += tempSubScore;
            totalScore -= curScore;

            int m = 0;
            for (Character tile : storedCharacters){
                ArrayList<Integer> tempList = tilesLeft.get(tile);
                tempList.add(storedScore.get(m++));
                tempList.sort(Collections.reverseOrder());
                tilesLeft.put(tile, tempList);
            }
            for (int j = 0; j < 26; j++){
                bruhFrequency[j] += curFrequency[j];
            }

        }
    }

}
