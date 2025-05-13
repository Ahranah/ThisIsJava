package ch06.sec07.exam04;

public class CarExample {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("자가용");
        Car car3 = new Car("자가용", "빨강");
        Car car4 = new Car("택시", "검정", 200);
        Car car5 = new Car("버스", "핑크", 500);

        System.out.println("car1.company: " + car1.company + "\n");

        System.out.println("car2.company: " + car2.company);
        System.out.println("car2.model: " + car2.model+"\n");

        System.out.println("car3.company: " + car3.company);
        System.out.println("car3.model: " + car3.model);
        System.out.println("car3.color: " + car3.color+"\n");

        System.out.println("car4.company: " + car4.company);
        System.out.println("car4.model: " + car4.model);
        System.out.println("car4.color: " + car4.color);
        System.out.println("car4.model: " + car4.model);

        System.out.println("car5.company: " + car5.company);
        System.out.println("car5.model: " + car5.model);
        System.out.println("car5.color: " + car5.color);
        System.out.println("car5.model: " + car5.model);
    }
}
