package ch06.advanced.singleton;

public class Database {
    private final String connection = "MYSQL";

    private static Database database = new Database();

    private Database() {}

    public static String connect() {
        System.out.println(database.connection + "에 연결합니다.");
        return database.connection;
    }

    public static void close(){
        System.out.println(database.connection+"을 닫습니다.");
    }

}
