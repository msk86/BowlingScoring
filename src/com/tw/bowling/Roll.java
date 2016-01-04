package com.tw.bowling;

public class Roll {
    int knock;
    int index;
    public Roll(String knock, int index) {
        this.knock = Integer.parseInt(knock);
        this.index = index;
    }

    public int getKnock() {
        return knock;
    }
}
