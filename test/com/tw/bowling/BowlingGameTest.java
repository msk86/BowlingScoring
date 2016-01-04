package com.tw.bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {

    @Test
    public void it_counts_1_2_pins_as_3() {
        BowlingGame game = new BowlingGame();

        game.knock("1 2");

        assertThat(game.score(), is(3));
    }

    @Test
    public void it_counts_1_pin_as_0_because_the_frame_is_not_finished() {
        BowlingGame game = new BowlingGame();

        game.knock("1");

        assertThat(game.score(), is(0));
    }

    @Test
    public void it_counts_strike_as_10_if_not_further_roll() {
        BowlingGame game = new BowlingGame();

        game.knock("10");

        assertThat(game.score(), is(10));
    }

    @Test
    public void it_counts_strike_and_3_4_as_24() {
        BowlingGame game = new BowlingGame();

        game.knock("10 3 4");

        assertThat(game.score(), is(24));
    }

    @Test
    public void it_counts_spare_as_10_if_not_further_roll() {
        BowlingGame game = new BowlingGame();

        game.knock("2 8");

        assertThat(game.score(), is(10));
    }

    @Test
    public void it_counts_spare_and_3_as_16() {
        BowlingGame game = new BowlingGame();

        game.knock("2 8 3 2");

        assertThat(game.score(), is(18));
    }

    @Test
    public void it_counts_perfect_as_300() {
        BowlingGame game = new BowlingGame();

        game.knock("10 10 10 10 10 10 10 10 10 10 10 10");

        assertThat(game.score(), is(300));
    }
}
