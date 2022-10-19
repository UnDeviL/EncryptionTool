package encryption;

public class Alphabet {

    protected static final int LETTERS_ENG = 25;
    protected static final int LETTERS_CYR = 32;

    protected static char[] englishAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'};

    protected static char[] cyrillicAlphabet = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж',
            'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У',
            'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};

    public int putEnglishChar(char c) {
        int rez = -1;

        for (int i = 0; i < englishAlphabet.length; ++i) {
            if (Character.toUpperCase(c) == englishAlphabet[i])
                rez = i;
        }
        return rez;
    }

    public int putCyrillicChar(char c) {
        int rez = -1;

        for (int i = 0; i < cyrillicAlphabet.length; ++i) {
            if (Character.toUpperCase(c) == cyrillicAlphabet[i])
                rez = i;
        }
        return rez;
    }

    public static boolean isCyrillicLetter(char c) {
        int i = c;

        return i >= 1040 && i <= 1103 || i == 1105 || i == 1025;
    }

    public static boolean isEnglishLetter(char c) {
        int i = c;

        return i >= 65 && i <= 122;
    }

}
