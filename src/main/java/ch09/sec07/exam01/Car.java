package ch09.sec07.exam01;

public class Car {
    private Tire tire1 = new Tire();
    private Tire tire2 = new Tire(){
        @Override
        public void roll() {
            System.out.println("Anonymous tire2 is rolling");
        }
    };

    // method using field
    public void run1(){
        tire1.roll();
        tire2.roll();
    }

    // method using local variable
    public void run2(){
        // local variable
        Tire tire3 = new Tire(){
            @Override
            public void roll() {
                System.out.println("Anonymous tire3 is rolling");
            }
        };
        tire3.roll();
    }

    // method using parameter
    public void run3(Tire tire){
        tire.roll();
    }
}
