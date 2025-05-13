package ch06.sec07.exam02;

public class KoreanExample {
    public static void main(String[] args) {
        Korean k1 = new Korean("박자바", "011225-1234567");

        Korean k2 = new Korean("김자바", "930525-0654321");
        Korean k3 = new Korean("정혜인", "546878-2544543");

        System.out.println("k1.nation: " + k1.nation);
        System.out.println("k1.name: " + k1.name);
        System.out.println("k1.ssn: " + k1.ssn+ "\n");

        System.out.println("k2.nation: " + k2.nation);
        System.out.println("k2.name: " + k2.name);
        System.out.println("k2.ssn: " + k2.ssn +"\n");

        System.out.println("k3.nation: " + k3.nation);
        System.out.println("k3.name: " + k3.name);
        System.out.println("k3.ssn: " + k3.ssn);

    }
}
