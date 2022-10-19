package encryption;

public class Encoder extends Alphabet {

    private String output;
    private int k;

    public Encoder(String text, int k) {
        this.k = k;
        String input = text;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);

            if (isEnglishLetter(c)) {
                int y = (putEnglishChar(c) + k) % LETTERS_ENG;

                if (Character.isUpperCase(c)) {
                    output.append(englishAlphabet[y]);
                } else {
                    output.append(Character.toLowerCase(englishAlphabet[y]));
                }

                continue;
            }

            if (isCyrillicLetter(c)) {
                int y = (putCyrillicChar(c) + k) % LETTERS_CYR;

                if (Character.isUpperCase(c)) {
                    output.append(cyrillicAlphabet[y]);
                } else {
                    output.append(Character.toLowerCase(cyrillicAlphabet[y]));
                }

                continue;
            }

            if (!isEnglishLetter(c) && !isCyrillicLetter(c)) {
                output.append(c);
            }
        }
        this.output = output.toString();
    }

    public String getEncText() {

        return this.output;
    }

    public int getK() {

        return this.k;
    }

}

