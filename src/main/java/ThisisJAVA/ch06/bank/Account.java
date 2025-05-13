package ThisisJAVA.ch06.bank;

public class Account {
    static final int MIN_BALANCE = 0;
    static final int MAX_BALANCE = 1000000;

    String accountNum;
    String accountOwner;
    int balance, withdraw, deposit;

    Account(String accountNum, String accountOwner, int deposit) {
        this.accountNum = accountNum;
        this.accountOwner = accountOwner;
        this.balance = deposit;
        System.out.println("결과: 결과가 생성되었습니다.");
    }

    String getAccountNum() {
        return this.accountNum;
    }

    String getAccountOwner() {
        return this.accountOwner;
    }

    int getBalance() {
        return this.balance;
    }


    void deposit(int deposit) {
        if (deposit < MIN_BALANCE || deposit > MAX_BALANCE) {
            System.out.println("cannot deposit to the account.");
        } else {
            this.balance += deposit;
            System.out.println("deposit completed successfully.");
        }
    }

    void withdrawal(int withdraw) {
        if (balance - withdraw < MIN_BALANCE || withdraw > MAX_BALANCE) {
            System.out.println("failed to withdraw from the account.");
        } else {
            this.balance -= withdraw;
            System.out.println("withdrawal completed successfully.");
        }
    }

}
