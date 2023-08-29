package org.example.google_guava;

import com.google.common.collect.Lists;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.google.common.io.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        addToFileStringByCharSink();
        addToFileTextByCharSink();
        addToFileTextByByteSink();
        readFromFileTextByCharSource();
        readFromFilesTextByCharSource();
        readFromFileTextByCharStreams();
        readFromFileTextByByteSource();
        readFromFileTextByByteStreams();
//        readFromFileTextByResources();
    }

    private static void addToFileStringByCharSink() throws IOException {
        File file = new File("examples/test.txt");
        CharSink sink = Files.asCharSink(file, StandardCharsets.UTF_8);
        sink.write("epam");
    }

    private static void addToFileTextByCharSink() throws IOException {
        List<String> names = Lists.newArrayList("java", "javascript", "c", "python");
        File file = new File("examples/test.txt");
        CharSink sink = Files.asCharSink(file, StandardCharsets.UTF_8);
        sink.writeLines(names, " ");
    }

    private static void addToFileTextByByteSink() throws IOException {
        File file = new File("examples/test.txt");
        ByteSink sink = Files.asByteSink(file);
        sink.write("google".getBytes());
    }

    private static void readFromFileTextByCharSource() throws IOException {
        File file = new File("examples/test.txt");
        CharSource source = Files.asCharSource(file, StandardCharsets.UTF_8);
        String result = source.read();
        System.out.println(result);
        System.out.print(System.lineSeparator());
    }

    private static void readFromFilesTextByCharSource() throws IOException {
        File file1 = new File("examples/test.txt");
        File file2 = new File("examples/test_2.txt");
        CharSource source1 = Files.asCharSource(file1, StandardCharsets.UTF_8);
        CharSource source2 = Files.asCharSource(file2, StandardCharsets.UTF_8);
        CharSource source = CharSource.concat(source1, source2);
        String result = source.read();
        System.out.println(result);
        System.out.print(System.lineSeparator());
    }

    private static void readFromFileTextByCharStreams() throws IOException {
        FileReader reader = new FileReader("examples/test.txt");
        String result = CharStreams.toString(reader);
        System.out.println(result);
        System.out.print(System.lineSeparator());
    }

    private static void readFromFileTextByByteSource() throws IOException {
        File file = new File("examples/test.txt");
        ByteSource source = Files.asByteSource(file);
        byte[] result = source.read();
        System.out.println(Arrays.toString(result));
        System.out.println(new String(result));
        System.out.print(System.lineSeparator());
    }

    private static void readFromFileTextByByteStreams() throws IOException {
        FileInputStream reader = new FileInputStream("examples/test.txt");
        byte[] result = ByteStreams.toByteArray(reader);
        reader.close();
        System.out.print(new String(result));
        System.out.println(System.lineSeparator());
    }

    private static void readFromFileTextByResources() throws IOException {
        URL url = Resources.getResource("examples/test.txt");
        String result = Resources.toString(url, StandardCharsets.UTF_8);
        System.out.print(new String(result));
    }
}