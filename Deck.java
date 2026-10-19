import java.util.Random;

public class Deck {
    
    private ArrayLog<Card> deck = new ArrayLog<Card>("Usable Cards");
    private ArrayLog<Card> discards = new ArrayLog<Card>("Discarded Cards");

    private final Random rand = new Random();

    public Deck() {
        
        for (int v = 2; v < 15; v++) {
            for (int s = 1; s < 5; s++) {
                
                Card c = new Card(v,s);

                deck.add(c);
            }
        }
        shuffle();
    }

    public int size() {
        return deck.size();
    }

    public boolean isFull() {
        return deck.size() == 52;
    }

    public boolean isEmpty() {
        return deck.size() == 0;
    }

    public void shuffle() {
        ArrayLog<Card> holder = new ArrayLog<Card>("Usable Cards");

        while (!deck.isEmpty()) {

            int index = rand.nextInt(deck.size());

            holder.add( deck.remove(index) );
        }

        deck = holder;
    }

    public void reset() {

        while (!discards.isEmpty()) {

            int index = rand.nextInt(discards.size());

            deck.add( discards.remove(index) );
        }
        shuffle();
    }

    public Card drawCard() {

        int index = rand.nextInt(deck.size());

        Card removed = deck.remove(index);
        discards.add(removed);

        return removed;
    }
}