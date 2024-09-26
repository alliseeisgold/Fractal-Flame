package com.alliseeisgoal.fractalflame.renderers;

import com.alliseeisgoal.fractalflame.model.FractalImage;
import com.alliseeisgoal.fractalflame.model.Pixel;
import com.alliseeisgoal.fractalflame.model.Point;
import com.alliseeisgoal.fractalflame.model.Rect;

import com.alliseeisgoal.fractalflame.transformation.AffineTransformation;
import com.alliseeisgoal.fractalflame.transformation.Transformation;
import com.alliseeisgoal.fractalflame.utils.RectUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public abstract class Renderer {
    private static final int NORMALIZATION_STEPS = 20;
    private final int affineCount;
    private final int samples;
    private final int iterPerSample;
    private final int symmetry;
    private final List<Transformation> variations;

    public abstract void renderWholeImage(FractalImage fractalImage, Rect world, List<AffineTransformation> affineTransformations);

    public FractalImage render(int width, int height, Rect world) {
        FractalImage image = FractalImage.create(width, height);
        List<AffineTransformation> affineTransformations = AffineTransformation.generateAffineTransformations(affineCount);
        renderWholeImage(image, world, affineTransformations);
        return image;
    }

    protected void renderOneSample(FractalImage image, Rect world, List<AffineTransformation> affineTransformations) {
        Point currentPoint = RectUtils.randomPointInRect(world);
        for (int step = -NORMALIZATION_STEPS; step < iterPerSample; ++step) {
            AffineTransformation affine = RectUtils.random(affineTransformations);
            Transformation variation = RectUtils.random(variations);
            currentPoint = affine.apply(currentPoint);
            currentPoint = variation.apply(currentPoint);
            if (step > 0) {
                double theta = 0.0;
                for (int chunk = 0; chunk < symmetry; theta += Math.PI * 2 / symmetry, ++chunk) {
                    var point = RectUtils.rotatePointAroundRectCenter(world, currentPoint, theta);
                    processPoint(world, image, point, affine);
                }
            }
        }
    }

    private void processPoint(Rect world, FractalImage image, Point point, AffineTransformation affine) {
        if (!world.contains(point)) {
            return;
        }
        Pixel pixel = RectUtils.resolvePixel(world, point, image);
        if (pixel != null) {
            synchronized (pixel) {
                Color color = affine.coefficient().color();
                pixel.incrementHitCount(color);
            }
        }
    }

}

