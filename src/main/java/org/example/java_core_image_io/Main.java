package org.example.java_core_image_io;

import javax.imageio.ImageIO;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Reader names:" + Arrays.toString(ImageIO.getReaderFormatNames()));
        System.out.println("Reader MIME types:" + Arrays.toString(ImageIO.getReaderMIMETypes()));
        System.out.println("Writer names:" + Arrays.toString(ImageIO.getWriterFormatNames()));
        System.out.println("Writer MIME types:" + Arrays.toString(ImageIO.getWriterMIMETypes()));
    }
}