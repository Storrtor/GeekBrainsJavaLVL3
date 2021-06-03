package lesson3;

import java.io.*;
import java.util.Arrays;

public class SerializeApp {

    //out пишем
    //in читаем

    public static void main(String[] args) {

        Bike bike = new Bike("Canyon");
        bike.setSerialNo("111111111111");

        System.out.println("Наш велосипед " + bike);
        byte[] bytes = null;

        try (
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  //складываем байты
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        ) {
            objectOutputStream.writeObject(bike);
            bytes = byteArrayOutputStream.toByteArray();  //финализируем в массив из стрима
            System.out.println("Наш сериализованный велосипед " + Arrays.toString(bytes));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        ) {
            Bike deserializedBike = (Bike) objectInputStream.readObject();
            System.out.println("Велосипед, считанный из файла " + deserializedBike);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
