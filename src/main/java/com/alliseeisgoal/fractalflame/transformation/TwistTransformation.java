package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class TwistTransformation implements Transformation {
    private final double angle;

    public TwistTransformation(double angle) {
        this.angle = angle;
    }

    @Override
    public Point apply(Point p) {
        double r = Math.sqrt(p.x() * p.x() + p.y() * p.y());
        double theta = Math.atan2(p.y(), p.x()) + angle * r;
        return new Point(r * Math.cos(theta), r * Math.sin(theta));
    }
}
