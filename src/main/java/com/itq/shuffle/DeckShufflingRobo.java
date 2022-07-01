package com.itq.shuffle;

public abstract class DeckShufflingRobo {
    //shuffle deck of 52 cards, pick 5 cards and sorts them. Static method
    private static String[] shuffledDeck;

    //constructor to construct shuffled deck
    public static void shuffleDeck(String[] deck){
        shuffledDeck = new String[52];
        for (int i=0; i< deck.length ; i++){
            int index = (int)(Math.random()*deck.length);
            String temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
            shuffledDeck[i] = deck[index];
        }
    }

    //method to be implemented
    public abstract void advancedShuffleDeck();

    //get shuffled deck
    public static String[] getShuffledDeck() {
        return shuffledDeck;
    }
}
