package lesson3;

import java.io.*;
import java.util.Arrays;

public class BufferedReadApp {

    /**
     * Буферизация нужна для того, чтобы файлик читаля поэтапно и память не заканчивалась. (иначе можно поймать ошибку)
     * Честь читаешь - часть пишешь, дефолт 8192 ограничение, можно ставить свое
     * @param args
     */

    public static void main(String[] args) {
        byte[] bytes = new byte[1024 * 1024];
        Arrays.fill(bytes, (byte) 65);

        File file = new File("demo.txt");

        try (
                FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fos)
        ) {
            for (byte aByte : bytes) {
                bufferedOutputStream.write(aByte);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
        ) {
            int x;
            while ((x = bufferedInputStream.read()) != -1) {
                System.out.println(x);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
