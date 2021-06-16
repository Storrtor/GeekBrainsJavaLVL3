package lesson7;

import lesson2.Bike;

import java.io.Serializable;

@MarkingAnnotation
public class TestClass implements Serializable, AutoCloseable {

    public String name;
    public int number;
    public Bike bike;
    private String privateString;

    private TestClass(String name) {
        this.name = name;
    }

    public TestClass(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public TestClass(String name, int number, Bike bike, String privateString) {
        this.name = name;
        this.number = number;
        this.bike = bike;
        this.privateString = privateString;
    }

    public TestClass() {
    }

    @MarkingAnnotation(value = 31)
    private int calculate(int a, String s) {
        System.out.println("Calculating...");
        return number;
    }

    public String getPrivateString() {
        return privateString;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", bike=" + bike +
                ", privateString='" + privateString + '\'' +
                '}';
    }
}
