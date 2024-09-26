package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class RingsTransformation implements Transformation {
    private final double frequency;

    public RingsTransformation(double frequency) {
        this.frequency = frequency;
    }

    @Override
    public Point apply(Point p) {
        double r = Math.sqrt(p.x() * p.x() + p.y() * p.y());
        double theta = Math.atan2(p.y(), p.x());
        double t = r % frequency;
        return new Point(t * Math.cos(theta), t * Math.sin(theta));
    }
}
