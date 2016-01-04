package com.tw.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BowlingGame {
    private int score;

    public void knock(String knockSequence) {
        List<Roll> rolls = parseRolls(knockSequence);
        List<Frame> frames = parseFrames(rolls);

        score = frames.stream()
                .mapToInt(Frame::getScore)
                .reduce(0, (total, knock) -> total + knock);
    }

    private List<Roll> parseRolls(String knockSequence) {
        List<Roll> rolls = new ArrayList<>();
        String[] knocks = knockSequence.split("\\s+");
        for(int i=0;i<knocks.length;i++) {
            rolls.add(new Roll(knocks[i], i));
        }
        return rolls;
    }

    private List<Frame> parseFrames(List<Roll> rolls) {
        List<Frame> frames = new ArrayList<>();
        IntStream.range(0, 10).forEach(i->frames.add(new Frame()));

        for (Frame frame : frames) {
            if (!rolls.isEmpty()) {
                frame.attachRoll(rolls.remove(0));
            }
            if (!rolls.isEmpty()) {
                frame.attachRoll(rolls.remove(0));
            }
        }
        return frames;
    }

    public int score() {
        return score;
    }
}
