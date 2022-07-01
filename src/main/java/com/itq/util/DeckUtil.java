package com.itq.util;

public class DeckUtil {
    //Array of suits: C - CLUBS, H - HEARTS, S - SPADES, D - DIAMONDS
    private static String[] suit = {"S", "D", "C", "H"};
    //ranks
    private static String[] rank = {"2", "3", "4", "5","6","7","8","9","T", "J", "Q", "K", "A"};

    //get list of suit
    public static String[] getSuit(){
        return suit;
    }

    //get list of rank
    public static String[] getRank(){
        return rank;
    }


}
