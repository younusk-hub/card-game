package org.example;

public class Player {
    private String name;

    private int score;

    private int player;

    public Player(String name, int player) {
        this.name = name;
        this.score = 0;
        this.player = player;

    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getTurn(){
        return "It's " + getName() + "'s turn!";
    }

    public String getWin(){
        return "Congrats " + getName() + "!! You win!!\n";
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore() {
        setScore(this.score + 1);
    }

    public String displayScore(){
        return getName() + "'s score: " + getScore();
    }



}
