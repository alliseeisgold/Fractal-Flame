package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class BubbleTransformation implements Transformation {
    @Override
    public Point apply(Point p) {
        double r2 = p.x() * p.x() + p.y() * p.y();
        return new Point(4 * p.x() / (r2 + 4), 4 * p.y() / (r2 + 4));
    }
}

