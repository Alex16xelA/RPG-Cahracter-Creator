package pl.wroc.pwr.a236139.rpgcharactercreator;

import java.util.Random;

class Dice {

    private final int walls;

    private final Random gen;

    public Dice(int mwalls) {
        walls = mwalls;
        this.gen = new Random();
    }

    public int roll() {
        return 1 + gen.nextInt(walls);
    }
}