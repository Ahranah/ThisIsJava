package ch15.mission;

public class Account {
    private String id;
    private int balance;
    private int amount;
    private String name;

    public Account(String id, int balance, String name) {
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    public void withdraw(int amount) {
        if (amount < 0) throw new IllegalArgumentException("출금액은 음수가 될 수 없습니다.");
        if (balance < amount) throw new IllegalArgumentException("잔액이 부족합니다.");
        balance -= amount;
    }

    public void deposit(int amount) {
        if (amount < 0) throw new IllegalArgumentException("입금액은 음수가 될 수 없습니다.");
        balance += amount;
    }

    public Account getInfo() {
        return new Account(id, balance, name);
    }

    public String getName() {
        return name;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", balance: " + balance;
    }
}
