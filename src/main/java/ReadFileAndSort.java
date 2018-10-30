import java.io.*;
import java.util.*;

public class ReadFileAndSort {
    //String defaultPath = "C:/study/file.txt";
    String[] splitResult;
    Map<String, Integer> exclusiveWords = new HashMap<>();

    public ReadFileAndSort(String defaultPath) throws IOException {
        readFromFile(defaultPath);
        countRepeat(splitResult);
        maxCount(exclusiveWords);
    }

    /**
     * читаем файл в массив, сортируем
     *
     * @param defaultPath
     * @throws IOException
     */
    public void readFromFile(String defaultPath) throws IOException {
        try {
            System.out.println("Слова из файла:");
            String strLine;
            FileInputStream fstream = new FileInputStream(defaultPath);
            BufferedReader br = new BufferedReader(new InputStreamReader((fstream), "Cp1251"));
            while ((strLine = br.readLine()) != null) {
                splitResult = strLine.split(" ");
                Arrays.sort(splitResult);
                System.out.println(Arrays.toString(splitResult) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }

    /**
     * считаем количество повторений каждого слова в массиве
     *
     * @param splitResult - сортированный массив
     */
    public void countRepeat(String[] splitResult) {
        System.out.println("Количество повторений слов:");
        Set<String> wordsSet = new HashSet<String>(Arrays.asList(splitResult));
        for (String word : wordsSet) {
            int count = 0;
            for (String w : splitResult) {
                if (word.equals(w)) count++;
            }
            exclusiveWords.put(word, count);
            System.out.println(word + " - " + count);
        }
    }

    /**
     * выбираем слово с максимальным количеством повторений
     *
     * @param exclusiveWords
     */
    public void maxCount(Map<String, Integer> exclusiveWords) {
        int maxValueInMap = (Collections.max(exclusiveWords.values()));
        for (Map.Entry<String, Integer> entry : exclusiveWords.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                System.out.print("\nСлово с максимальным количеством повторений: " + entry.getKey() + "\nКоличество повторений: " + entry.getValue());
            }
        }
    }
}

