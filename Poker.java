package POKER;
import java.util.*;
import java.util.function.*;

import Ranking;

public class Poker {

    private List<Card> hand;
    private List<Card> keep;
    private List<Card> trade;
    private Ranking score = Ranking.NONE;
    private int playerId;


    public Poker(List<Card> hand, int playedID) {
        hand.sort(Card.sortRankReversedSuit());
        this.hand = hand;
        this.playerId = playedID;
        keep = new ArrayList<>(hand.size());
        trade = new ArrayList<>(hand.size());
    }


    @Override
    public String toString() {
        return "%d: %-16s Rank- %d %-40s Best:%-7s Worst:%-6s %s".formatted(playerId, score, score.ordinal(), hand,
        Collections.max(hand, Comparator.comparing(Card::getRank)),
        Collections.min(hand, Comparator.comparing(Card::getRank)),
        (trade.size() > 0 ? "Discards-" + trade : ""));
    }

    private void setrank(int faceCount){
        switch(faceCount){
            case 4 -> score = Ranking.FOUR_OF_A_KIND;
            case 3 -> {
                if (score == Ranking.NONE) score = Ranking.ONE_PAIR;
                else score = Ranking.FULL_HOUSE;
            }
            case 2 -> {
                if (score == Ranking.NONE) score = Ranking.ONE_PAIR;
                else if (score == Ranking.THREE_OF_A_KIND) score = Ranking.FULL_HOUSE;
                else score = Ranking.TWO_PAIR;
            }

        }
    }

    public void evaluateHand(){
       List<String> faceList = new ArrayList<>(hand.size());
       hand.forEach(c -> faceList.add(c.getFace())); 

       List<String> dupFaceCards = new ArrayList<>();
       faceList.forEach(face -> {
           if (!dupFaceCards.contains(face) && Collections.frequency(faceList, face) > 1) {
               dupFaceCards.add(face);
           }
       });

       for(String duplicate : dupFaceCards){
           int strt = faceList.indexOf(duplicate);
           int end = faceList.lastIndexOf(duplicate);

           setrank(end - strt + 1);
           List<Card> sub = hand.subList(strt, end + 1);
           keep.addAll(sub);
       }

       pickDiscards();
    }

    private void pickDiscards(){
        List<Card> temp = new ArrayList<>(hand);
        temp.removeAll(keep);
        int rankedCards = keep.size();
        Collections.reverse(temp);

        int idx = 0;
        for (Card c : temp){
            if (idx ++ < 3 && (rankedCards > 2 || c.getRank() < 9)) trade.add(c);
            else keep.add(c);
        }
    }
}
