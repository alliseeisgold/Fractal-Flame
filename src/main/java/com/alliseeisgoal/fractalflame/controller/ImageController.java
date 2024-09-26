package com.alliseeisgoal.fractalflame.controller;

import com.alliseeisgoal.fractalflame.generator.FractalFlameGenerator;
import com.alliseeisgoal.fractalflame.model.FractalImage;
import com.alliseeisgoal.fractalflame.model.Rect;
import com.alliseeisgoal.fractalflame.processors.LogGammaCorrectionImageProcessor;
import com.alliseeisgoal.fractalflame.renderers.MultiThreadRenderer;
import com.alliseeisgoal.fractalflame.transformation.*;
import com.alliseeisgoal.fractalflame.utils.ImageUtils;
import com.alliseeisgoal.fractalflame.utils.ImageFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class ImageController {

    @GetMapping(value = "/generate")
    public ResponseEntity<byte[]> generateImage(
            @RequestParam(defaultValue = "2000") int width,
            @RequestParam(defaultValue = "1000") int height,
            @RequestParam(defaultValue = "-4") int rectX,
            @RequestParam(defaultValue = "-3") int rectY,
            @RequestParam(defaultValue = "8") int rectWidth,
            @RequestParam(defaultValue = "6") int rectHeight,
            @RequestParam(defaultValue = "5") int affineCount,
            @RequestParam(defaultValue = "1") int samples,
            @RequestParam(defaultValue = "100000") int iterPerSample,
            @RequestParam(defaultValue = "3") int symmetry
    ) throws IOException {
        FractalImage image = FractalFlameGenerator.generate(
                width,
                height,
                new Rect(rectX, rectY, rectWidth, rectHeight),
                new MultiThreadRenderer(
                        affineCount, samples, iterPerSample,
                        symmetry, List.of(new HeartTransformation(),
                        new DiscTransformation())
                ),
                List.of(new LogGammaCorrectionImageProcessor(1.5))
        );
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(ImageUtils.convert(image), ImageFormat.PNG.getType(), byteArrayOutputStream);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(byteArrayOutputStream.toByteArray());
    }
}
