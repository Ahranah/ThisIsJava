package ch08.sec10.exam02;

public class CastingExample {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();
        vehicle.run();
//        vehicle.checkFare();
//        부모클래스는 자식의 메소드 사용 불가능

        Bus bus = (Bus) vehicle;
        bus.run();
        bus.checkFare();

        Airplane airplane = new Airplane();
        Subway subway = new Subway();

        Driver driver = new Driver();

        driver.drive(airplane);
        driver.drive(subway);
    }
}
