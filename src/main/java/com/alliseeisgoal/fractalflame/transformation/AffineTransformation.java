package com.alliseeisgoal.fractalflame.transformation;

import com.alliseeisgoal.fractalflame.coefficients.Affine;
import com.alliseeisgoal.fractalflame.model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public record AffineTransformation(Affine coefficient) implements Transformation {

    @Override
    public Point apply(Point point) {
        double x = coefficient.a() + point.x() * coefficient.b() + point.y() * coefficient.c();
        double y = coefficient.d() + point.x() * coefficient.e() + point.y() * coefficient.f();
        return new Point(x, y);
    }

    public static List<AffineTransformation> generateAffineTransformations(int affineCount) {
        List<AffineTransformation> affineTransformations = new ArrayList<>();
        for (int i = 0; i < affineCount; i++) {
            AffineTransformation transformation =
                    new AffineTransformation(Affine.generateRandom(ThreadLocalRandom.current()));
            affineTransformations.add(transformation);
        }
        return affineTransformations;
    }
}
