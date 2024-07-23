import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
    
    private ArrayList<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.cards.add(card);
    }
    
    public void print() {
        cards.stream().forEach(c -> System.out.println(c.toString()));
    }
    
    public void sort() {
        this.cards.stream().sorted((c1, c2) -> {
            if (c1.getValue() == c2.getValue()) {
                return c1.getSuit().ordinal() - c2.getSuit().ordinal();
            }
            return c1.getValue() - c2.getValue();
        }).forEach(c -> System.out.println(c.toString()));
    }
    
    public void sortBySuit() {
        Collections.sort(this.cards, new BySuitInValueOrder());
    }
   
    @Override
    public int compareTo(Hand hand) {
        int mySum = 0;
        int handSum = 0;
        for (Card card : hand.cards) {
            handSum += card.getValue();
        }
        for (Card card : this.cards) {
            mySum += card.getValue();
        }
        return mySum - handSum;
    }
    
}
