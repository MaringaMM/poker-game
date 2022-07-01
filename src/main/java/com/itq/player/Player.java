package com.itq.player;

public class Player {

    private static String[] playerHand;

    //construct player hand
    public static void dealPlayerHand(String[] shuffledDeck){
        int handSize= 5;
        playerHand = new String[5];
        for(int i=0; i< handSize; i++){
            playerHand[i] = shuffledDeck[i];
        }
    }

    //get player hand
    public static String[] getPlayerHand() {
        return playerHand;
    }
}
