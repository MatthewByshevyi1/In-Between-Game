public class Card {

    // Value is equal to the number of the cards for 2-10
    // A jack is 11
    // A queen is 12
    // A king is 13
    // A king is 14
    private int value;
    
    // 0 is hearts
    // 1 is diamonds
    // 2 is spades
    // 3 is clubs
    private int suit;

    public Card(int v, int s) {
        if (v > 1) {
            value = v;
        } else {
            value = 2;
        }

        if (s > 1) {
            suit = s;
        } else {
            suit = 0;
        }
    }

    public int getValue() {
        return value;
    }

    public int getSuitVal() {
        return suit;
    }

    public String getName() {
        switch (value){
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            case 14:
                return "Ace";
        }

        return null;
    }

    public String getSuit() {

        return null;
    }

    public boolean isBetter(Card other) {
        return this.value > other.getValue();
    }
}