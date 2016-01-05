package com.tw.bowling;

public class Main {
    public static void main(String[] args) {
        BowlingGame game = new BowlingGame();
        game.knock(args[0]);
        System.out.println("Total Score is: " + game.score());
    }
}
