package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class PolarTransformation implements Transformation {
    @Override
    public Point apply(Point p) {
        double r = Math.sqrt(p.x() * p.x() + p.y() * p.y());
        double theta = Math.atan2(p.y(), p.x());
        return new Point(theta / Math.PI, r - 1.0);
    }
}
