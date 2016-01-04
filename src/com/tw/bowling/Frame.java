package com.tw.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
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

    public int getScore(List<Roll> nextTwoRolls) {
        if (isDone()) {
            if (isStrike()) {
                if (nextTwoRolls.size() == 2) {
                    return 10 + nextTwoRolls.stream()
                            .mapToInt(Roll::getKnock)
                            .reduce(0, (total, knock) -> total + knock);
                }
            } else {
                return rolls.stream()
                        .mapToInt(Roll::getKnock)
                        .reduce(0, (total, knock) -> total + knock);
            }
        }
        return 0;
    }

    public void attachRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }

    public boolean isStrike() {
        return !rolls.isEmpty() && rolls.get(0).getKnock() == MAX_KNOCK;
    }

    public boolean isDone() {
        return isStrike() || rolls.size() == MAX_THROWS;
    }

    public int nextRollIndex() {
        Roll lastRoll = rolls.get(rolls.size() - 1);
        return lastRoll.index + 1;
    }
}
