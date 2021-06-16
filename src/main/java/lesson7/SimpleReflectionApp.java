package lesson7;

import lesson3.Bike;

import java.lang.reflect.Modifier;

public class SimpleReflectionApp {

    public static void main(String[] args) {
        //Загружены класс лоадером со старта
        Class clazz = "String".getClass();
        Class integerClass = Integer.class;
        Class stringClass = String.class;
        Class intClass = int.class;
        Class voidClass = void.class;
        Class arrayInt = int[].class;

        Class sqlClass;
//        try {
//            sqlClass = Class.forName("org.sqlite.jdbc");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        //Можно посмотреть имя класса и пакет
        Class bikeClass = Bike.class;
        System.out.println(bikeClass.getName());    //с пакетом
        System.out.println(bikeClass.getSimpleName());  //без пакета


        //Можно посмотреть модификаторы доступа
        int modifiers = clazz.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            System.out.println(clazz.getSimpleName() + " is public");
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.println(clazz.getSimpleName() + " is abstract");
        }
        if (Modifier.isFinal(modifiers)) {
            System.out.println(clazz.getSimpleName() + " is final");
        }

        System.out.println("--------");
        //Показывает все интерфейсы класса TestClass
        Class interfaceClass = TestClass.class;
        Class[] interfaces = interfaceClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }

        System.out.println("--------");
        //Напишет дерево наследования
        Class parentClass = TestTestTestClass.class;
        while (parentClass != null) {
            System.out.println("Class is " + parentClass.getSimpleName());
            parentClass = parentClass.getSuperclass();
        }


    }
}
