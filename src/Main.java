import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int lines = 0;
        try {
            File ff = new File("src/input");
            Scanner ss = new Scanner(ff);
            while (ss.hasNextLine()) {
                ss.nextLine();
                lines += 1;
            }
        } catch (FileNotFoundException ee) {
            System.out.println("no file found");
        }

        Hand[] hands = new Hand[lines];

        int i = 0;

        //PARSER
        try {
            File f = new File("src/input");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] wholeHand = line.split("\\|");
                String[] cards = wholeHand[0].split(",");

                Hand h = new Hand(cards, Integer.parseInt(wholeHand[1]));
                hands[i] = h;
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("error no file found...");
        }

        //HAND IDENTIFIER
        for (Hand h : hands) {
            int[] cardAmounts = new int[13];
            for (String card : h.getCards()) {
                for (int k = 0; k < 14; k++) {
                    if (k == 1) {
                        if (card.equals("Ace")) {
                            cardAmounts[0] += 1;
                        }
                    } else if (k == 11) {
                        if (card.equals("Jack")) {
                            cardAmounts[10] += 1;
                        }
                    } else if (k == 12) {
                        if (card.equals("Queen")) {
                            cardAmounts[11] += 1;
                        }
                    } else if (k == 13) {
                        if (card.equals("King")) {
                            cardAmounts[12] += 1;
                        }
                    } else {
                        if (card.equals(k + "")) {
                            cardAmounts[k-1] += 1;
                        }
                    }
                }
            }
            h.setListOfAmounts(cardAmounts);
        }

        //PART 1
        int[] cardHands = new int[7];
        for (Hand h : hands) {
            //five, full house, hour, three, two, one, high

            if (h.isFiveOfKind()) {
                cardHands[0] += 1;
                h.setHandType(0);
            } else if (h.isFullHouse()) {
                cardHands[1] += 1;
                h.setHandType(1);
            } else if (h.isFourOfKind()) {
                cardHands[2] += 1;
                h.setHandType(2);
            } else if (h.isThreeOfKind()) {
                cardHands[3] += 1;
                h.setHandType(3);
            } else if (h.isTwoPair()) {
                cardHands[4] += 1;
                h.setHandType(4);
            } else if (h.isOnePair()) {
                cardHands[5] += 1;
                h.setHandType(5);
            } else {
                cardHands[6] += 1;
                h.setHandType(6);
            }
        }
        for (int c = 0; c < 7; c++) {
            String out = "";
            if (c == 0) {
                out += "Number of five of a kind hands: ";
            } else if (c == 1) {
                out += "Number of full house hands: ";
            } else if (c == 2) {
                out += "Number of four of a kind hands: ";
            } else if (c == 3) {
                out += "Number of three of a kind hands: ";
            } else if (c == 4) {
                out += "Number of two pair hands: ";
            } else if (c == 5) {
                out += "Number of one pair hands: ";
            } else {
                out += "Number of high card: ";
            }
            System.out.println(out + cardHands[c]);
        }

        //PART 2



        int rank = 1;
        int totBid = 0;

    }
}