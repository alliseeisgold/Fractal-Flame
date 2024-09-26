package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.model.Point;

import java.util.function.Function;

@FunctionalInterface
public interface Transformation extends Function<Point, Point> {
    
}
