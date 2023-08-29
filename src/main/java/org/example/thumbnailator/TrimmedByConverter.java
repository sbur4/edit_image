package org.example.thumbnailator;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class TrimmedByConverter {
    public static void main(String[] args) {
        trim("examples/hogwarts_legacy_hd.jpg", "temporary/thumbnails/trimmed/logo.png");
        // 5000x5000 PNG 32-bit 960.68kB
        // 32x32 PNG 32-bit 1.82kB
    }

    private static void trim(String inputImagePath, String outputImagePath) {
        try {
            File imageFile = new File(inputImagePath);
            BufferedImage originalImage = ImageIO.read(imageFile);

            if (Objects.nonNull(originalImage)) {
                int cropX = originalImage.getWidth() / 2; // X-coordinate of top-left corner of the crop area
                int cropY = originalImage.getHeight() / 2; // Y-coordinate of top-left corner of the crop area
                int cropWidth = 64; // Width of the crop area
                int cropHeight = 64; // Height of the crop area

                File outputFile = new File(outputImagePath);

                Thumbnails.of(imageFile)
                        .sourceRegion(cropX, cropY, cropWidth, cropHeight)
                        .size(cropWidth, cropHeight)
                        .toFile(outputFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}