package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class PopcornTransformation implements Transformation {
    @Override
    public Point apply(Point p) {
        double x = p.x() + 0.05 * Math.sin(Math.tan(3 * p.y()));
        double y = p.y() + 0.05 * Math.sin(Math.tan(3 * p.x()));
        return new Point(x, y);
    }
}
