import java.util.List;
import java.util.Scanner;

public class Menu2 {
    static boolean menu2(boolean isExit, Scanner sel){
        while (!isExit) {
            System.out.println("------------------------------");
            System.out.println("1. 입금");
            System.out.println("2. 출금");
            System.out.println("3. 잔고확인");
            System.out.println("4. 처음으로");

            String userSelect;
            userSelect = sel.nextLine();
            if (userSelect.equals("1")) {
                System.out.println("입금 하겠습니다. 아래와 같이 입력해 주세요");
                BalanceMoney balanceMoney = new BalanceMoney();
                balanceMoney.inMoney();
                return true;
            } else if (userSelect.equals("2")) {
                System.out.println("출금 하겠습니다. 아래와 같이 입력해 주세요");
                return true;
            } else if (userSelect.equals("3")) {
                try {
                    new User().getMoney();
                    return true;
                } catch (NullPointerException e) {
                    System.out.println("잔고가 없습니다.");
                }
            } else if (userSelect.equals("4")) {
                System.out.println("처음으로");
                return false;
            }
            }
        return false;
    }
}
