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
}
