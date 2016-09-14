import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter path to .txt file: ");

       try(BufferedReader  consoleReader = new BufferedReader(new InputStreamReader(System.in))){
           String path = consoleReader.readLine();

           String maxLengthStr = getMaxLengthStringFromFile(path);
           char charStr = getCharAtMiddleIndex(maxLengthStr);

           System.out.println(format("Write a word that starts for: %s", charStr));

           String word = consoleReader.readLine();
           check(charStr, word);
       } catch (IOException e) {
           System.err.println("Error in process reading from console");
           e.printStackTrace();
       }

    }

    /**
     * Method receives address file in the file system and returns the string of the maximum length of the specified file
     * @param path address file in the file system
     * @return the string of the maximum length of the specified file
     */
    private static String getMaxLengthStringFromFile(String path) {
        String maxLengthStr = "";
        Map<String, Integer> map = new HashMap<>();
        File file = new File(path);

       try(BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
           String stringFromFile = null;

           while ((stringFromFile = fileReader.readLine()) != null) {
               stringFromFile = stringFromFile.trim().replace(" ", "");
               map.put(stringFromFile, stringFromFile.length());
           }

           for (Map.Entry<String, Integer> entry : map.entrySet()) {
               if (entry.getValue() > maxLengthStr.length())
                   maxLengthStr = entry.getKey();
           }

           return maxLengthStr;
       } catch (IOException e) {
           System.err.println("Error in process reading file");
           e.printStackTrace();
           return null;
       }
    }

    /**
     * Method checks whether the word starts with the specified character and prints a message
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
