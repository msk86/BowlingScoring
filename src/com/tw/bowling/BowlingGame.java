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

        List<Frame> frames = new ArrayList<>();
        while(!rolls.isEmpty()) {
            Frame frame = new Frame();
            frames.add(frame);
            frame.attachRoll(rolls.remove(0));
            if(!rolls.isEmpty()) {
                frame.attachRoll(rolls.remove(0));
            }
        }

        score = frames.stream()
                .mapToInt(Frame::getScore)
                .reduce(0, (total, knock) -> total + knock);
    }

    public int score() {
        return score;
    }
}
