package encryption;

public class Decoder extends Alphabet {

    private String output;

    public Decoder(String text, int k) {

        String input = text;
        StringBuilder dec = new StringBuilder();

        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);

            if (isEnglishLetter(c)) {
                int x = (putEnglishChar(c) - k + LETTERS_ENG) % LETTERS_ENG;

                if (Character.isUpperCase(c)) {
                    dec.append(englishAlphabet[x]);
                } else {
                    dec.append(Character.toLowerCase(englishAlphabet[x]));
                }

                continue;
            }

            if (isCyrillicLetter(c)) {
                int x = (putCyrillicChar(c) - k + LETTERS_CYR) % LETTERS_CYR;

                if (Character.isUpperCase(c)) {
                    dec.append(cyrillicAlphabet[x]);
                } else {
                    dec.append(Character.toLowerCase(cyrillicAlphabet[x]));
                }

                continue;
            }

            if (!isEnglishLetter(c) && !isCyrillicLetter(c)) {
                dec.append(c);
            }
        }

        output = dec.toString();
    }

    public Decoder(Encoder enc) {
        int k = enc.getK();
        String input = enc.getEncText();

        Decoder dec = new Decoder(input, k);
        output = dec.getDecText();
    }

    public String getDecText() {
        return output;
    }

}
