package com.itq.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Deck Test")
public
class DeckTest {

    String[] suit = {"S", "D", "C", "H"};
    String[] deck = new String[52];
    String[] rank = {"2", "3", "4", "5","6","7","8","9","T", "J", "Q", "K", "A"};

    @DisplayName("Create Deck")
    @Test
    void createDeck() {
        deck = new String[52];
        System.out.println("=================================================================");
        System.out.println("***************** Show all cards in deck ************************");
        System.out.println("=================================================================");
        for (int i = 0; i < deck.length; i++) {
            deck[i] = rank[i % 13] + suit[i / 13];
            Assertions.assertFalse(deck[i].isEmpty());
        }
        Assertions.assertEquals(deck.length, 52);
        System.out.println(Arrays.toString(deck));
        System.out.println("=================================================================");
        System.out.println("Size of deck with all cards: " + deck.length);
        System.out.println("=================================================================");
    }

}