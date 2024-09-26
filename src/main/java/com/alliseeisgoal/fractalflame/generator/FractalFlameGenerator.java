package com.alliseeisgoal.fractalflame.generator;

import com.alliseeisgoal.fractalflame.model.FractalImage;
import com.alliseeisgoal.fractalflame.model.Rect;
import com.alliseeisgoal.fractalflame.processors.ImageProcessor;
import com.alliseeisgoal.fractalflame.renderers.Renderer;
import java.util.List;

public final class FractalFlameGenerator {
    private FractalFlameGenerator() {
    }

    public static FractalImage generate(
            int width,
            int height,
            Rect area,
            Renderer renderer,
            List<ImageProcessor> processors
    ) {
        FractalImage image = renderer.render(width, height, area);
        for (ImageProcessor processor : processors) {
            processor.process(image);
        }
        return image;
    }
}
