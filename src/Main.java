import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hand[] hands = new Hand[5];
        int i = 0;
        try {
            File f = new File("src/input");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] hand = line.split("\\|");
                String[] cards = hand[0].split(",");

                Hand h = new Hand(cards, Integer.parseInt(hand[1]));
                hands[i] = h;
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("error no file found...");
        }

        for (Hand h : hands) {
            h.printHand();
        }



    }
}