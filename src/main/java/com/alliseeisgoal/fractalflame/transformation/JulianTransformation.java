package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class JulianTransformation implements Transformation {
    private final double power;

    public JulianTransformation(double power) {
        this.power = power;
    }

    @Override
    public Point apply(Point p) {
        double r = Math.pow(Math.sqrt(p.x() * p.x() + p.y() * p.y()), power / 2);
        double theta = Math.atan2(p.y(), p.x()) * power;
        return new Point(r * Math.cos(theta), r * Math.sin(theta));
    }
}
