package org.example.apache_commons;

import org.apache.commons.imaging.ImageFormat;
import org.apache.commons.imaging.ImageFormats;
import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.ImageWriteException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.ImageMetadata;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ImageReadException {
//        BufferedImage bufferedImage = Imaging.getBufferedImage(new File("examples/macos_big_sur_vector_wave_light.jpg"));

        Dimension imageSize = Imaging.getImageSize(new File("examples/macos_big_sur_vector_wave_light.jpg"));
//        Dimension imageSize = Imaging.getImageSize(new File("examples/PEUGEOT_3008_2023.avif")); // Unknown Extension: PEUGEOT_3008_2023.avif
        System.out.print(imageSize.getSize());
        System.out.println(System.lineSeparator());

        ImageFormat imageExtension = Imaging.guessFormat(new File("examples/macos_big_sur_vector_wave_light.jpg"));
        System.out.print(imageExtension.toString());
        System.out.println(System.lineSeparator());

        readWriteImage();
    }

    private static void readWriteImage() {
        try {
            File inputFile = new File("examples/google_logo.png");
            File outputFile = new File("temporary/apache/google_logo.png");
            BufferedImage originalImage = ImageIO.read(inputFile);

            ImageInfo imageInfo = Imaging.getImageInfo(inputFile);
            ImageMetadata imageMetadata = Imaging.getMetadata(inputFile);
            System.out.print(imageMetadata);
            System.out.println(System.lineSeparator());

            System.out.println("Image Format: " + imageInfo.getFormat());
            System.out.println("Image Width: " + imageInfo.getWidth());
            System.out.print("Image Height: " + imageInfo.getHeight());
            System.out.println(System.lineSeparator());

            System.out.print(Imaging.getImageInfo(inputFile));
            System.out.print(Imaging.getImageSize(inputFile));
            System.out.println(System.lineSeparator());

            Imaging.writeImage(originalImage, outputFile, ImageFormats.PNG);

        } catch (IOException | ImageReadException | ImageWriteException e) {
            e.printStackTrace();
        }
    }
}