package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class MirrorTransformation implements Transformation {
    @Override
    public Point apply(Point p) {
        return new Point(-p.x(), -p.y());
    }
}
