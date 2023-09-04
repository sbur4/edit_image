package org.example.scrimage;

import com.sksamuel.scrimage.ImmutableImage;
import com.sksamuel.scrimage.ScaleMethod;
import com.sksamuel.scrimage.webp.WebpWriter;

import java.io.File;
import java.io.IOException;

public class Resizer {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("examples/starbucks_logo.png");
        File outputFile = new File("temporary/scrimage/resized.webp");

        ImmutableImage image = ImmutableImage.loader().fromFile(inputFile);

//        ImmutableImage trimmedImage = image.resizeTo(40, 40); // it crop
//        ImmutableImage trimmedImage = image.bound(40, 40);
        ImmutableImage trimmedImage = image.bound(40, 40, ScaleMethod.Progressive); // v1
        WebpWriter writer = new WebpWriter().withQ(100);
        trimmedImage.output(writer, outputFile);
        /// PNG 5000x5000 32-bit 980.68kB
        /// WEBP 5000x5000 32-bit 290b

        ImmutableImage scaledImage = image.scaleTo(40, 40, ScaleMethod.Progressive); // v2
        WebpWriter writer2 = new WebpWriter().withQ(100);
        trimmedImage.output(writer2, "temporary/scrimage/scaled.webp");

        ImmutableImage maxedImage = image.scaleTo(40, 40, ScaleMethod.Progressive); // v3
        WebpWriter writer3 = new WebpWriter().withQ(100);
        trimmedImage.output(writer3, "temporary/scrimage/maxed.webp");
    }
}