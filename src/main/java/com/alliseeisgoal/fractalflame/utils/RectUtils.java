package com.alliseeisgoal.fractalflame.utils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.alliseeisgoal.fractalflame.model.FractalImage;
import com.alliseeisgoal.fractalflame.model.Pixel;
import com.alliseeisgoal.fractalflame.model.Point;
import com.alliseeisgoal.fractalflame.model.Rect;


public final class RectUtils {

    private RectUtils() {

    }

    /**
     * Генерирует случайную точку внутри прямоугольника.
     * Координаты точки выбираются равномерно по всему пространству прямоугольника.
     *
     * @param rect Прямоугольник, внутри которого генерируется точка.
     * @return Случайная точка внутри прямоугольника.
     */
    public static Point randomPointInRect(Rect rect) {
        double randomX = rect.x() + ThreadLocalRandom.current().nextDouble() * rect.width();
        double randomY = rect.y() + ThreadLocalRandom.current().nextDouble() * rect.height();
        return new Point(randomX, randomY);
    }

    /**
     * Поворачивает точку вокруг центра прямоугольника на заданный угол (в радианах).
     *
     * @param rect  Прямоугольник, относительно которого происходит вращение.
     * @param point Точка, которую необходимо повернуть.
     * @param angle Угол вращения в радианах.
     * @return Новая точка, полученная после вращения.
     */
    public static Point rotatePointAroundRectCenter(Rect rect, Point point, double angle) {
        double centerX = rect.x() + rect.width() / 2;
        double centerY = rect.y() + rect.height() / 2;

        double translatedX = point.x() - centerX;
        double translatedY = point.y() - centerY;

        double rotatedX = translatedX * Math.cos(angle) - translatedY * Math.sin(angle);
        double rotatedY = translatedX * Math.sin(angle) + translatedY * Math.cos(angle);

        return new Point(rotatedX + centerX, rotatedY + centerY);
    }

    /**
     * Генерирует случайную точку внутри прямоугольника в относительных координатах.
     * Относительные координаты лежат в диапазоне [0, 1] по обеим осям.
     *
     * @param rect Прямоугольник, в пределах которого генерируется точка.
     * @return Случайная точка в относительных координатах (x, y) ∈ [0, 1].
     */
    public static Point randomRelativePoint(Rect rect) {
        double relativeX = ThreadLocalRandom.current().nextDouble();
        double relativeY = ThreadLocalRandom.current().nextDouble();
        return new Point(relativeX * rect.width() + rect.x(), relativeY * rect.height() + rect.y());
    }

    /**
     * Поворачивает точку на заданный угол относительно произвольной опорной точки.
     *
     * @param origin Точка, относительно которой выполняется вращение.
     * @param point  Точка, которую необходимо повернуть.
     * @param angle  Угол вращения в радианах.
     * @return Повернутая точка.
     */
    public static Point rotatePointAroundOrigin(Point origin, Point point, double angle) {
        double translatedX = point.x() - origin.x();
        double translatedY = point.y() - origin.y();
        double rotatedX = translatedX * Math.cos(angle) - translatedY * Math.sin(angle);
        double rotatedY = translatedX * Math.sin(angle) + translatedY * Math.cos(angle);
        return new Point(rotatedX + origin.x(), rotatedY + origin.y());
    }

    public static Pixel resolvePixel(Rect rect, Point point, FractalImage image) {
        // Проверка: если точка не находится внутри прямоугольника, возвращаем null
        if (!rect.contains(point)) {
            return null;
        }

        double relativeX = (point.x() - rect.x()) / rect.width();
        double relativeY = (point.y() - rect.y()) / rect.height();

        int pixelX = (int) (relativeX * image.width());
        int pixelY = (int) (relativeY * image.height());

        if (image.contains(pixelX, pixelY)) {
            return image.pixel(pixelX, pixelY);
        } else {
            return null;
        }
    }


    public static <T> T random(List<T> list) {
        return list.get((int) (ThreadLocalRandom.current().nextDouble() * list.size()));
    }

}
