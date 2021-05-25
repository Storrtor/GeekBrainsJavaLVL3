package lesson1;

public class TwoTypedBox <T, U>{
    private final T fisrt;
    private final U second;

    public TwoTypedBox(T fisrt, U second) {
        this.fisrt = fisrt;
        this.second = second;
    }

    public T getFisrt() {
        return fisrt;
    }

    public U getSecond() {
        return second;
    }

    public void showTypes(){
        System.out.println("Tape of T = " + fisrt.getClass().getName());
        System.out.println("Tape of U = " + second.getClass().getName());
    }
}
