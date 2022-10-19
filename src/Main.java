import encryption.Decoder;
import encryption.Encoder;
import encryption.StaticAnalysis;

import static utils.WorkWithPaths.reader;
import static utils.WorkWithPaths.writer;
import static utils.WorkWithPaths.rename;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static final String ENCODE = "encode";
    public static final String DECODE = "decode";
    public static final String BRUTE_FORCE = "bruteForce";

    public static void main(String[] args) {
        String operation = args[0];
        String inputFilePath = args[1];
        String key = args[2];

        String fileContent = null;

        if (!Files.isRegularFile(Path.of(inputFilePath))) {
            throw new IllegalArgumentException("please, provide correct input file path");
        }

        if (ENCODE.equalsIgnoreCase(operation)) {
            fileContent = reader(inputFilePath);

            Encoder enc = new Encoder(fileContent, Integer.parseInt(key));

            String encodedFilePath = rename(inputFilePath, "encode");
            writer(encodedFilePath, enc.getEncText());

        } else if (DECODE.equalsIgnoreCase(operation)) {
            fileContent = reader(inputFilePath);

            Decoder dec = new Decoder(fileContent, Integer.parseInt(key));

            String decodedFilePath = rename(inputFilePath, "decode");
            writer(decodedFilePath, dec.getDecText());

        } else if (BRUTE_FORCE.equalsIgnoreCase(operation)) {
            StaticAnalysis staticAnalysis = new StaticAnalysis();
            fileContent = reader(inputFilePath);
            String textToCompare = reader(key);

            int bruteForceKey = (staticAnalysis.bruteForce(fileContent, textToCompare));

            System.out.println(bruteForceKey);

            Decoder dec = new Decoder(fileContent, bruteForceKey);

            String decodedFilePath = rename(inputFilePath, "bruteForce", bruteForceKey);

            writer(decodedFilePath, dec.getDecText());

        }

    }

}
