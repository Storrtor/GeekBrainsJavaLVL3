package lesson7;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionAnnotation {
    public static void main(String[] args) {
        Class clazz = TestClass.class;
        //Получение аннотации
        MarkingAnnotation annotation = (MarkingAnnotation) clazz.getAnnotation(MarkingAnnotation.class);

        System.out.println(annotation);

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if(method.getAnnotation(MarkingAnnotation.class) == null) {
                continue;
            }
            System.out.println(method.getName() + Arrays.toString(method.getParameterTypes()));
        }
    }
}
