package pod;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.nio.file.*;
/**
 * The pod_lab1 program implements
 * my version of Vigenere Cipher.
 *
 * @author Paweł Korczak
 * @version 1.0
 * @since 08.10.2018
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println();
        String text = new String(Files.readAllBytes(Paths.get("tekst.txt")));
        System.out.print("Podaj hasło: ");
        Scanner userInput = new Scanner(System.in);
        String key = userInput.nextLine().toLowerCase();

        //dane testowe
        //String key = "vigenere";
        //String text = "Algorytmy i Struktury Danych";

        encrypt(key, text);
    }
    static void encrypt(String key, String text) throws IOException {
        text = text.replaceAll("\\s", "").toLowerCase();
        String cipher = "";
        String passphase = "";

        for(int i = 0, n = 0; i < text.length(); i++, n++){
            if(n == key.length()) n = 0;
            passphase+=key.charAt(n);
        }

        for(int i = 0, shift, newChar; i < text.length(); i++){
            shift = passphase.charAt(i)-97;
            newChar = (int)text.charAt(i)+shift;
            if(newChar > 122) newChar = 96+newChar%122;
            cipher+=(char)newChar;
            System.out.println(text.charAt(i) + "->" + cipher.charAt(i) + "(ascii: " + (int)cipher.charAt(i) + ") ");
        }

        System.out.println("Szyfr: " + cipher);
        System.out.println("Klucz: " + passphase);
        Path file = Paths.get("szyfr.txt");
        Path file2 = Paths.get("szyfr.sec");
        System.out.println("Zapisywanie...");
        Files.write(file, cipher.getBytes(StandardCharsets.UTF_8));
        System.out.println("Zapisano plik o nazwie \"" + file.getFileName() + "\"");
        Files.write(file2, cipher.getBytes(StandardCharsets.UTF_8));
        System.out.println("Zapisano plik o nazwie \"" + file2.getFileName() + "\"");
    }
}
