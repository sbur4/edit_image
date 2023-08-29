package org.example.thumbnailator;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Converter {
    public static void main(String[] args) {
        convert("examples/starbucks_logo.png", "temporary/thumbnails/converted/starbucks_logo.jpg");
        // 5000x5000 PNG 32-bit 960.68kB
        // 5000x5000 JPEG 24-bit 763.5kB
        convert("examples/macos_hello_wallpaper_black_background_4K.jpg", "temporary/thumbnails/converted/macos_hello.png");
        // 1192x670 JPEG 24-bit 32.9kB
        // 1192x670 PNG 24-bit 145.55kB

        convert("examples/twitter_icon_400px.gif", "temporary/thumbnails/converted/twitter_icon_400px.jpg");
        // 400x400 GIF 2-bit 20.32kB
        // 400x400 JPEG 24-bit 3.13kB -> todo lost image!!!
        convert("examples/twitter_icon_400px.gif", "temporary/thumbnails/converted/twitter_icon_400px.png");
        // 400x400 GIF 2-bit 20.32kB
        // 400x400 PNG 1-bit 143B -> todo lost image!!!

        convert("examples/space_x.webp", "temporary/core_image/converted/space_x.jpg");
        // 2000x1200 WEBP 32-bit 81.07kB -> todo doesn't work!!!
        convert("examples/space_x.webp", "temporary/core_image/converted/space_x.png");
        // 2000x1200 WEBP 32-bit 81.07kB -> todo doesn't work!!!

    }

    private static void convert(String inputImagePath, String outputImagePath) {
        try {
            File imageFile = new File(inputImagePath);
            BufferedImage originalImage = ImageIO.read(imageFile);

            if (Objects.nonNull(originalImage)) {
                int targetWidth = originalImage.getWidth();
                int targetHeight = originalImage.getHeight();

                Thumbnails.of(imageFile).size(targetWidth, targetHeight).toFile(new File(outputImagePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}