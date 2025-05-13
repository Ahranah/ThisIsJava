package ThisisJAVA.ch06.bank;

import java.util.Scanner;

public class BankApplicatioin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean run = true;
        Account[] accounts = new Account[5];
        int accCount = 0;

        while (run) {
            System.out.print(""" 
                    
                    -----------------------------------------------------------------------------------------
                    1. 계좌생성 || 2. 계좌목록 || 3. 예금 || 4. 출금 || 5. 종료
                    -----------------------------------------------------------------------------------------
                    선택> """);

            int select = sc.nextInt();

            if (select == 1) {
                System.out.print("""
                        ---------
                         계좌생성
                        ---------
                        계좌번호:  """);
                String accountNo = sc.next();
                System.out.print("계좌주: ");
                String accountOwner = sc.next();

                boolean exist = false;
                for (int i = 0; i < accCount; i++) {
                    if (accounts[i].getAccountNum().equals(accountNo)) {
                        exist = true;
                        break;
                    }
                }
                if (exist) {
                    System.out.println("이미 존재하는 계좌번호입니다.");
                    continue;
                }
                System.out.print("초기입금액: ");
                int deposit = sc.nextInt();
                accounts[accCount++] = new Account(accountNo, accountOwner, deposit);

            } else if (select == 2) {
                System.out.print("""
                        ---------
                         계좌목록
                        ---------
                        계좌번호:
                        """);

                for (int i = 0; i < accCount; i++) {
                    System.out.println(accounts[i].getAccountNum() + " " + accounts[i].getAccountOwner() + " " + accounts[i].getBalance());
                }

            } else if (select == 3) {
                System.out.print("""
                        ---------
                         예금
                        ---------
                        계좌번호: """);
                String accountNo = sc.next();
                System.out.print("예금액: ");
                int deposit = sc.nextInt();
                for (int i = 0; i < accCount; i++) {
                    if (accounts[i].getAccountNum().equals(accountNo)) {
                        accounts[i].deposit(deposit);
                    }
                }

            } else if (select == 4) {
                System.out.print("""
                        ---------
                         출금
                        ---------
                        계좌번호: """);
                String accountNo = sc.next();
                System.out.print("출금액: ");
                int withdraw = sc.nextInt();
                for (int i = 0; i < accCount; i++) {
                    if (accounts[i].getAccountNum().equals(accountNo)) {
                        accounts[i].withdrawal(withdraw);
                    }
                }
            } else {
                System.out.println("exit the program.");
                run = false;
            }
        }
    }
}


