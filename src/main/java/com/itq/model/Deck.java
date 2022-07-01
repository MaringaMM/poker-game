package com.itq.model;

public class Deck {

    private static String[] deck = new String[52];

    //construct card deck using suits and ranks
    public static void createDeck(String[] suit, String[] rank) {
        deck = new String[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = rank[i % 13] + suit[i / 13];
        }
    }

    //get deck of cards
    public static final String[] getDeck() {
        return deck;
    }

}
