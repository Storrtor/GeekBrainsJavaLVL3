import java.util.LinkedList;
import java.util.List;

public class App {

    //На собеседовании
    /** void max K
     *  Список всегда на 100 элементов (101)
     *
     * Последние 100 строк
     * Найти К максимальных элементов в коллекции
     * 1,2,3,4,5 ->
     * k = 2 (4,5)
     * k = 3 (3,4,5)
     */

    public static void main(String[] args) {
//        Queue<String> list = new PriorityQueue<>(); //отсортированный лист (очередь)
        maxK();
//        Queue<String> queue = new PriorityQueue<>();


    }
    public static List<String> maxK() {
        List<String> list = new LinkedList<>();
        int maxSize = 7; //хотим 100 последних (у нас 7)

        //В файле 1000 строк (у нас 20)
        for (int i = 1; i < 21; i++) {
            String s = String.valueOf(i);
            list.add(s);
            if (list.size() > maxSize) {
                list.remove(0);
            }
        }
        System.out.println(list);
        return list;
    }



}




