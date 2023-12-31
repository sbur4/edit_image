package org.example.scrimage;

import com.sksamuel.scrimage.ImmutableImage;
import com.sksamuel.scrimage.webp.WebpWriter;

import java.io.File;
import java.io.IOException;

public class Trimmer {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("examples/starbucks_logo.png");
        File outputFile = new File("temporary/scrimage/trimmed.webp");

        ImmutableImage image = ImmutableImage.loader().fromFile(inputFile);
        ImmutableImage trimmedImage = image.trim(2500, 2500, 0, 0);
        WebpWriter writer = new WebpWriter().withQ(75);
        trimmedImage.output(writer, outputFile);
        /// PNG 5000x5000 32-bit 980.68kB
        /// WEBP 2500x2500 32-bit 71.58kB
    }
}