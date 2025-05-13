package ch07.sec10.exam02;

public class Cat extends Animal {

    @Override
    public void breathe(){
        System.out.println("Cat breathes");
    }

    @Override
    public void sound(){
        System.out.println("야옹");
    }
}
