import java.io.*;
import java.util.*;

public class Main {

    /*BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        System.out.println("Введите имя файла .present находящегося в каталоге С:/Present/");
        myPresent.readFromFile(defaultPath+brr.readLine()+".present");
        myPresent.print();
    }*/
    public static void main(String[] args) throws IOException {
        //String defaultPath = "C:/study/file.txt";
        String[] splitResult;
        try {
            FileInputStream fstream = new FileInputStream("C:/study/file.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                splitResult = strLine.split(" ");
                Arrays.sort(splitResult);
                System.out.println(Arrays.toString(splitResult)+ "\n");
                //System.out.println(strLine);

                Set<String> wordsSet = new HashSet<String>(Arrays.asList(splitResult));
                Map<String, Integer> exclusiveWords = new HashMap<>();
                for (String word : wordsSet) {
                    int count = 0;
                    for (String w : splitResult) {
                        if (word.equals(w)) count++;
                    }
                    exclusiveWords.put(word, count);
                    System.out.println(word + " - " + count);
                }

               /* exclusiveWords.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed());
                        .forEach(System.out::println);*/
                int maxValueInMap = (Collections.max(exclusiveWords.values()));
                for (Map.Entry<String, Integer> entry : exclusiveWords.entrySet()) {
                    if (entry.getValue() == maxValueInMap) {
                        System.out.print("\nслово с максимальным количеством повторений: " + entry.getKey() + "\nколичество повторений: " +entry.getValue());
                    }
                }
            }
        } catch (
                IOException e) {
            System.out.println("Ошибка");
        }
    }
}

