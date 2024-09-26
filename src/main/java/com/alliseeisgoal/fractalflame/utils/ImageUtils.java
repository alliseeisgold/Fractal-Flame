package com.alliseeisgoal.fractalflame.utils;

import com.alliseeisgoal.fractalflame.model.FractalImage;
import com.alliseeisgoal.fractalflame.model.Pixel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

public final class ImageUtils {
    public ImageUtils() {
    }

    public static BufferedImage convert(FractalImage image) {
        BufferedImage renderedImage = new BufferedImage(image.width(), image.height(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < image.height(); y++) {
            for (int x = 0; x < image.width(); x++) {
                Pixel pixel = image.pixel(x, y);
                assert pixel != null;
                Color color = new Color(pixel.getRed(), pixel.getGreen(), pixel.getBlue());
                renderedImage.setRGB(x, y, color.getRGB());
            }
        }
        return renderedImage;
    }

    public void save(FractalImage image, Path filename, ImageFormat format) throws IOException {
        if (ImageFormat.isValidFormat(format.getType())) {
            ImageIO.write(convert(image), format.getType(), filename.toFile());
        }
    }
}
