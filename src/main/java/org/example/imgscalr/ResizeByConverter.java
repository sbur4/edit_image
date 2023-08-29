package org.example.imgscalr;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ResizeByConverter {
    public static void main(String[] args) {
        // todo work only  with one extension
        resize("examples/starbucks_logo.png", "temporary/imgsclr/resized/resized_logo_1.png", "png",
                Scalr.Method.SPEED, Scalr.Mode.AUTOMATIC);
        resize("examples/starbucks_logo.png", "temporary/imgsclr/resized/resized_logo_2.png", "png",
                Scalr.Method.BALANCED, Scalr.Mode.FIT_TO_HEIGHT);
        resize("examples/starbucks_logo.png", "temporary/imgsclr/resized/resized_logo_3.png", "png",
                Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_WIDTH); // todo good quality, same
        resize("examples/starbucks_logo.png", "temporary/imgsclr/resized/resized_logo_4.png", "png",
                Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT); // todo good quality, same
        resize("examples/starbucks_logo.png", "temporary/imgsclr/resized/resized_logo_5.png", "png",
                Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT); // todo the best quality
    }

    private static void resize(String inputImagePath, String outputImagePath, String extension, Scalr.Method compressQuality,
                               Scalr.Mode resizeMode) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(inputImagePath));
            if (Objects.nonNull(originalImage)) {
                int targetWidth = 100;
                int targetHeight = 100;

                // resized
                BufferedImage resizedImage = Scalr.resize(originalImage, compressQuality, resizeMode, targetWidth, targetHeight);
                // resized2
//            BufferedImage resizedImage = Scalr.resize(originalImage, compressQuality, resizeMode, targetWidth, targetHeight, Scalr.OP_ANTIALIAS); // add blur

                File outputImageFile = new File(outputImagePath);
                ImageIO.write(resizedImage, extension, outputImageFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}