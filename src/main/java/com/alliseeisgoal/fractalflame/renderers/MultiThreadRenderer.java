package com.alliseeisgoal.fractalflame.renderers;

import com.alliseeisgoal.fractalflame.model.FractalImage;
import com.alliseeisgoal.fractalflame.model.Rect;
import com.alliseeisgoal.fractalflame.transformation.AffineTransformation;
import com.alliseeisgoal.fractalflame.transformation.Transformation;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadRenderer extends Renderer {
    public MultiThreadRenderer(
            int affineCount,
            int samples,
            int iterPerSample,
            int symmetry,
            List<Transformation> variations
    ) {
        super(affineCount, samples, iterPerSample, symmetry, variations);
    }

    @Override
    public void renderWholeImage(FractalImage fractalImage, Rect world, List<AffineTransformation> affineTransformations) {
        var executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < getSamples(); ++i) {
            executorService.execute(
                    () -> renderOneSample(fractalImage, world, affineTransformations)
            );
        }
        shutdownAndAwaitTermination(executorService);
    }

    private void shutdownAndAwaitTermination(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Executor did not terminate.");
                }
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
