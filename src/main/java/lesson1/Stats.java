package lesson1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Stats<T extends Number & Serializable> { //может быть несколько интерфейсов
    private static final double EPSILON = 0.00001;
//    private static final T CONSTANT = 10;     //нельзя использовать в стат полях
    private final T[] numbers;

    public Stats(T... numbers) {
        this.numbers = numbers;
    }

    double avg() {
        double sum = 0.0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i].doubleValue();
        }
        return sum/ numbers.length;
    }

    public boolean sameAvg(Stats<? extends Number> another){
        return Math.abs(this.avg() - another.avg()) < EPSILON;
    }

    public List<? extends T> getElements(){
//        T t = new T();                       нельзя
        return Arrays.asList(numbers);
    }

//    public static T getSomething(){     стат методы нельзя
//        return new T();                 новый Т нельзя делать, кто знает что внутри
//    }
}

/**
 * PECS - Producer Extends Consumer Super - паттерн
 */

//PECS - паттерн

//public class Stats<T > {
//    private final Number[] numbers;
//
//    public Stats(Number[] numbers) {
//        this.numbers = numbers;
//    }
//
//    double avg() {
//        double sum = 0.0;
//        for (int i = 0; i < numbers.length; i++) {
//            sum += numbers[i].doubleValue();
//        }
//        return sum/ numbers.length;
//    }
//}

