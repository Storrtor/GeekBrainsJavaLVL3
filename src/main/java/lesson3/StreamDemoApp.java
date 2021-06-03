package lesson3;

import java.io.*;

public class StreamDemoApp {

    public static void main(String[] args) {
        String str = "My String";
        try (FileOutputStream fos = new FileOutputStream(new File("demo.txt"))){  //можно добавить true и будешь дописывать, так перезапись
            fos.write(str.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("demo.txt")) {
            byte[] bytes = new byte[100];
            fis.read(bytes);   //возвращает кол-во байтов;
            System.out.println(new String(bytes));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

//        byte[] bytes = {65, 66, 67};
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//        int x;
//        while ((x = byteArrayInputStream.read()) != -1) {
//            System.out.println(x);
//        }


    }
}
