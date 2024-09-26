package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class CylinderTransformation implements Transformation {
    @Override
    public Point apply(Point p) {
        return new Point(Math.sin(p.x()), p.y());
    }
}
