package lesson7;

public class Singleton { //класс который имеет только один обьект
    //ленивая инициализация
    static Singleton instance;
//    static Singleton instance = new Singleton();  - инициализация обьекта при создании сразу

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
