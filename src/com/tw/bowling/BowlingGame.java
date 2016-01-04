package com.tw.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private int score;

    public void knock(String knockSequence) {
        List<Roll> rolls = new ArrayList<>();
        String[] knocks = knockSequence.split("\\s+");
        for(int i=0;i<knocks.length;i++) {
            rolls.add(new Roll(knocks[i], i));
        }
        score = rolls.stream()
                .mapToInt(Roll::getKnock)
                .reduce(0, (total, knock) -> total + knock);
    }

    public int score() {
        return score;
    }
}
