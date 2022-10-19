package encryption;

import java.util.ArrayList;
import java.util.List;

public class StaticAnalysis extends Alphabet {

    public int bruteForce(String txtToDecode, String exampleTxt) {
        int key = 0;


        List<String> listTextToDecode = findThreeLettersWord(txtToDecode);
        List<String> listTextExample = findThreeLettersWord(exampleTxt);


        for (String word : listTextToDecode) {


            for (String wordEx : listTextExample) {

                int numb1 = word.charAt(0) - wordEx.charAt(0);
                if (numb1 < 0 && isEnglishLetter(word.charAt(0))) {
                    numb1 += LETTERS_ENG;
                } else if (numb1 < 0 && isCyrillicLetter(word.charAt(0))) {
                    numb1 += LETTERS_CYR;
                }
                int numb2 = word.charAt(1) - wordEx.charAt(1);
                if (numb2 < 0 && isEnglishLetter(word.charAt(1))) {
                    numb2 += LETTERS_ENG;
                } else if (numb2 < 0 && isCyrillicLetter(word.charAt(1))) {
                    numb2 += LETTERS_CYR;
                }
                int numb3 = word.charAt(2) - wordEx.charAt(2);
                if (numb3 < 0 && isEnglishLetter(word.charAt(2))) {
                    numb3 += LETTERS_ENG;
                } else if (numb3 < 0 && isCyrillicLetter(word.charAt(2))) {
                    numb3 += LETTERS_CYR;
                }
                if (numb1 == numb2 && numb1 == numb3) {
                    key = numb1;
                    break;
                }
            }
        }

        return key;
    }

    public static List<String> findThreeLettersWord(String text) {
        String[] subStringTemp = text.split(" ");
        List<String> threeLettersList = new ArrayList<>();
        for (String s : subStringTemp) {
            if (s.length() == 3) {
                threeLettersList.add(s);
            }
        }
        return threeLettersList;
    }


}
