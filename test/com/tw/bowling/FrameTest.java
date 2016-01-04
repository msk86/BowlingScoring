package com.tw.bowling;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FrameTest {

    @Test
    public void it_counts_score_for_2_rolls() {
        Frame frame = new Frame();
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll("1", 0));
        rolls.add(new Roll("2", 1));
        frame.attachRolls(rolls);

        assertThat(frame.getScore(), is(3));
    }

    @Test
    public void it_does_not_count_score_for_1_roll() {
        Frame frame = new Frame();
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll("1", 0));
        frame.attachRolls(rolls);

        assertThat(frame.getScore(), is(0));
    }
}
