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
}
