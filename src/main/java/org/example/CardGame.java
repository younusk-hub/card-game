package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public abstract class CardGame {
    private static List<Card> deckOfCards = new ArrayList<>();

    private final Scanner scanner;

    static {
        initialiseDeckOfCards();
    }

    protected CardGame() {
        this.scanner = new Scanner(System.in);
    }

    abstract public void run();

    public static void initialiseDeckOfCards(){
        String suit = "none";
        String symbol = "none";

        for (int i = 1; i <= 4; i++) {
            if (i == 1) {
                suit = "\u2665";    // Hearts
            } else if (i == 2) {
                suit = "\u2660";    // Spades
            } else if (i == 3) {
                suit = "\u25C6";    // Diamonds
            } else if (i == 4) {
                suit = "\u2663";    // Clubs
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

    public static void addCard(Card card){
        deckOfCards.add(card);
    }

    public static void removeCard(){
        deckOfCards.remove(deckOfCards.size() - 1);
    }

    public static void sortDeckInNumberOrder(){
        deckOfCards = deckOfCards.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static void sortDeckIntoSuits(){
        deckOfCards = deckOfCards.stream()
                .sorted()
                .sorted(Comparator.comparing(Card::getSuit))
                .collect(Collectors.toList());
    }

    public static void shuffleDeck(){
        List shuffledDeck = new ArrayList<>();

        while (deckOfCards.size() != 0) {
            int randomCard = (int) (Math.random() * deckOfCards.size());
            shuffledDeck.add(deckOfCards.get(randomCard));
            deckOfCards.remove(randomCard);
        }
        deckOfCards = shuffledDeck;
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

    public String userInput() {
        String userInput = "";
        String input = scanner.nextLine();

        if (input.length() != 0) {
            userInput = input;
        }
        return userInput;
    }

}
