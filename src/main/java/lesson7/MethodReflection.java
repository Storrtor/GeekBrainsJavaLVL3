package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

//Получения набора методов у класса
public class MethodReflection {
    public static void main(String[] args) {
        Class clazz = TestClass.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getReturnType() +
                    " " + declaredMethod.getName() + " "
                    + Arrays.toString(declaredMethod.getParameterTypes()));
        }

        //Получить конкретный метод
        try {
            TestClass testClass = new TestClass();
            Method calcMethod = clazz.getDeclaredMethod("calculate",
                    new Class[]{int.class, String.class});
            System.out.println("Method " + calcMethod.getName());
            calcMethod.setAccessible(true);  //для вызова приватного метода
            calcMethod.invoke(testClass, 5, "str");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }





    }
}
