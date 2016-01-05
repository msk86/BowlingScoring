package com.tw.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Frame {
    private static final int MAX_FRAME = 10;
    private static final int MAX_KNOCK = 10;
    private static final int MAX_THROWS = 2;
    private static final int STRIKE_BONUS_ROLLS = 2;
    private static final int SPARE_BONUS_ROLLS = 1;

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
            int score = totalScore(rolls.stream());
            if (isStrike()) {
                score += totalScore(nextRolls.stream().limit(STRIKE_BONUS_ROLLS));
            } else if (isSpare()) {
                score += totalScore(nextRolls.stream().limit(SPARE_BONUS_ROLLS));
            }
            return score;
        }
        return 0;
    }

    private int totalScore(Stream<Roll> rollStream) {
        return rollStream.mapToInt(Roll::getKnock)
                .reduce(0, (total, knock) -> total + knock);
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
