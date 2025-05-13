package ch06.advanced.singleton;

public class DatabaseExample {
    public static void main(String[] args) {


        String dbConnect = Database.connect();


        System.out.println("데이터베이스: " + dbConnect);
        Database.close();

    }
}
