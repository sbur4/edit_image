package org.example.java_core_image_io;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ResizeByConverter2 {
    public static void main(String[] args) {
        convert("examples/starbucks_logo.png", "temporary/core_image/resized/starbucks_logo.jpg", "jpg");
        // 5000x5000 PNG 32-bit 960.68kB
        // 32x32 JPEG 24-bit 1.23kB
        convert("examples/macos_hello_wallpaper_black_background_4K.jpg", "temporary/core_image/resized/macos_hello.png", "png");
        // 1192x670 JPEG 24-bit 32.9kB
        // 32x32 PNG 24-bit 474B

        convert("examples/twitter_icon_400px.gif", "temporary/core_image/resized/twitter_icon_400px.jpg", "jpg");
        // 400x400 GIF 2-bit 20.32kB
        // 32x32 JPEG 24-bit 846b
        convert("examples/twitter_icon_400px.gif", "temporary/core_image/resized/twitter_icon_400px.png", "png");
        // 400x400 GIF 2-bit 20.32kB
        // 32x32 PNG 24-bit 160b

        convert("examples/space_x.webp", "temporary/core_image/resized/space_x.jpg", "jpg");
        // 2000x1200 WEBP 32-bit 81.07kB
        // 32x32 JPEG 24-bit 1kB
        convert("examples/space_x.webp", "temporary/core_image/resized/space_x.png", "png");
        // 2000x1200 WEBP 32-bit 81.07kB
        // 32x32 PNG 24-bit 2.81kB
    }

    private static void convert(String inputImagePath, String outputImagePath, String extension) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(inputImagePath));
            if (Objects.nonNull(originalImage)) {
                // ico/avatar sizes
                int targetWidth = 32;
                int targetHeight = 32;

                BufferedImage bufferedImage = resizeImage(originalImage, targetWidth, targetHeight);

                File outputImageFile = new File(outputImagePath);
                ImageIO.write(bufferedImage, extension, outputImageFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        // todo if need to trim image set x and y
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }
}