package lesson3;

import java.io.*;
import java.util.Scanner;

public class DataStingApp {
    public static void main(String[] args) {
        File file = new File("demo.txt");

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeUTF("writeUTF");
            dataOutputStream.writeInt(42);
        } catch (IOException ex) {
            ex.printStackTrace();
        }



//        DataInputStream dataInputStream;
//        dataInputStream.available();  остановка
//        Scanner scanner = new Scanner(); // можно сувать туда файлики

    }
}
