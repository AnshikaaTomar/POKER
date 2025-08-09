package POKER;
import java.util.*;

enum SUIT {
    CLUB, DIAMOND, HEART, SPADE;

    public char getImage() {
        return (new char[] { 'C', 'D', 'H', 'S' })[this.ordinal()];
    }
}

// face - Jack, Queen, King, Ace
// rank - 2 to 10

public class Card {

    private SUIT suit;
    private String face;
    private int rank;

    public Card(SUIT suit, String face, int rank) {
        this.suit = suit;
        this.face = face;
        this.rank = rank;
    }

    public static Comparator<Card> sortRankReversedSuit(){
        return Comparator.comparing(Card::getRank).reversed().thenComparing(Card::getSuit);
    }

    @Override
    public String toString() {
        int idx = face.equals("10") ? 2 : 1;
        String faceName = face.substring(0, idx);
        return "%s %c(%d)".formatted(faceName, suit.getImage(), rank);
    }

    // assisting methods
    public static Card getNumericCard(SUIT suit, int cardNum) {
        if(cardNum > 1 && cardNum <11){
            return new Card(suit, String.valueOf(cardNum), cardNum -2);
        }
        System.out.println("Invalid card description!");
        return null;
    }

    public static Card getFaceCard(SUIT suit, char abb) {
        return  switch (abb) {
            case 'J' -> new Card(suit, String.valueOf(abb), 9);
            case 'Q' -> new Card(suit, String.valueOf(abb), 10);
            case 'K' -> new Card(suit, String.valueOf(abb), 11);
            case 'A' -> new Card(suit, String.valueOf(abb), 12);
            default-> null;
        };
    }

    public static List<Card> getStdDeck() {
        List<Card> deck = new ArrayList<>(52);
        for (SUIT suits : SUIT.values()) {
            //Numeric Cards
            for(int i = 2; i <=10; i++){
                deck.add(getNumericCard(suits, i));
            }
            //Face Cards
            for(char c : new char[]{'J','Q','K','A'}){
                deck.add(getFaceCard(suits, c));
            }
        }
        return deck;
    }

    public static void printDeck(List<Card> cards, String descp, int rowCount) {
        System.out.println("-".repeat(120));
        //print the provided description
        if(descp != null){
            System.out.println(descp);
        }
        int cardInRow = cards.size()/rowCount;
        for(int i = 0; i <rowCount; i++){
            int strt = i * cardInRow;
            int end = strt + cardInRow;
            cards.subList(strt, end).forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }

    // print in 4 rows
    public static void printDeck(List<Card> cards) {
        printDeck(cards, "Current Deck", 4);
    }

    // Getter methods for sorting
    public SUIT getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public String getFace(){
        return face;
    }
}
