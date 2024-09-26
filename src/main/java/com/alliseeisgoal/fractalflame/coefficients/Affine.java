package com.alliseeisgoal.fractalflame.coefficients;

import java.awt.Color;
import java.util.Random;

public record Affine(double a, double b, double c, double d, double e, double f, Color color) {
    private static final double MAX_VALUE = 1;
    private static final int MAX_COLOR_RANGE = 255;

    public static Affine generateRandom(Random random) {
        double a, b, c, d, e, f;
        do {
            a = random.nextDouble() * 2 - 1;
            b = random.nextDouble() * 2 - 1;
            c = random.nextDouble() * 2 - 1;
            d = random.nextDouble() * 2 - 1;
            e = random.nextDouble() * 2 - 1;
            f = random.nextDouble() * 2 - 1;
        } while (!isValidAffine(a, b, c, d, e, f));

        return new Affine(
                a, b, c, d, e, f,
                new Color(random.nextInt(MAX_COLOR_RANGE), random.nextInt(MAX_COLOR_RANGE), random.nextInt(MAX_COLOR_RANGE))
        );
    }

    private static boolean isValidAffine(double a, double b, double c, double d, double e, double f) {
        double aa = a * a;
        double bb = b * b;
        double dd = d * d;
        double ee = e * e;
        double ae = a * e;
        double bd = b * d;
        return (aa + dd < MAX_VALUE) && (bb + ee < MAX_VALUE) && (aa + bb + dd + ee < MAX_VALUE + (ae - bd) * (ae - bd));
    }
}