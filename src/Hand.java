import java.util.Arrays;

public class Hand {
    private String[] cards;
    private int bid;
    private int handType;
    private int[] listOfAmounts;

    Hand(String[] c, int b) {
        cards = c;
        bid = b;
        handType = 0;
    }

    public void printHand() {
        System.out.println(Arrays.toString(cards) + "\n" + bid + " " + handType);
    }

    public String[] getCards() {
        return cards;
    }

    public void setHandType(int e) {
        handType = e;
    }
    public void setListOfAmounts(int[] in) {
        listOfAmounts = in;
    }

    public boolean isFiveOfKind() {
        for (int a : listOfAmounts) {
            if (a == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean isFourOfKind() {
        for (int a : listOfAmounts) {
            if (a == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean isFullHouse() {
        boolean hasThree = false;
        boolean hasPair = false;
        for (int a : listOfAmounts) {
            if (a == 3) {
                hasThree = true;
            }
            if (a == 2) {
                hasPair = true;
            }
        }
        if (hasThree && hasPair) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isThreeOfKind() {
        for (int a : listOfAmounts) {
            if (a == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isTwoPair() {
        int numOfPairs = 0;
        for (int a : listOfAmounts) {
            if (a == 2) {
                numOfPairs += 1;
            }
        }
        if (numOfPairs == 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOnePair() {
        int numOfPairs = 0;
        for (int a : listOfAmounts) {
            if (a == 2) {
                numOfPairs += 1;
            }
        }
        if (numOfPairs == 1) {
            return true;
        } else {
            return false;
        }
    }
}
