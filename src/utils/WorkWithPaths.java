package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WorkWithPaths {

    protected static final String ENCODE = "encode";
    protected static final String DECODE = "decode";
    protected static final String BRUTE_FORCE = "bruteForce";
    protected static int key;

    public static String reader(String inputPath)  {
       try {
           return Files.readString(Paths.get(inputPath), StandardCharsets.UTF_8);
       } catch (IOException e) {
           e.printStackTrace();
           throw new RuntimeException();
       }
    }

    public static String rename(String fileName, String mode) {

        if (ENCODE.equalsIgnoreCase(mode)) {
            return fileName.substring(0, fileName.lastIndexOf('.'))
                    + "_encoded"
                    + fileName.substring(fileName.lastIndexOf('.'));
        } else if (DECODE.equalsIgnoreCase(mode)) {
            return fileName.substring(0, fileName.lastIndexOf('_'))
                    + "_decoded"
                    + fileName.substring(fileName.lastIndexOf('.'));
        } else if (mode.equalsIgnoreCase(BRUTE_FORCE)) {
            return fileName.substring(0, fileName.lastIndexOf('_'))
                    + "_decoded with " + "key number "
                    + fileName.substring(fileName.lastIndexOf('.'));
        }
        return null;
    }

    public static String rename (String fileName, String mode, int key) {

        if (ENCODE.equalsIgnoreCase(mode)) {
            return fileName.substring(0, fileName.lastIndexOf('.'))
                    + "_encoded"
                    + fileName.substring(fileName.lastIndexOf('.'));
        } else if (DECODE.equalsIgnoreCase(mode)) {
            return fileName.substring(0, fileName.lastIndexOf('_'))
                    + "_decoded"
                    + fileName.substring(fileName.lastIndexOf('.'));
        } else if (mode.equalsIgnoreCase(BRUTE_FORCE)) {
            return fileName.substring(0, fileName.lastIndexOf('_'))
                    + "_decoded with " + "key number " + key
                    + fileName.substring(fileName.lastIndexOf('.'));
        }
        return null;

    }

    public static void writer(String outputPath, String content) {
        try {
            Files.writeString(Paths.get(outputPath), content);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


}