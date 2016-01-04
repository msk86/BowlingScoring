package com.tw.bowling;

public class BowlingGame {
    private int score;

    public void knock(String knockSequence) {
        String[] knocks = knockSequence.split("\\s+");
        for(String knock : knocks) {
            score += Integer.parseInt(knock);
        }
    }

    public int score() {
        return score;
    }
}
