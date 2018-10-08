package pod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String key = "vigenere";
        String text = "Algorytmy i Struktury Danych";

        encrypt(key, text);
    }
    static void encrypt(String key, String text){
        text = text.replaceAll("\\s", "").toLowerCase();
        List<Character> cipher = new ArrayList<Character>(text.length());
        List<Character> passphase = new ArrayList<Character>(text.length());

        for(int i = 0, n = 0; i < text.length(); i++, n++){
            if(n == key.length()) n = 0;
            passphase.add(key.charAt(n));
        }
        cipher.add(passphase.get(0));
        for(int i = 1, shift, newChar; i < text.length(); i++){
            shift = passphase.get(i)-97;
            newChar = (int)text.charAt(i)+shift;
            if(newChar > 122) newChar = 96+newChar-122;
            cipher.add((char)newChar);
            //System.out.println(text.charAt(i) + "->" + cipher.get(i) + "(" + (int)cipher.get(i) + ") ");
        }

        System.out.println(cipher);
        //System.out.println(passphase);
    }
}
