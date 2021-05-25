package lesson1;

/**
 * параметризуем при создании (какого типа создаем)
 * @param <T> - тип (type)
 */
public class TypedBox <T>{

    private final T object;

    public TypedBox(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void showType(){
        System.out.println("TypedBox type is " + object.getClass().getName());
    }
}
