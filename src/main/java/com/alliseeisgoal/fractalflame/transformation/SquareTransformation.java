package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class SquareTransformation implements Transformation {
    @Override
    public Point apply(Point p) {
        return new Point(Math.signum(p.x()) * Math.abs(p.x()), Math.signum(p.y()) * Math.abs(p.y()));
    }
}
