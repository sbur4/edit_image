package org.example.thumbnailator;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ResizeByConverter {
    public static void main(String[] args) {
        resize("examples/starbucks_logo.png", "temporary/thumbnails/resized/starbucks_logo.png", "png");
        // 5000x5000 PNG 32-bit 960.68kB
        // 32x32 PNG 32-bit 1.82kB
    }

    private static void resize(String inputImagePath, String outputImagePath, String extension) {
        try {
            File imageFile = new File(inputImagePath);
            BufferedImage originalImage = ImageIO.read(imageFile);

            if (Objects.nonNull(originalImage)) {
                int targetWidth = 32;
                int targetHeight = 32;

                BufferedImage bufferedImage = resizeImage(originalImage, targetWidth, targetHeight, extension);

                File outputImageFile = new File(outputImagePath);
                ImageIO.write(bufferedImage, extension, outputImageFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight, String extension) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            Thumbnails.of(originalImage)
                    .size(targetWidth, targetHeight)
                    .outputFormat(extension)
                    .outputQuality(1)
                    .toOutputStream(outputStream);

            byte[] data = outputStream.toByteArray();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            return ImageIO.read(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}