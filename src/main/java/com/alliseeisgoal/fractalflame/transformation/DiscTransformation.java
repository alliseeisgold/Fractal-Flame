package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class DiscTransformation implements Transformation {
    @Override
    public Point apply(Point p) {
        double r = Math.PI * Math.sqrt(p.x() * p.x() + p.y() * p.y());
        double theta = Math.atan2(p.y(), p.x());
        return new Point(theta * Math.sin(r) / Math.PI, theta * Math.cos(r) / Math.PI);
    }
}
