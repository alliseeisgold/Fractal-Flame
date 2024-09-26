package com.alliseeisgoal.fractalflame.generator.config;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FractalGenerationConfig {

    private static final int DEFAULT_WIDTH = 2000;
    private static final int DEFAULT_HEIGHT = 1000;
    private static final int DEFAULT_RECT_X = -4;
    private static final int DEFAULT_RECT_Y = -3;
    private static final int DEFAULT_RECT_WIDTH = 8;
    private static final int DEFAULT_RECT_HEIGHT = 6;
    private static final int DEFAULT_AFFINE_COUNT = 5;
    private static final int DEFAULT_SAMPLES = 5;
    private static final int DEFAULT_ITER_PER_SAMPLE = 100000;
    private static final int DEFAULT_SYMMETRY = 5;

    @Builder.Default
    private int width = DEFAULT_WIDTH;

    @Builder.Default
    private int height = DEFAULT_HEIGHT;

    @Builder.Default
    private int rectX = DEFAULT_RECT_X;

    @Builder.Default
    private int rectY = DEFAULT_RECT_Y;

    @Builder.Default
    private int rectWidth = DEFAULT_RECT_WIDTH;

    @Builder.Default
    private int rectHeight = DEFAULT_RECT_HEIGHT;

    @Builder.Default
    private int affineCount = DEFAULT_AFFINE_COUNT;

    @Builder.Default
    private int samples = DEFAULT_SAMPLES;

    @Builder.Default
    private int iterPerSample = DEFAULT_ITER_PER_SAMPLE;

    @Builder.Default
    private int symmetry = DEFAULT_SYMMETRY;

    public static FractalGenerationConfig create(
            int width,
            int height,
            int rectX,
            int rectY,
            int rectWidth,
            int rectHeight,
            int affineCount,
            int samples,
            int iterPerSample,
            int symmetry
    ) {
        return FractalGenerationConfig.builder()
                .width(validate(width, "Width"))
                .height(validate(height, "Height"))
                .rectX(validate(rectX, "Rect X"))
                .rectY(validate(rectY, "Rect Y"))
                .rectWidth(validate(rectWidth, "Rect Width"))
                .rectHeight(validate(rectHeight, "Rect Height"))
                .affineCount(validate(affineCount, "Affine Count"))
                .samples(validate(samples, "Samples"))
                .iterPerSample(validate(iterPerSample, "Iter Per Sample"))
                .symmetry(validate(symmetry, "Symmetry"))
                .build();
    }

    private static int validate(int value, String fieldName) {
        if (value <= 0) {
            throw new IllegalArgumentException(fieldName + " must be greater than 0");
        }
        return value;
    }
}