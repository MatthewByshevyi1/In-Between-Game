import java.util.Scanner;

public class InBetweenGame {
    public static void main(String[] args) {
        
        Card unkownCard = new Card(-1,-1);

        int chips = 100;

        Deck deck = new Deck();

        Scanner sc = new Scanner(System.in);

        while (chips > 0) {
            if (deck.size() < 10) {
                deck.reset();
            }
            
            int numChips = 0;
            
            System.out.println("Current Chips: " + chips + "\n");

            System.out.println("How many chips would you like to bet?");
                
            while (numChips < 1 || numChips > chips) {

                while (!sc.hasNextInt()) {
                    String bad = sc.nextLine();
                    System.out.println("\nThis is not a number: " + bad);
                    System.out.println("How many chips would you like to bet?");
                }

                numChips = sc.nextInt();
                sc.nextLine();
                if (numChips < 1 || numChips > chips) {
                    System.out.println("\nPlease enter a valid amount of chips.");
                    System.out.println("How many chips would you like to bet?");
                }
            }

            chips -= numChips;

            Card one = deck.drawCard();
            Card two = deck.drawCard();

            ArrayLog<String> oneString = one.toStringArrayLog();
            ArrayLog<String> twoString = two.toStringArrayLog();
            ArrayLog<String> threeString = unkownCard.toStringArrayLog();

            String cards = oneString.get(0) + twoString.get(0) + threeString.get(0) + "\n" + 
                        oneString.get(1) + twoString.get(1) + threeString.get(1) + "\n" + 
                        oneString.get(2) + twoString.get(2) + threeString.get(2) + "\n" +
                        oneString.get(3) + twoString.get(3) + threeString.get(3) + "\n" +
                        oneString.get(4) + twoString.get(4) + threeString.get(4) + "\n";
            System.out.println(cards);

            if (one.isSame(two)) {
                System.out.println("The cards are of the same rank.");
                System.out.println("The round ends, and you win 2 chips.");

                chips += numChips + 2;

                System.out.println("\n----------------------------------------\n");
                continue;
            }

            if (numChips * 2 <= chips) {
                System.out.println("Do you want to double your bet? (y/n)");

                String answer = sc.nextLine().toLowerCase().trim();

                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                    chips -= numChips;
                    numChips *= 2;
                    System.out.println("\nBet doubled. You now have " + chips + " chips.\n");
                } else {
                    System.out.println("\nBet not doubled.\n");
                }
            }

            Card three = deck.drawCard();

            threeString = three.toStringArrayLog();

            cards = oneString.get(0) + twoString.get(0) + threeString.get(0) + "\n" + 
                        oneString.get(1) + twoString.get(1) + threeString.get(1) + "\n" + 
                        oneString.get(2) + twoString.get(2) + threeString.get(2) + "\n" +
                        oneString.get(3) + twoString.get(3) + threeString.get(3) + "\n" +
                        oneString.get(4) + twoString.get(4) + threeString.get(4) + "\n";
            System.out.println(cards);

            boolean win = (one.isBigger(three) && three.isBigger(two)) || (two.isBigger(three) && three.isBigger(one));

            if (win) {
                System.out.println("The " + three.getValueString() + " is in between the " + one.getValueString() + " and " + two.getValueString() + "!");
                
                chips += (numChips * 2);
                System.out.println("\nYou have won " + numChips + " chips this round, and now have " + chips + " chips.");
            }
            else {
                System.out.println("The " + three.getValueString() + " is not in between the " + one.getValueString() + " and " + two.getValueString() + "!");
                
                System.out.println("\nYou have lost " + numChips + " chips this round, and now have " + chips + " chips.");
            }

            System.out.println("\n----------------------------------------\n");
        }
        sc.close();
    }
}
