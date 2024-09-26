package com.alliseeisgoal.fractalflame.processors;

import com.alliseeisgoal.fractalflame.model.FractalImage;

@FunctionalInterface
public interface ImageProcessor {
    void process(FractalImage image);
}
