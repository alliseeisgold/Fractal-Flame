package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class JuliaTransformation implements Transformation {
    @Override
    public Point apply(Point p) {
        double r = Math.sqrt(Math.sqrt(p.x() * p.x() + p.y() * p.y()));
        double theta = Math.atan2(p.y(), p.x()) / 2;
        return new Point(r * Math.cos(theta), r * Math.sin(theta));
    }
}
