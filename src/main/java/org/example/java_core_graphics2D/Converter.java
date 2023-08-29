package org.example.java_core_graphics2D;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Converter {
    public static void main(String[] args) {
        convert("examples/starbucks_logo.png", "temporary/core_g2d/converted/starbucks_logo.jpg", "jpg");
        // 5000x5000 PNG 32-bit 960.68kB
        // 5000x5000 JPEG 24-bit 763.5kB
        convert("examples/macos_hello_wallpaper_black_background_4K.jpg", "temporary/core_g2d/converted/macos_hello.png", "png");
        // 1192x670 JPEG 24-bit 32.9kB
        // 1192x670 PNG 24-bit 145.55kB

        convert("examples/twitter_icon_400px.gif", "temporary/core_g2d/converted/twitter_icon_400px.jpg", "jpg");
        // 400x400 GIF 2-bit 20.32kB
        // 400x400 JPEG 24-bit 6.97b
        convert("examples/twitter_icon_400px.gif", "temporary/core_g2d/converted/twitter_icon_400px.png", "png");
        // 400x400 GIF 2-bit 20.32kB
        // 400x400 PNG 24-bit 2.19b

        convert("examples/space_x.webp", "temporary/core_g2d/converted/space_x.jpg", "jpg");
        // 2000x1200 WEBP 32-bit 81.07kB
        // 2000x1200 JPEG 24-bit 138.61kB
        convert("examples/space_x.webp", "temporary/core_g2d/converted/space_x.png", "png");
        // 2000x1200 WEBP 32-bit 81.07kB
        // 2000x1200 PNG 24-bit 1.64MB
    }

    private static void convert(String inputImagePath, String outputImagePath, String extension) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(inputImagePath));
            if (Objects.nonNull(originalImage)) {
                int targetWidth = originalImage.getWidth();
                int targetHeight = originalImage.getHeight();

                BufferedImage bufferedImage = resizeImage(originalImage, targetWidth, targetHeight);

                File outputImageFile = new File(outputImagePath);
                ImageIO.write(bufferedImage, extension, outputImageFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        // todo if need to trim image set x and y
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }
}