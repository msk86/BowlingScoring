package com.tw.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    List<Roll> rolls = new ArrayList<>();

    private void attachRoll(Roll roll) {
        if (roll != null) {
            rolls.add(roll);
        }
    }

    public int getScore() {
        if (rolls.size() == 2) {
            return rolls.stream()
                    .mapToInt(Roll::getKnock)
                    .reduce(0, (total, knock) -> total + knock);
        } else {
            return 0;
        }
    }

    public void attachRolls(List<Roll> rolls) {
        if (!rolls.isEmpty()) {
            attachRoll(rolls.remove(0));
        }
        if (!rolls.isEmpty()) {
            attachRoll(rolls.remove(0));
        }
    }
}
