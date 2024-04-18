import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Picnic {
    public static void main(String[] args) {
        try {
            int count = Word_count("input.txt");
            System.out.println("Кол-во слов: " + count);
            String longest_word = Longest_word("input.txt");
            System.out.println("Самое длинное слово: " + longest_word);
            HashMap <String,Integer> word_Analysis = Word_Analysis("input.txt");
            System.out.println("Продукты:");
            for (Map.Entry<String, Integer> entry : word_Analysis.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e);
        }
    }

    public static int Word_count(String filename) throws IOException {
        File file = new File(filename);
        Scanner iScanner = new Scanner(file);
        int count = 0;
    
        while (iScanner.hasNext()) {
            String line = iScanner.nextLine();
            String[] words = line.split(" ");
            count += words.length;
        }
            iScanner.close();
            return count;
    }

    public static String Longest_word(String filename) throws IOException{
        File file = new File(filename);
        Scanner iScanner = new Scanner(file);
        String max = "";
            while (iScanner.hasNext()) {
                String line = iScanner.nextLine();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.length() > max.length()) {
                        max = word;
                    }
                }
            }

        iScanner.close();
        return max;
    }

    public static HashMap<String,Integer> Word_Analysis(String filename) throws IOException{
        File file = new File(filename);
        Scanner iScanner = new Scanner(file);
        HashMap<String, Integer> wordCounts = new HashMap<>();
        while (iScanner.hasNext()) {
            String line = iScanner.nextLine();
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (wordCounts.containsKey(word)) {
                    // Если слово уже есть в HashMap, увеличиваем счетчик
                    wordCounts.put(word, wordCounts.get(word) + 1);
                } else {
                    // Если слова нет в HashMap, добавляем его со значением 1
                    wordCounts.put(word, 1);
                }
            }  
        }
        iScanner.close();
        return wordCounts;
    }
}
