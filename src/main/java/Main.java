import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String defaultPath = "C:/study/file.txt";
        System.out.print("Файл с входными данными должен называться 'file.txt'. \nРасположение файла: C:/study/ \nЕсли все верно, введите 'Да': ");

        Scanner scaner = new Scanner(System.in);
        String answer = scaner.nextLine();
        scaner.close();

        switch (answer) {
            case "да":
                ReadFileAndSort rfas = new ReadFileAndSort(defaultPath);
                break;
            default:
                System.out.println("Подготовьте файл с входящими данными и повторите попытку.");
                break;
        }
    }
}

