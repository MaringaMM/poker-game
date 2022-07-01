package com.itq.handstrength;

import java.util.Arrays;

public class HandStrengthCalculator {

    //algorithms sourced from Github. Refactored
    public void calculatePlayerRank(String[] sortedPlayerHand) {
        //print hand
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("Your Hand: " + Arrays.asList(sortedPlayerHand));

        //get sorted hand from deck initialisor and get cards;
        String boldenResult = "\u001B[1m";
        if (isRoyalFlush(sortedPlayerHand)) {
            System.out.println(boldenResult + "You have: Royal Flush!");
        } else if (isStraightFlush(sortedPlayerHand)) {
            System.out.println(boldenResult + "You have: Straight Flush!");
        } else if (isFourOfAKind(sortedPlayerHand)) {
            System.out.println(boldenResult + "Your have: Four of A Kind!");
        } else if (isFullHouse(sortedPlayerHand)) {
            System.out.println(boldenResult + "Your have: Full House!");
        } else if (isFlush(sortedPlayerHand)) {
            System.out.println(boldenResult + "Your have: Flush!");
        } else if (isStraight(sortedPlayerHand)) {
            System.out.println(boldenResult + "Your have: Straight!");
        } else if (isThreeOfAKind(sortedPlayerHand)) {
            System.out.println(boldenResult + "Your have: Three of A Kind!");
        } else if (isTwoPairs(sortedPlayerHand)) {
            System.out.println(boldenResult + "Your have: Two Pairs!");
        } else if (isAPair(sortedPlayerHand)) {
            System.out.println(boldenResult + "Your have: A Pair!");
        } else {
            System.out.println(boldenResult + "Your have: High Cards!");
        }

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }

        private boolean isRoyalFlush(String[] sortedPlayerHand) {
            Character card1 = sortedPlayerHand[0].charAt(0);
            Character card5 = sortedPlayerHand[4].charAt(0);

            if(card1 == 'A' && card5 == 'T') {
                return true;
            }
            return false;
        }

        private boolean isStraightFlush(String[] hand) {
            if (isStraight(hand) && isFlush(hand)) {
                return true;
            }
            return false;
        }

        private boolean isFourOfAKind(String[] sortedPlayerHand) {
            Character card1 = sortedPlayerHand[0].charAt(0);
            Character card2 = sortedPlayerHand[1].charAt(0);
            Character card4 = sortedPlayerHand[3].charAt(0);
            Character card5 = sortedPlayerHand[4].charAt(0);

            if((card1 == card4) || (card2 == card5)) {
                return true;
            }

            return false;
        }

        private boolean isFullHouse(String[] hand) {
            if (isThreeOfAKind(hand) && isAPair(hand)) {
                return true;
            }

            return false;
        }

        private boolean isFlush(String[] hand) {
            Character[] suiteArray = new Character[5];
            for(int i = 0; i<5; i++) {
                suiteArray[i] = hand[i].charAt(1);
            }

            Arrays.sort(suiteArray);

            if (suiteArray[0] == suiteArray[4]) {
                return true;
            }

            return false;
        }

        private boolean isStraight(String[] sortedPlayerHand) {
            Character card1 = sortedPlayerHand[0].charAt(0);
            Character card5 = sortedPlayerHand[4].charAt(0);
            if ((card5-card1 == 4) || (card1 == 'T' && card5 == 'A') || (card1 == 'Q' && card5 == '9') ||
                    (card1 == 'K' && card5 == '9') || (card1 == 'Q' && card5 == '8') || (card1 == 'J' && card5 == '7') ||
                    (card1 == 'T' && card5 == '6')) {
                return true;
            }
            return false;
        }

        private boolean isThreeOfAKind(String[] sortedPlayerHand) {
            Character card1 = sortedPlayerHand[0].charAt(0);
            Character card2 = sortedPlayerHand[1].charAt(0);
            Character card3 = sortedPlayerHand[2].charAt(0);
            Character card4 = sortedPlayerHand[3].charAt(0);
            Character card5 = sortedPlayerHand[4].charAt(0);

            if (card1 == card3 || card2 == card4 || card3 == card5) {
                return true;
            }

            return false;
        }

        private boolean isTwoPairs(String[] sortedPlayerHand) {
            Character card1 = sortedPlayerHand[0].charAt(0);
            Character card2 = sortedPlayerHand[1].charAt(0);
            Character card3 = sortedPlayerHand[2].charAt(0);
            Character card4 = sortedPlayerHand[3].charAt(0);
            Character card5 = sortedPlayerHand[4].charAt(0);

            if ((card1 == card2 && card3 == card4 && card2 != card3 && card4 != card5) ||
                    (card1 != card2 && card2 == card3 && card3 != card4 && card4 == card5)) {
                return true;
            }

            return false;
        }

        private boolean isAPair(String[] sortedPlayerHand) {
            Character card1 = sortedPlayerHand[0].charAt(0);
            Character card2 = sortedPlayerHand[1].charAt(0);
            Character card3 = sortedPlayerHand[2].charAt(0);
            Character card4 = sortedPlayerHand[3].charAt(0);
            Character card5 = sortedPlayerHand[4].charAt(0);

            if ((card1 == card2 && card2 != card3) || (card2 == card3 && card3 != card4 && card1 != card2) ||
                    (card3 == card4 && card4 != card5 && card2 != card3) ||
                    (card4 == card5 && card4 != card3)) {
                return true;
            }
            return false;
        }

        private int highestCard(String[] sortedPlayerHand) {
            Character high = sortedPlayerHand[4].charAt(0);

            char[] cardValues = new char[5];
            for(int i = 0; i<5; i++) {
                cardValues[i] = sortedPlayerHand[i].charAt(0);
            }

            if(new String(cardValues).indexOf('A') != -1) {
                return 14;
            } else if(new String(cardValues).indexOf('K') != -1) {
                return 13;
            } else if (new String(cardValues).indexOf('Q') != -1) {
                return 12;
            } else if (new String(cardValues).indexOf('J') != -1) {
                return 11;
            } else if (new String(cardValues).indexOf('T') != -1) {
                return 10;
            }
            return high;
        }

}
