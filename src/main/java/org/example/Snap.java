package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Snap extends CardGame{
    private List<Card> visibleDeck = new ArrayList<>();

    @Override
    public void run() {
        printMessage("Welcome to snap!");
        printMessage("Player 1's name:");
        String playerOneName = userInput();
        Player playerOne = new Player(playerOneName);

        printMessage("Player 2's name:");
        String playerTwoName = userInput();
        Player playerTwo = new Player(playerTwoName);

        printMessage("Let's play! Ready?");
        userInput();
        shuffleDeck();
        boolean isActive = true;
        int count = 0;

        while (isActive) {

            if (getDeckOfCards().size() == 0) {
                printMessage("Game Over!!");
                isActive = false;
            } else {
                if (count % 2 == 0) {
                    printMessage(playerOne.getTurn());
                } else {
                    printMessage(playerTwo.getTurn());
                }
                visibleDeck.add(dealCard());
                removeCard();
                printMessage(visibleDeck.get(visibleDeck.size() - 1).toString());
                String userInput = userInput();

                if (userInput.length() == 1 && visibleDeck.size() > 1 && visibleDeck.get(visibleDeck.size() - 1).getValue() == visibleDeck.get(visibleDeck.size() - 2).getValue()) {
                    if (count % 2 == 0) {
                        printMessage(playerOne.getWin());
                        playerOne.incrementScore();
                    } else {
                        printMessage(playerTwo.getWin());
                        playerTwo.incrementScore();
                    }
                    isActive = false;

                } else if (userInput.length() == 1 ) {
                    printMessage("No match!");
                }
                count++;
            }
            if (!isActive) {
                printMessage(playerOne.displayScore());
                printMessage(playerTwo.displayScore());
                printMessage("Play again? (y / n)");
                String againInput = userInput();
                if (Objects.equals(againInput, "y")) {
                    isActive = true;
                    visibleDeck.forEach(card -> addCard(card));
                    visibleDeck.clear();
                    printMessage("Let's play! Ready?");
                    userInput();
                    shuffleDeck();
                }
            }
        }
    }
}
