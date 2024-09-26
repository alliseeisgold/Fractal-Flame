package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class WaveTransformation implements Transformation {
    private final double b, c, e, f;

    public WaveTransformation(double b, double c, double e, double f) {
        this.b = b;
        this.c = c;
        this.e = e;
        this.f = f;
    }

    @Override
    public Point apply(Point p) {
        double x = p.x() + b * Math.sin(p.y() / (c * c));
        double y = p.y() + e * Math.sin(p.x() / (f * f));
        return new Point(x, y);
    }
}
