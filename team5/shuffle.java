import java.util.*;

public class shuffle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCards = input.nextInt();
//        ArrayList<String> deck1 = new ArrayList<>();
//        ArrayList<String> deck2 = new ArrayList<>();
//        int deck1size = 0;
////        int deck2size = 0;
//        int half = numCards/2;
//        if (numCards%2 != 0)
//            half++;

        while(numCards != 0)
        {
            ArrayList<String> deck1 = new ArrayList<>();
            ArrayList<String> deck2 = new ArrayList<>();
            int deck1size = 0;
//        int deck2size = 0;
            int half = numCards/2;
            if (numCards%2 != 0)
                half++;

            for (int i = 0; i < numCards; i++)
            {
                if (deck1size < half)
                {
                    deck1.add(input.next());
                    deck1size++;
                }
                else
                {
                    deck2.add(input.next());
                }
            }

            for (int i = 0; i < deck2.size(); i++)
            {
                System.out.println(deck1.get(i));
                System.out.println(deck2.get(i));
            }
            if (numCards%2 != 0)
                System.out.println(deck1.get(deck1.size() - 1));


            numCards = input.nextInt();
        }

    }
}
