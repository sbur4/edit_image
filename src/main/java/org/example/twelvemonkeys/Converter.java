package org.example.twelvemonkeys;

import com.twelvemonkeys.image.ResampleOp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Converter {
    public static void main(String[] args) {
        String inputImagePath = "examples/hogwarts_legacy_hd.jpg";
        String outputImagePath = "temporary/12m/hogwarts_legacy_hd.jpg";
        int targetWidth = 200;
        int targetHeight = 150;

        try {
            File inputFile = new File(inputImagePath);
            File outputFile = new File(outputImagePath);

            BufferedImage inputImage = ImageIO.read(inputFile);
            if (Objects.nonNull(inputImage)) {
                // Resize the image using a ResampleOp
                ResampleOp resampleOp = new ResampleOp(targetWidth, targetHeight);
                BufferedImage resizedImage = resampleOp.filter(inputImage, null);

                // Save the resized image
                ImageIO.write(resizedImage, "jpg", outputFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}