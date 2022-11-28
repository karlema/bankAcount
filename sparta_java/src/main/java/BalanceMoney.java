import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BalanceMoney {
    Scanner sc;
    int money;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
    //    String dealDateTime = formatter.format(LocalDateTime.now());
    String dealStatus;
    List<History> dealHistory;

<<<<<<< HEAD
    public BalanceMoney() {
        sc = new Scanner(System.in);
        money = User.getMyAccount().money;
//        formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
//        dealDateTime = formatter.format(LocalDateTime.now());
        dealHistory = new ArrayList<>();
=======
    public BalanceMoney(User user) {
        this.sc = new Scanner(System.in);
        this.money = user.getMyAccount().money;
        this.formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
        this.dealDateTime = this.formatter.format(LocalDateTime.now());
        this.dealHistory = new ArrayList<>();
>>>>>>> main
    }

    void inMoney(User user) {
        dealStatus = "입금";

        System.out.print("입금하실 금액을 입력해 주세요.\n> ");
        int inMoney = this.sc.nextInt();

        System.out.println("\n========== 입금 진행 중입니다. ==========\n");

<<<<<<< HEAD
        money += inMoney + (int)((double)inMoney * 0.001);
        User.setMyAccountMoney(this.money);
        money = User.getMyAccount().money;
        String dealDateTime = formatter.format(LocalDateTime.now());

        dealHistory.add("거래 일자 및 시간 : " + dealDateTime);
        dealHistory.add("계좌 번호 : " + "123-456-789");
        dealHistory.add("거래 종류 : " + dealStatus);
        dealHistory.add("거래 금액 : " + inMoney + "원");
        dealHistory.add("은행명 : " + "KB");

=======
        this.money += inMoney + (int)((double)inMoney * 0.001);
        user.setMyAccountMoney(this.money);
        this.money = user.getMyAccount().money;
//        [ {dealDateTime, "123-456-789" }, {dealDateTime, "123-456-789" }, {dealDateTime, "123-456-789" }]
        History history = new History(dealDateTime, "123-456-789");
        dealHistory.add(history);
//        dealHistory.add("거래 일자 및 시간 : " + dealDateTime);
//        dealHistory.add("계좌 번호 : " + "123-456-789");
//        dealHistory.add("거래 종류 : " + dealStatus);
//        dealHistory.add("거래 금액 : " + inMoney + "원");
//        dealHistory.add("은행명 : " + "KB");
        for (int i = 0; i <= dealHistory.size() - 1; i++) { // 한 건씩 추출
            System.out.println(dealHistory.get(i).dealDateTime);
            System.out.println(dealHistory.get(i).accountNumber);
        }
>>>>>>> main
        System.out.println("---------- 적용 이율은 0.1%입니다. ----------");
        System.out.println("- " + inMoney + "원이 입금되었습니다.");
        System.out.println("- 현재 잔액은 " + money + "원입니다.");
        System.out.println("- 거래 일자 및 시간 : " + dealDateTime + "\n");
    }

    void outMoney(User user) {
        dealStatus = "출금";

        System.out.print("출금하실 금액을 입력해 주세요.\n> ");
        int outMoney = sc.nextInt();

        System.out.println("\n========== 출금 진행 중입니다. ==========\n");

        money = user.getMyAccount().money;

        money -= outMoney + 500;

        if (money <= 0) {
            System.out.println("잔액이 부족합니다.\n");
            return;
        }

<<<<<<< HEAD
        User.setMyAccountMoney(money);
        money = User.getMyAccount().money;
        String dealDateTime = formatter.format(LocalDateTime.now());
=======
        user.setMyAccountMoney(this.money);
        this.money = user.getMyAccount().money;
>>>>>>> main

//        dealHistory.add("거래 일자 및 시간 : " + dealDateTime);
//        dealHistory.add("계좌 번호 : " + "123-456-789");
//        dealHistory.add("거래 종류 : " + dealStatus);
//        dealHistory.add("거래 금액 : " + outMoney + "원");
//        dealHistory.add("은행명 : " + "KB");

        System.out.println("---------- 수수료 500원이 차감됩니다. ----------");
        System.out.println("- " + outMoney + "원이 출금되었습니다.");
        System.out.println("- 현재 잔액은 " + money + "원입니다.");
        System.out.println("- 거래 일자 및 시간 : " + dealDateTime + "\n");
    }

    void dealHistories() {  // 거래 내역 목록
<<<<<<< HEAD
        System.out.println("----------------------------------------");
=======
        System.out.println("거래목록 시작");
>>>>>>> main
        for (int i = 0; i <= dealHistory.size() - 1; i++) { // 한 건씩 추출
                System.out.println(dealHistory.get(i).dealDateTime);
                System.out.println(dealHistory.get(i).accountNumber);
//            if ((i + 1) % 5 == 0) {
//                System.out.println("----------------------------------------");
//            }
        }
        System.out.println("거래목록 끝");
    }
}