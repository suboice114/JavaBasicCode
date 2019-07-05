package JavaDesignPatterns.Factory;

public class FactoryTest {
    public static void main(String[] args) {
        Car car = StaticFactory.getCar("aodi");
        System.out.println(car);
    }
}
