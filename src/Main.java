import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.String.format;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter path to .txt file: ");
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        String maxLengthStr = getMaxLengthStringFromFile(path);
        System.out.println(format("Longest string line without the spaces: %s", maxLengthStr));
        char charStr = getCharAtMiddleIndex(maxLengthStr);

        System.out.println(format("Middle letter: %s", charStr));

        System.out.println(format("Write a word that starts for: %s", charStr));

        String word = scanner.nextLine();
        check(charStr, word);

        scanner.close();
    }

    /**
     * Method receives address file in the file system and returns the string of the maximum length of the specified file
     *
     * @param path address file in the file system
     * @return the string of the maximum length of the specified file
     */
    private static String getMaxLengthStringFromFile(String path) {
        String maxLengthStr = "";
        String maxLengthStrWithSpaces = "";
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> mapWhitSpaces = new HashMap<>();
        File file = new File(path);

        try (Scanner scanner = new Scanner(file)) {
            String stringFromFileWithSpaces = null;
            String stringFromFile = null;

            while (scanner.hasNext()) {
                stringFromFileWithSpaces = scanner.nextLine();
                stringFromFile = stringFromFileWithSpaces.trim().replace(" ", "");
                map.put(stringFromFile, stringFromFile.length());
                mapWhitSpaces.put(stringFromFile, stringFromFileWithSpaces);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxLengthStr.length()){
                    maxLengthStr = entry.getKey();
                    maxLengthStrWithSpaces = mapWhitSpaces.get(maxLengthStr);
                }

            }
            System.out.println(format("Longest string line with the spaces: %s", maxLengthStrWithSpaces));
            return maxLengthStr;
        } catch (IOException e) {
            System.err.println("Error in process reading file");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method checks whether the word starts with the specified character and prints a message
     *
     * @param charStr character
     * @param word
     */
    private static void check(char charStr, String word) {
        if (word.startsWith(String.valueOf(charStr)))
            System.out.println("Well done. You are the greatest!");
        else
            System.out.println(format("Sorry, this word doesn't start for %s", charStr));
    }

    /**
     * Method calculates the index of the central line item and returns that element
     *
     * @param string
     * @return central line item
     */
    private static char getCharAtMiddleIndex(String string) {
        int index;
        if (string.length() % 2 == 0)
            index = string.length() / 2;
        else
            index = string.length() / 2 + 1;
        return string.charAt(index - 1);
    }
}
