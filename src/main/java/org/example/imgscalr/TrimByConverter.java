package org.example.imgscalr;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class TrimByConverter {
    public static void main(String[] args) {
        // todo work only  with one extension
        trim("examples/google_logo.png", "temporary/imgsclr/trimmed/trimmed_logo_1.png", "png");
    }

    private static void trim(String inputImagePath, String outputImagePath, String extension) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(inputImagePath));
            if (Objects.nonNull(originalImage)) {
                int cropX = originalImage.getWidth() / 2; // X-coordinate of top-left corner of the crop area
                int cropY = originalImage.getHeight() / 2; // Y-coordinate of top-left corner of the crop area
                int cropWidth = 32; // Width of the crop area
                int cropHeight = 32; // Height of the crop area

                BufferedImage trimmedImage = Scalr.crop(originalImage, cropX, cropY, cropWidth, cropHeight);

                File outputImageFile = new File(outputImagePath);
                ImageIO.write(trimmedImage, extension, outputImageFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}