package lesson5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class CollectionsApp {

    // Дано
    // 1 писатель
    // 10 читателей

    public static void main(String[] args) {

        List<String> list = Collections.synchronizedList(new ArrayList<>()); //синхронизированный лист

        //блокируется только тот бакет, в который происходит запись
        //читается из остальных параллельно
        Map<String, String> map = new ConcurrentHashMap<>();

        //не очень оптимально для большого письма, очень оптимально, если редко пишем и много читаем
        List<String> concurrentList = new CopyOnWriteArrayList<>();

    }
}
