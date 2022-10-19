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

    public static void main(String[] args) throws NumberFormatException {
        String operation = args[0];
        String inputFilePath = args[1];
        String key = args[2]; //Integer.parseInt
        String content = null;

        if (!Files.isRegularFile(Path.of(inputFilePath))) {
            throw new IllegalArgumentException("please, provide correct input file path");
        }

        if (ENCODE.equalsIgnoreCase(operation)) {
            String encodedFilePath = rename(inputFilePath, "encode");              //(filePath.substring(0, filePath.lastIndexOf('.')) + "_encoded.txt");
            content = reader(inputFilePath);

            Encoder enc = new Encoder(content, Integer.parseInt(key));

            writer(encodedFilePath, enc.getEncText());


        } else if (DECODE.equalsIgnoreCase(operation)) {
            String decodedFilePath = rename(inputFilePath, "decode");                //(filePath.substring(0, filePath.lastIndexOf('_')) + "_decoded.txt");
            content = reader(inputFilePath);

            Decoder dec = new Decoder(content, Integer.parseInt(key));

            writer(decodedFilePath, dec.getDecText());


        } else if (BRUTE_FORCE.equalsIgnoreCase(operation)) {

            StaticAnalysis staticAnalysis = new StaticAnalysis();
            content = reader(inputFilePath);
            String textToCompare = reader(key);

            int bruteForceKey = (staticAnalysis.bruteForce(content, textToCompare));

            System.out.println(bruteForceKey);

            Decoder dec = new Decoder(content, bruteForceKey);

            String decodedFilePath = rename(inputFilePath, "bruteForce", bruteForceKey);

            writer(decodedFilePath, dec.getDecText());


        }

    }

}
