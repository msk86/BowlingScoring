package com.tw.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private static final int MAX_FRAME = 10;
    private static final int MAX_KNOCK = 10;
    private static final int MAX_THROWS = 2;

    int index;
    List<Roll> rolls = new ArrayList<>();

    public Frame(int index) {
        this.index = index;
    }

    public void attachRoll(Roll roll) {
        rolls.add(roll);
    }

    public int getScore(List<Roll> nextRolls) {
        if (isDone()) {
            int score = rolls.stream()
                    .mapToInt(Roll::getKnock)
                    .reduce(0, (total, knock) -> total + knock);
            if (isStrike()) {
                score += nextRolls.stream()
                        .limit(2)
                        .mapToInt(Roll::getKnock)
                        .reduce(0, (total, knock) -> total + knock);
            } else if (isSpare()) {
                score += nextRolls.stream()
                        .limit(1)
                        .mapToInt(Roll::getKnock)
                        .reduce(0, (total, knock) -> total + knock);
            }
            return score;
        }
        return 0;
    }

    public void attachRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }

    public boolean isStrike() {
        return !rolls.isEmpty() && rolls.get(0).getKnock() == MAX_KNOCK;
    }

    public boolean isSpare() {
        return rolls.size() == MAX_THROWS && rolls.get(0).getKnock() + rolls.get(1).getKnock() == MAX_KNOCK;
    }

    public boolean isDone() {
        return (isStrike() || rolls.size() == MAX_THROWS) && index < MAX_FRAME;
    }

    public int nextRollIndex() {
        Roll lastRoll = rolls.get(rolls.size() - 1);
        return lastRoll.index + 1;
    }
}
