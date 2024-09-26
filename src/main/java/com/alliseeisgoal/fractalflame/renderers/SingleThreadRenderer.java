package com.alliseeisgoal.fractalflame.renderers;

import com.alliseeisgoal.fractalflame.model.FractalImage;
import com.alliseeisgoal.fractalflame.model.Rect;
import com.alliseeisgoal.fractalflame.transformation.AffineTransformation;
import com.alliseeisgoal.fractalflame.transformation.Transformation;

import java.util.List;

public class SingleThreadRenderer extends Renderer {
    public SingleThreadRenderer(
            int affineCount,
            int samples,
            int iterPerSample,
            int symmetry,
            List<Transformation> variations) {
        super(affineCount, samples, iterPerSample, symmetry, variations);
    }

    @Override
    public void renderWholeImage(FractalImage fractalImage, Rect world, List<AffineTransformation> affineTransformations) {
        for (int i = 0; i < getSamples(); ++i) {
            renderOneSample(fractalImage, world, affineTransformations);
        }
    }
}
