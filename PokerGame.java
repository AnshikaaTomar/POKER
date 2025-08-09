package POKER;
import java.util.*;
import java.util.function.*;

public class PokerGame {

    private final List<Card> deck = Card.getStdDeck();
    private int noOfPlayers;
    private int cardInHand;

    private List<Poker> pokerHands;
    private List<Card> remains;


    public PokerGame(int noOfPlayers, int cardInHand) {
        this.noOfPlayers = noOfPlayers;
        this.cardInHand = cardInHand;
        pokerHands = new ArrayList<>(cardInHand);
    }


    public void startPlay(){
        Collections.shuffle(deck);
        Card.printDeck(deck);
        int randomMid = new Random().nextInt(17,32);
        Collections.rotate(deck, randomMid);
        Card.printDeck(deck);

        deal();
        System.out.println("-".repeat(100));
        Consumer<Poker> checkHand = Poker::evaluateHand;
        pokerHands.forEach(checkHand.andThen(System.out::println));

        int cardsDealt = noOfPlayers * cardInHand;
        int remaining = deck.size() - cardsDealt;

        remains = new ArrayList<>(Collections.nCopies(remaining, null));
        remains.replaceAll(c -> deck.get(cardsDealt + remains.indexOf(c)));
        Card.printDeck(remains, "Remaining cards", 3);
    }


    private void deal(){
        Card[][] hands = new Card[noOfPlayers][cardInHand];
        int deckIdx = 0;
        for(int i = 0; i < cardInHand; i++){
            for(int j = 0; j < noOfPlayers; j++){
                hands[j][i] = deck.get(deckIdx++);
            }
        }

        int playerId = 1;
        for(Card[] hand : hands){
            pokerHands.add(new Poker(Arrays.asList(hand), playerId++));
        }
    }
}
