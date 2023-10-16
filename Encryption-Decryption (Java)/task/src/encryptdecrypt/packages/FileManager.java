package encryptdecrypt.packages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    public static String readData(String fileName) {
        File file = new File(fileName);
        String data = "";
        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNext()) {
                data = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        return data;
    }


    public static void writeData(String fileName, String encryptedData) {
        try (FileWriter file = new FileWriter(fileName);) {
            file.write(encryptedData);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}

//FileNotFoundException
