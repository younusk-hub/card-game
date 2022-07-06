package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CardGame {
    private static List<Card> deckOfCards = new ArrayList<>();

    static {
        initialiseDeckOfCards();
    }

    public static void initialiseDeckOfCards(){
        String suit = "none";
        String symbol = "none";

        for (int i = 1; i <= 4; i++) {
            if (i == 1) {
                // Hearts
                suit = "\u2665";
            } else if (i == 2) {
                // Spades
                suit = "\u2660";
            } else if (i == 3) {
                // Diamonds
                suit = "\u25C6";
            } else if (i == 4) {
                // Clubs
                suit = "\u2663";
            }
            for (int j = 2; j <= 14; j++) {
                if (j <= 10) {
                    symbol = String.valueOf(j);
                } else if (j == 11) {
                    symbol = "J";
                } else if (j == 12) {
                    symbol = "Q";
                } else if (j == 13) {
                    symbol = "K";
                } else if (j == 14) {
                    symbol = "A";
                }
                deckOfCards.add(new Card(suit, symbol, j));
            }
        }
    }

    public static List<Card> getDeckOfCards(){
        return deckOfCards;
    }

    public static void printDeckOfCards(){
        for (Card card : deckOfCards
             ) {
            System.out.println(card.toString());
        }
    }

    public static Card dealCard(){
        return deckOfCards.get(deckOfCards.size() - 1);
    }

    public static void sortDeckInNumberOrder(){
        deckOfCards = deckOfCards.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static void sortDeckIntoSuits(){
        deckOfCards.clear();
        initialiseDeckOfCards();
    }

    public static void shuffleDeck(){
        List shuffledDeck = new ArrayList<>();

        while (deckOfCards.size() != 0) {
            int randomCard = (int) (Math.random() * deckOfCards.size());
            System.out.println(randomCard);
            shuffledDeck.add(deckOfCards.get(randomCard));
            deckOfCards.remove(randomCard);
        }


        deckOfCards = shuffledDeck;
    }
}
