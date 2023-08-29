package org.example.scrimage;

import com.sksamuel.scrimage.ImmutableImage;
import com.sksamuel.scrimage.metadata.ImageMetadata;
import com.sksamuel.scrimage.webp.WebpWriter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Converter {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("examples/starbucks_logo.png");
        converterWebpDefault(inputFile);
        /// PNG 5000x5000 32-bit 980.68kB
        /// WEBP 5000x5000 32-bit 282.95kB

        converterWebpMaxLosComp(inputFile);
        /// PNG 5000x5000 32-bit 980.68kB
        /// WEBP 5000x5000 32-bit 306.68kB

        ImmutableImage image = ImmutableImage.loader().fromFile(inputFile);
        ImageMetadata meta = ImageMetadata.fromImage(image);
        Arrays.stream(meta.tags()).forEach(tag -> System.out.println(tag));
    }

    private static void converterWebpDefault(File inputFile) throws IOException {
        File outputFile = new File("temporary/scrimage/converted.webp");
        ImmutableImage image = ImmutableImage.loader().fromFile(inputFile);
        image.output(WebpWriter.DEFAULT, outputFile);
    }

    private static void converterWebpMaxLosComp(File inputFile) throws IOException {
        File outputFile = new File("temporary/scrimage/converted2.webp");
        ImmutableImage image = ImmutableImage.loader().fromFile(inputFile);
        image.output(WebpWriter.MAX_LOSSLESS_COMPRESSION, outputFile);
    }
}