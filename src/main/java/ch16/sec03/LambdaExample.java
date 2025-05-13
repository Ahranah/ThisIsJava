package ch16.sec03;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        person.action1((x, y)-> {
            System.out.println(x + "is doing" + y );
        });

        //매개변수가 한 개일 경우
        person.action2( word -> {
            System.out.println("\\" + word + "\\/");
            System.out.println(word);
        });

    }
}
