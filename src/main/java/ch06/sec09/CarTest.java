package ch06.sec09;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car("BMW");
        car.setSpeed(30);
        car.run();

        Car car2 = new Car("KIA");
        car2.setSpeed(20);
        car2.run();

        int diff = car.getSpeed() - car2.getSpeed();
        System.out.println("두 차의 시속 차이는 "+ diff+ "입니다.");
    }
}
