package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class BlurTransformation implements Transformation {
    @Override
    public Point apply(Point p) {
        double randomAngle = Math.random() * 2 * Math.PI;
        return new Point(Math.cos(randomAngle), Math.sin(randomAngle));
    }
}
