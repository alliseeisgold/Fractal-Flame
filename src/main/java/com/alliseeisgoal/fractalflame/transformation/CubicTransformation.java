package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class CubicTransformation implements Transformation {
    @Override
    public Point apply(Point p) {
        return new Point(Math.pow(p.x(), 3), Math.pow(p.y(), 3));
    }
}
