package ch15.mission;

import java.util.*;

public class AccountExample {
    public static void main(String[] args) throws Exception {
        Map<Integer, Account> accounts = new HashMap<>();

        // 추가
        accounts.put(1, new Account(new Date().toString(), 1000, "james"));
        accounts.put(2, new Account(new Date().toString(), 100, "amy"));
        accounts.put(3, new Account(new Date().toString(), 0, "john"));
        accounts.put(4, new Account(new Date().toString(), 5000, "elizabeth"));
        System.out.println("계좌 개수: " + accounts.size());

        // 검색
        boolean found = false;
        for (Map.Entry<Integer, Account> entry : accounts.entrySet()) {
            if (entry.getValue().getName().equals("james")) {
                found = true;
                System.out.println("검색 결과: " + entry.getValue().getInfo());

                // 변경
                entry.getValue().setBalance(5000);
                System.out.println("변경 후: " + entry.getValue().getInfo());
                break;
            }
        }
        if (!found) {
            System.out.println("No james found.");
        }

        if (accounts.containsKey(4)) {
            Account account = accounts.get(4);
            try {
                account.withdraw(5001);  // 실패: 잔액 부족
            } catch (Exception e) {
                System.out.println("에러: " + e.getMessage());
            }

            try {
                account.withdraw(5000);  // 성공
            } catch (Exception e) {
                System.out.println("에러: " + e.getMessage());
            }

            try {
                account.deposit(5001);   // 성공
            } catch (Exception e) {
                System.out.println("에러: " + e.getMessage());
            }

            try {
                account.deposit(-5000);  // 실패: 음수
            } catch (Exception e) {
                System.out.println("에러: " + e.getMessage());
            }

            System.out.println(accounts.get(4).getInfo());
        }

        // 삭제
        accounts.remove(3);
        System.out.println("계좌 개수: " + accounts.size());
    }
}
