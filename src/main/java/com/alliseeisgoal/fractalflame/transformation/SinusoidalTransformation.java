package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class SinusoidalTransformation implements Transformation {
    @Override
    public Point apply(Point p) {
        double x = Math.sin(p.x());
        double y = Math.sin(p.y());
        return new Point(x, y);
    }
}
