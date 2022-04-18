import java.util.*;

public class letters {
    public static int maxScore;
    public static int maxPossibleTilesScore;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int n = 0; n < numCases; n++){
            maxPossibleTilesScore = 0;
            int numTiles = scan.nextInt();
            HashMap<Character, ArrayList<Integer>> tilesLeft = new HashMap<>();
            for (int i = 0; i < numTiles; i++){
                Character curChar = scan.next().charAt(0);
                int curCharScore = scan.nextInt();
                maxPossibleTilesScore += curCharScore;
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
            recursion(tilesLeft, wordsList, 0, maxPossibleTilesScore);

            System.out.println(maxScore);
        }
    }

    public static void recursion(HashMap<Character, ArrayList<Integer>> tilesLeft, ArrayList<String> wordsList, int totalScore, int curMaxTileScore){
        HashMap<Character, ArrayList<Integer>> bruh = new HashMap<>(tilesLeft);

        for (int i = 0; i < wordsList.size(); i++){
            String curWord = wordsList.get(i);
            int curScore = 0;
            ArrayList<Character> storedCharacters = new ArrayList<>();
            ArrayList<Integer> storedScore = new ArrayList<>();
            int tempSubScore = 0;

            for (int j = 0; j < curWord.length(); j++){
                Character curChar = curWord.charAt(j);
                if (tilesLeft.containsKey(curChar)){
                    ArrayList<Integer> tempList = tilesLeft.get(curChar);
                    if (tempList.isEmpty()){
                        curScore = -1;
                        break;
                    }

                    int tileScore = tempList.remove(0);

                    curScore += tileScore;


                    tempSubScore += tileScore;
                    tilesLeft.put(curChar, tempList);
                    storedCharacters.add(curChar);
                    storedScore.add(tileScore);
                }
                else{
                    curScore = -1;
                    break;
                }
            }

            if (curScore == -1){
                // reset then continue in loop
                int m = 0;
                for (Character tile : storedCharacters){
                    ArrayList<Integer> tempList = tilesLeft.get(tile);
                    tempList.add(storedScore.get(m++));
                    tempList.sort(Collections.reverseOrder());
                    tilesLeft.put(tile, tempList);
                }
//                totalScore -= curScore;
//                curMaxTileScore += curScore;
            }
            else {
                curMaxTileScore -= tempSubScore;
                totalScore += curScore;
                maxScore = Math.max(maxScore,  totalScore - curMaxTileScore);
                recursion(tilesLeft, wordsList, totalScore, curMaxTileScore);
                // reset then continue in loop
                int m = 0;
                for (Character tile : storedCharacters){
                    ArrayList<Integer> tempList = tilesLeft.get(tile);
                    tempList.add(storedScore.get(m++));
                    tempList.sort(Collections.reverseOrder());
                    tilesLeft.put(tile, tempList);
                }

                curMaxTileScore += tempSubScore;
                totalScore -= curScore;
            }

        }
    }

}
