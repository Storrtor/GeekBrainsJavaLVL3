package lesson7;

public class SimpleTask {

    public static void main(String[] args) {
        if(method1(true) || method2(true)){  // || ИЛИ - любое из двух, | - проверяет два
            System.out.println(true);
        }

        System.out.println("----");

        if(method1(true) & method2(true)){  // || ИЛИ - любое из двух, | - проверяет два
            System.out.println(true);
        }

    }

    static boolean method1(boolean bool) {
        System.out.println("method1");
        return bool;
    }

    static boolean method2(boolean bool) {
        System.out.println("method2");
        return bool;
    }

    //Метод выведет максимум из массива.
    //Если максимум отрицательный, то кинет исключение.
    //Если массив пустой, то тоже исключение

    public int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array should not be empty");
        }
        int max = array[0];
        for (int i : array) {
            max = Math.max(i, max);
        }

        if(max < 0) {
            throw new IllegalStateException("Max is less than zero");
        }
        return max;
    }
}
