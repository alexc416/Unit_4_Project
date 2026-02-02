import java.util.Arrays;

public class Hand {
    private String[] cards;
    private int bid;
    private int handType;

    Hand(String[] c, int b) {
        cards = c;
        bid = b;
        handType = 0;
    }

    public void findHandType(Hand a) {



    }

    public void printHand() {
        System.out.println(Arrays.toString(cards) + "\n" + bid + " " + handType);
    }
}
