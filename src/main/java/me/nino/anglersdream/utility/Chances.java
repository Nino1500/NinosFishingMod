package me.nino.anglersdream.utility;

import java.util.Random;

public class Chances {

    public static boolean chance(double percent) {
        return new Random().nextDouble() < percent / 100;
    }

}
