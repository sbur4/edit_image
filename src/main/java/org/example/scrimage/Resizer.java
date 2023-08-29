package org.example.scrimage;

import com.sksamuel.scrimage.ImmutableImage;
import com.sksamuel.scrimage.Position;
import com.sksamuel.scrimage.webp.WebpWriter;

import java.io.File;
import java.io.IOException;

public class Resizer {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("examples/starbucks_logo.png");
        File outputFile = new File("temporary/scrimage/resized.webp");

        ImmutableImage image = ImmutableImage.loader().fromFile(inputFile);
        ImmutableImage trimmedImage = image.resizeTo(100, 100, Position.Center);
        WebpWriter writer = new WebpWriter().withQ(75);
        trimmedImage.output(writer, outputFile);
        /// PNG 5000x5000 32-bit 980.68kB
        /// WEBP 5000x5000 32-bit 290b
    }
}