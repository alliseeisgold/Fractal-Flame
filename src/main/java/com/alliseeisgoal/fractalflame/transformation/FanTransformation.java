package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

public class FanTransformation implements Transformation {
    private final double fanAngle;
    private final double fanFrequency;

    public FanTransformation(double fanAngle, double fanFrequency) {
        this.fanAngle = fanAngle;
        this.fanFrequency = fanFrequency;
    }

    @Override
    public Point apply(Point p) {
        double theta = Math.atan2(p.y(), p.x());
        double r = Math.sqrt(p.x() * p.x() + p.y() * p.y());
        double t = fanFrequency * theta % fanAngle;

        if (t > fanAngle / 2) {
            return new Point(r * Math.cos(theta + fanAngle / 2), r * Math.sin(theta + fanAngle / 2));
        } else {
            return new Point(r * Math.cos(theta - fanAngle / 2), r * Math.sin(theta - fanAngle / 2));
        }
    }
}
