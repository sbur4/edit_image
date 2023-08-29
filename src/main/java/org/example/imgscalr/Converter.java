package org.example.imgscalr;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Converter {
    public static void main(String[] args) {
        // todo work only  with one extension
        convert("examples/starbucks_logo.png", "temporary/imgsclr/converted/starbucks_logo.png", "png",
                Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC);
        // 5000x5000 PNG 32-bit 960.68kB
        // 5000x5000 PNG 24-bit 765.8kB
        convert("examples/twitter_icon_400px.gif", "temporary/imgsclr/converted/twitter_icon_400px.gif", "gif",
                Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC);
        // 400x400 GIF 2-bit 20.32kB
        // 400x400 GIF 2-bit 1.64kB
        convert("examples/macos_big_sur_vector_wave_light.jpg", "temporary/imgsclr/converted/macos_big_sur_vector_wave_light.jpg", "jpg",
                Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC);
        // 2560x2560 JPEG 24-bit 89.53kB
        // 2560x2560 JPEG 24-bit 140.34kB
        convert("examples/space_x.webp", "temporary/imgsclr/converted/space_x.webp", "webp",
                Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC);
        // 2000x1200 WEBP 32-bit 81.07kB -> todo doesn't work!!!
    }

    private static void convert(String inputImagePath, String outputImagePath, String extension, Scalr.Method compressQuality,
                                Scalr.Mode resizeMode) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(inputImagePath));
            if (Objects.nonNull(originalImage)) {
                int targetWidth = originalImage.getWidth();
                int targetHeight = originalImage.getHeight();

                BufferedImage resizedImage = Scalr.resize(originalImage, compressQuality, resizeMode, targetWidth, targetHeight);

                File outputImageFile = new File(outputImagePath);
                ImageIO.write(resizedImage, extension, outputImageFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}