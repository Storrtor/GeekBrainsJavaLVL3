package lesson1;

/**
 * Требуется контейнер для хранения обьектов разного типа
 */
// POJO - Plain Old Java Object   (старый добрый джава обьект)
public class SimpleBox {
    private final Object object;

    public SimpleBox(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }




}
