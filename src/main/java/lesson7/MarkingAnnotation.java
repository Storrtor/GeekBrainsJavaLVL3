package lesson7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// SOURCE - АНОТАЦИЯ В ПРОЦЕССЕ КОМПИЛЯЦИИ
// CLASS -
// RUNTIME - В РАНТАЙМЕ ЧЕРЕЗ РЕФЛЕКШЕН

@Retention(RetentionPolicy.RUNTIME)  // - то где будет использоваться наша аннотация
@Target({ElementType.METHOD, ElementType.TYPE})  // куда вешаем аннотацию
public @interface MarkingAnnotation { //Аннтоация - @
    int value() default 8;

}
