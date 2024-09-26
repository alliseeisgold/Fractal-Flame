package com.alliseeisgoal.fractalflame.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.Color;

@Data
@AllArgsConstructor
public class Pixel {
    private int red;
    private int green;
    private int blue;
    private int hitCount;
    private double normal;

    public void incrementHitCount(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        if (hitCount == 0) {
            setRed(r);
            setGreen(g);
            setBlue(b);
        } else {
            red = (r + color.getRed()) / 2;
            green = (g + color.getGreen()) / 2;
            blue = (b + color.getBlue()) / 2;
        }
        hitCount++;
    }
}
