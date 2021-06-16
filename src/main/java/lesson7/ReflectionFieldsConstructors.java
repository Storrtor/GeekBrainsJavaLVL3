package lesson7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectionFieldsConstructors {

    public static void main(String[] args) {
        Class clazz = TestClass.class;
        //Узнать поля класса (публичные) getFields
        //Узнать все поля getDeclaredFields
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType().getSimpleName() + " " + field.getName());
        }

        try {
            Field field = clazz.getField("name");
            System.out.println(field.getType().getSimpleName() + " " + field.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println("-----");

        try {
            TestClass test = new TestClass();
            System.out.println(test);
            Field field = clazz.getField("number");
            field.set(test, 11);
            System.out.println(test);
            System.out.println(field.get(test));

            //Можно писать в приватные поля через рефлексию
            //В финальные поля через рефлексию писать НЕЛЬЗЯ
            Field privateField = clazz.getDeclaredField("privateString");
            privateField.setAccessible(true);  //иначе в приватное поле писать нельзя
            privateField.set(test, "private");
            System.out.println(test);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("-----");
        //Можно посмотреть конструкторы getConstructors - только публичные
        // getDeclaredConstructioins - все конструкторы (и приватные тоже)
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-----");
        //Получение конструктора по типу аргументов
        try {
            Constructor constructor = clazz.getDeclaredConstructor(new Class[]{String.class, int.class});
            System.out.println(constructor);
            constructor.setAccessible(true);

            //создать обьект исходя из контруктора и кастануть
            //создавать обьект после явного получения конструктора
            TestClass tc = (TestClass) constructor.newInstance("String", 5);
            System.out.println(tc);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }




    }



}
