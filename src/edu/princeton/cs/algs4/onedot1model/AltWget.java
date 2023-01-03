package edu.princeton.cs.algs4.onedot1model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AltWget {
    public static void main(String[] args) throws IOException {
        // read in data from URL
        String arg = args[0];
        URL url = new URL(arg);
        String file = readURL(url);
    }

    private static String readURL(URL url) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = in.readLine()) != null)
            sb.append(line).append(System.lineSeparator());
        in.close();
        return sb.toString();
    }

    public static String URLReader(URL url) throws IOException {
        try (InputStream in = url.openStream())
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
// for language level - 9
//    public static String URLReader(URL url, Charset encoding) throws IOException {
//        try (InputStream in = url.openStream())
//        {
//            byte[] bytes = in.readAllBytes();
//            return new String(bytes, encoding);
//        }
//    }
}
