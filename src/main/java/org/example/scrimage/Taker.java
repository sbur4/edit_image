package org.example.scrimage;

import com.sksamuel.scrimage.ImmutableImage;
import com.sksamuel.scrimage.webp.WebpWriter;

import java.io.File;
import java.io.IOException;

public class Taker {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("examples/starbucks_logo.png");
        File outputFile = new File("temporary/scrimage/taked.webp");

        ImmutableImage image = ImmutableImage.loader().fromFile(inputFile);
        int w = image.width;
        int h = image.height;
//        ImmutableImage trimmedImage = image.takeLeft(0).takeRight(w - 100).takeTop(h - 100).takeBottom(0);
        ImmutableImage trimmedImage = image.takeLeft(2500);
        WebpWriter writer = new WebpWriter();
        trimmedImage.output(writer, outputFile);
        /// PNG 5000x5000 32-bit 980.68kB
        /// WEBP 2500x2500 32-bit 143.54kB
    }
}