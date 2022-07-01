package com.itq;

import com.itq.handstrength.HandStrengthCalculator;
import com.itq.model.Deck;
import com.itq.player.Player;
import com.itq.shuffle.DeckShufflingRobo;
import com.itq.sort.HandSorterRobo;
import com.itq.util.DeckUtil;

public class PokerPlayer {
    public static void main(String[] args) {

        //create deck
         Deck.createDeck(DeckUtil.getSuit(), DeckUtil.getRank());

        //shuffle deck
         DeckShufflingRobo.shuffleDeck(Deck.getDeck());

        //deal player hand from shuffled deck
        Player.dealPlayerHand(DeckShufflingRobo.getShuffledDeck());

        //sort player hand
        HandSorterRobo sortPlayerHand = new HandSorterRobo(Player.getPlayerHand());

        //determine result
        HandStrengthCalculator calculator = new HandStrengthCalculator();
        calculator.calculatePlayerRank(sortPlayerHand.getPlayerHandToSort());
    }
}