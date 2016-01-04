package com.tw.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    List<Roll> rolls = new ArrayList<>();

    public void attachRoll(Roll roll) {
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
}
