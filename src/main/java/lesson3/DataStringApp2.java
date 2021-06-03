package lesson3;

import java.io.*;
import java.util.Scanner;

public class DataStringApp2 {
    public static void main(String[] args) {
        String str = "nick";
        File file = new File("demo2" + str +".txt");

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file,true))) {
            dataOutputStream.writeUTF("writeUTF" + str + "kuku");
        } catch (IOException ex) {
            ex.printStackTrace();
        }



//        DataInputStream dataInputStream;
//        dataInputStream.available();  остановка
//        Scanner scanner = new Scanner(); // можно сувать туда файлики

    }
}
