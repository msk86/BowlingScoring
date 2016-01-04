package com.tw.bowling;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FrameTest {

    @Test
    public void it_counts_score_for_2_rolls() {
        Frame frame = new Frame(0);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll("1", 0));
        rolls.add(new Roll("2", 1));
        frame.attachRolls(rolls);

        assertThat(frame.getScore(new ArrayList<>()), is(3));
    }

    @Test
    public void it_does_not_count_score_for_1_roll() {
        Frame frame = new Frame(0);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll("1", 0));
        frame.attachRolls(rolls);

        assertThat(frame.getScore(new ArrayList<>()), is(0));
    }

    @Test
    public void it_supports_strike() {
        Frame frame = new Frame(0);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll("10", 0));
        frame.attachRolls(rolls);

        assertTrue(frame.isStrike());
    }

    @Test
    public void it_is_not_ready_when_throw_1_rolls() {
        Frame frame = new Frame(0);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll("1", 0));
        frame.attachRolls(rolls);

        assertFalse(frame.isDone());
    }

    @Test
    public void it_is_ready_when_throw_2_rolls() {
        Frame frame = new Frame(0);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll("1", 0));
        rolls.add(new Roll("2", 0));
        frame.attachRolls(rolls);

        assertTrue(frame.isDone());
    }

    @Test
    public void it_is_ready_when_strike() {
        Frame frame = new Frame(0);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll("10", 0));
        frame.attachRolls(rolls);

        assertTrue(frame.isDone());
    }

    @Test
    public void it_is_not_ready_when_throw_additional_roll() {
        Frame frame = new Frame(10);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll("10", 0));
        frame.attachRolls(rolls);

        assertFalse(frame.isDone());
    }

    @Test
    public void it_is_support_spare() {
        Frame frame = new Frame(0);
        List<Roll> rolls = new ArrayList<>();
        rolls.add(new Roll("2", 0));
        rolls.add(new Roll("8", 0));
        frame.attachRolls(rolls);

        assertTrue(frame.isSpare());
    }
}
