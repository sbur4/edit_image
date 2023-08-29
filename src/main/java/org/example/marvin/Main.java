package org.example.marvin;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int targetWidth = 100;
        int targetHeight = 100;

        try {
            MarvinImage image = MarvinImageIO.loadImage("examples/google_logo.png");

            if (Objects.nonNull(image)) {
                image.resize(targetWidth, targetHeight);
                MarvinImageIO.saveImage(image, "temporary/marvin/google_logo.png");
            } else {
                System.out.println("Failed to read the image.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}