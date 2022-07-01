package com.itq.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HandSorterRoboTest {

    String[] suit = {"S", "D", "C", "H"};
    String[] deck = new String[52];
    String[] shuffledDeck = new String[5];

    String[] playerHand = new String[5];
    String[] rank = {"2", "3", "4", "5","6","7","8","9","T", "J", "Q", "K", "A"};

    @DisplayName("Create Deck")
    @BeforeEach
    void createDeck() {
        deck = new String[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = rank[i % 13] + suit[i / 13];
            Assertions.assertFalse(deck[i].isEmpty());
        }
    }


    void shuffleDeck() {
        shuffledDeck = new String[52];
        for (int i=0; i< deck.length ; i++){
            int index = (int)(Math.random()*deck.length);
            String temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
            shuffledDeck[i] = deck[index];
            //Assert if not equal. Looking for shuffled cards only
            if(shuffledDeck[i] != deck[i]){
                Assertions.assertFalse(shuffledDeck[i] == deck[i]);
            }
        }
    }


    void dealPlayerHand() {
        //createDeck();
        shuffleDeck();
        int handSize= 5;
        playerHand = new String[5];
        for(int i=0; i< handSize; i++){
            playerHand[i] = shuffledDeck[i];
            Assertions.assertFalse(playerHand[i].isEmpty());
        }

        Assertions.assertEquals(playerHand.length, 5);
        System.out.println("Cards held by Player size: " + playerHand.length);
    }

    @Test
    @DisplayName("Sort Player Hand")
    void getPlayerHandToSort() {
        shuffleDeck();
        dealPlayerHand();
        Arrays.sort(playerHand);
        System.out.println("***************** Sorted Player Hand ************************");
        System.out.println(Arrays.asList(playerHand));
    }
}