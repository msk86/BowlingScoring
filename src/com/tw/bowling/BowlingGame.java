package com.tw.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private int score;

    public void knock(String knockSequence) {
        List<Roll> rolls = parseRolls(knockSequence);
        List<Frame> frames = parseFrames(rolls);
        score = calculateScore(frames, rolls);
    }

    private int calculateScore(List<Frame> frames, List<Roll> rolls) {
        return frames.stream()
                .mapToInt(frame -> frame.getScore(Utils.subList(rolls, frame.nextRollIndex())))
                .reduce(0, (total, knock) -> total + knock);
    }

    private List<Roll> parseRolls(String knockSequence) {
        List<Roll> rolls = new ArrayList<>();
        String[] knocks = knockSequence.split("\\s+");
        for (int i = 0; i < knocks.length; i++) {
            rolls.add(new Roll(knocks[i], i));
        }
        return rolls;
    }

    private List<Frame> parseFrames(List<Roll> rolls) {
        List<Frame> frames = new ArrayList<>();
        int frameIndex = -1;
        Frame frame = null;
        for (Roll roll : rolls) {
            if(frame == null || frame.isDone()) {
                frameIndex ++;
                frame = new Frame(frameIndex);
                frames.add(frame);
            }
            frame.attachRoll(roll);
        }

        return frames;
    }

    public int score() {
        return score;
    }
}
