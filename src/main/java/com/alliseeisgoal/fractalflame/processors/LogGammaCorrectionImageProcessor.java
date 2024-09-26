package com.alliseeisgoal.fractalflame.processors;

import com.alliseeisgoal.fractalflame.model.FractalImage;
import com.alliseeisgoal.fractalflame.model.Pixel;

public class LogGammaCorrectionImageProcessor implements ImageProcessor {
    private final double gamma;

    public LogGammaCorrectionImageProcessor(double gamma) {
        this.gamma = gamma;
    }

    @Override
    public void process(FractalImage image) {
        double maxNormal = 0.0;

        // Шаг 1: Рассчитываем нормализованные значения и находим максимум
        for (int y = 0; y < image.height(); y++) {
            for (int x = 0; x < image.width(); x++) {
                Pixel pixel = image.pixel(x, y);
                assert pixel != null;
                int hitCount = pixel.getHitCount();
                if (hitCount != 0) {
                    double normal = Math.log10(hitCount);
                    pixel.setNormal(normal);
                    if (normal > maxNormal) {
                        maxNormal = normal;
                    }
                }
            }
        }

        // Шаг 2: Нормализуем значения и применяем гамма-коррекцию к каждому цветовому каналу
        for (int y = 0; y < image.height(); y++) {
            for (int x = 0; x < image.width(); x++) {
                Pixel pixel = image.pixel(x, y);
                assert pixel != null;
                double normal = pixel.getNormal() / maxNormal;
                pixel.setNormal(normal);
                pixel.setRed(applyGammaCorrection(pixel.getRed(), normal));
                pixel.setGreen(applyGammaCorrection(pixel.getGreen(), normal));
                pixel.setBlue(applyGammaCorrection(pixel.getBlue(), normal));
            }
        }
    }

    private int applyGammaCorrection(int colorValue, double normal) {
        return (int) (colorValue * Math.pow(normal, 1.0 / gamma));
    }
}
