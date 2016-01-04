package com.tw.bowling;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FrameTest {

    @Test
    public void it_counts_score_for_2_rolls() {
        Frame frame = new Frame();
        frame.attachRoll(new Roll("1", 0));
        frame.attachRoll(new Roll("2", 1));

        assertThat(frame.getScore(), is(3));
    }

    @Test
    public void it_does_not_count_score_for_1_roll() {
        Frame frame = new Frame();
        frame.attachRoll(new Roll("1", 0));

        assertThat(frame.getScore(), is(0));
    }
}
