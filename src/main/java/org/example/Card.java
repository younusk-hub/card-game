package org.example;

import java.util.Comparator;

public class Card implements Comparable<Card> {

    private String suit;
    private String symbol;
    private int value;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString(){
        return String.format("Symbol: %s\nSuit: %s\nValue: %d\n", getSymbol(), getSuit(), getValue());
    }

    @Override
    public int compareTo(Card card) {
        return value - card.getValue();
    }

//    @Override      <----sortDeckInNumberOrder()
//    public int compare(Card c1, Card c2) {
//        return c1.getSuit().compareTo(c2.getSuit());
//    }

}
