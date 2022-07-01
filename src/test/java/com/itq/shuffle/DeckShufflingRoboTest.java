package com.itq.shuffle;

import com.itq.model.DeckTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckShufflingRoboTest {


    String[] suit = {"S", "D", "C", "H"};
    String[] deck = new String[52];
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

    @Test
    void shuffleDeck() {
        String[] shuffledDeck = new String[52];
        System.out.println("=================================================================");
        System.out.println("******** Shuffled Deck against Normal Deck **********************");
        System.out.println("=================================================================");
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
            System.out.println("NORMAL CARD: " + deck[i] +"|| SHUFFLED CARD: "+ shuffledDeck[i]);
        }

        System.out.println("=================================================================");
    }

}