package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class SphereTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        double r = point.x() * point.x() + point.y() * point.y();
        return new Point(point.x() / r, point.y() / r);
    }
}
