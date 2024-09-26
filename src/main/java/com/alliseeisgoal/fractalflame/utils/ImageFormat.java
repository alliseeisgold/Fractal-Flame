package com.alliseeisgoal.fractalflame.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ImageFormat {
    JPEG("jpg"),
    BMP("bmp"),
    PNG("png");
    private final String type;

    public static boolean isValidFormat(String format) {
        return format.equalsIgnoreCase(JPEG.getType()) ||
                format.equalsIgnoreCase(BMP.getType()) ||
                format.equalsIgnoreCase(PNG.getType());
    }
}
