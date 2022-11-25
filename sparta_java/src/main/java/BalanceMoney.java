import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BalanceMoney {
    int money;
    DateTimeFormatter formatter;
    String dealDateTime;
    Scanner sc;

    public BalanceMoney() {
        this.money = User.getMyAccount().money;
        this.formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
        this.dealDateTime = this.formatter.format(LocalDateTime.now());
        this.sc = new Scanner(System.in);
    }

    void inMoney() {
        System.out.println("\n입금하실 금액을 입력해 주세요.");
        int inMoney = this.sc.nextInt();
        System.out.println("\n========== 입금 진행 중입니다. ==========\n");
        this.money += inMoney + (int)((double)inMoney * 0.001);
        User.setMyAccountMoney(this.money);
        this.money = User.getMyAccount().money;
        System.out.println("---------- 적용 이율은 0.1%입니다. ----------");
        System.out.println("- " + inMoney + "원이 입금되었습니다.");
        System.out.println("- 현재 잔액은 " + this.money + "원입니다.");
        System.out.println("- 거래 일자 및 시간 : " + this.dealDateTime + "\n");
    }

    void outMoney() {
        System.out.println("\n출금하실 금액을 입력해 주세요");
        int outMoney = this.sc.nextInt();
        System.out.println("\n========== 출금 진행 중입니다. ==========\n");
        this.money -= outMoney + 500;
        User.setMyAccountMoney(this.money);
        this.money = User.getMyAccount().money;
        System.out.println("---------- 수수료 500원이 차감됩니다. ----------");
        System.out.println("- " + outMoney + "원이 출금되었습니다.");
        System.out.println("- 현재 잔액은 " + this.money + "원입니다.");
        System.out.println("- 거래 일자 및 시간 : " + this.dealDateTime + "\n");
    }
}