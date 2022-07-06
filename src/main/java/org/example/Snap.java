package org.example;

import java.util.ArrayList;
import java.util.List;

public class Snap extends CardGame{
    private List<Card> visibleDeck = new ArrayList<>();

    @Override
    public void run() {
        printMessage("Welcome to snap!");
        printMessage("Let's play!");
        userInput();
        shuffleDeck();
        boolean isActive = true;

        while (isActive) {
            if (getDeckOfCards().size() == 0) {
                printMessage("Game Over!!");
                isActive = false;
            } else {
                visibleDeck.add(dealCard());
                removeCard();
                printMessage(visibleDeck.get(visibleDeck.size() - 1).toString());
                String userInput = userInput();

                if (userInput.length() == 1 && visibleDeck.get(visibleDeck.size() - 1).getValue() == visibleDeck.get(visibleDeck.size() - 2).getValue()) {
                    printMessage("Congrats you win!!");
                    isActive = false;
                } else if (userInput.length() == 1) {
                    printMessage("No match!");
                }
            }

        }

    }
}
