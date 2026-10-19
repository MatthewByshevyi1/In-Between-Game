public class Card {

    // Value is equal to the number of the cards for 2-10
    // A jack is 11
    // A queen is 12
    // A king is 13
    // A king is 14
    private int value;
    private String valueSymbol;
    
    // 1 is hearts
    // 2 is diamonds
    // 3 is spades
    // 4 is clubs
    private int suit;
    private String suitSymbol;

    // Assigns values to the card
    // If incorrect values provided:
    // - value set to 1
    // - suit set to 0
    public Card(int v, int s) {
        if (v < 15 && v > 1) {
            value = v;
        } else {
            value = 1;
        }

        if (value > 1 && value < 10) {
            valueSymbol = "" + value;
        }
        else {
            switch (value) {
                case 10:
                    valueSymbol = "T";
                    break;
                case 11:
                    valueSymbol = "J";
                    break;
                case 12:
                    valueSymbol = "Q";
                    break;
                case 13:
                    valueSymbol = "K";
                    break;
                case 14:
                    valueSymbol = "A";
                    break;
                default:
                    valueSymbol = "?";
            }
        }

        if (s < 5 && s > 0) {
            suit = s;
        } else {
            suit = 0;
        }

        switch (suit) {
            case 1: 
                suitSymbol = "♥";
                break;
            case 2:
                suitSymbol = "♦";
                break;
            case 3:
                suitSymbol = "♠";
                break;
            case 4:
                suitSymbol = "♣";
                break;
            default:
                suitSymbol = "?";
        }
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }

    // Returns the value as a String representation   
    public String getValueString() {
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

    // Returns the suit as a String representation
    public String getSuitString() {
        switch (suit) {
            case 1: 
                return "Hearts";
            case 2:
                return "Diamonds";
            case 3: 
                return "Spades";
            case 4:
                return "Clubs";
        }

        return null;
    }

    // Returns a string representation that can be printed
    public String toString() {
        String cardString = "----- \n" + 
                            "|" + suitSymbol + "  | \n" +
                            "| " + valueSymbol + " | \n" +
                            "|  " + suitSymbol + "| \n" +
                            "-----\n";
        return cardString;
    }

    // Returns an ArrayLog<String> that contains String representation of the Card
    public ArrayLog<String> toStringArrayLog() {

        ArrayLog<String> cardString = new ArrayLog<String>("Card String");

        cardString.add("----- ");
        cardString.add("|" + suitSymbol + "  | ");
        cardString.add("| " + valueSymbol + " | ");
        cardString.add("|  " + suitSymbol + "| ");
        cardString.add("----- ");

        return cardString;
    }

    // Returns a boolean based on if the Card for which this method is called 
    // has a greater value than the other card 
    // (If cards have the same value returns false)
    public boolean isBigger(Card other) {
        return this.value > other.getValue();
    }

    public boolean isSame(Card other) {
        return this.value == other.getValue();
    }
}
