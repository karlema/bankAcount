import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Delete implements AccountDelete{

    @Override
    public void delete() {
        List<Account> accountList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        Account memo1 = new Account("123", "하나", "123", 10, "하나은행");
        Account memo2 = new Account("124", "두나", "1234", 100, "두나은행");
        Account memo3 = new Account("125", "세나", "12345", 1000, "세나은행");
        accountList.add(memo1);
        accountList.add(memo2);
        accountList.add(memo3);

        System.out.println("계좌를 삭제 하겠습니다. 아래와 같이 입력해 주세요");
        System.out.println("\n✨ 계좌번호를 입력해주세요");

        String num = sc.nextLine();
        for (int i = 0; i < accountList.size(); i++) {
            if (num.equals(accountList.get(i).getAccountNumber())) {
                System.out.println("\n✨ 계좌 비밀번호를 입력해주세요");
                String pwd = sc.nextLine();
                if (pwd.equals(accountList.get(i).getPwd())) {
                    System.out.println("\n✨ " + accountList.get(i).getName() + "님의 계좌 번호는 " + accountList.get(i).getAccountNumber() + "이고 잔고는 " + accountList.get(i).getMoney() + "원 입니다.");
                    System.out.println("\n✨ 계좌를 정말 삭제하시겠습니까? ---1번---");
                    System.out.println("\n✨ 메뉴로 돌아가시겠습니까? ---2번---");

                    String selectNum = sc.nextLine();
                    if (selectNum.equals("1")) {
                        accountList.remove(i);
                        System.out.println("\n✨ 계좌가 삭제되었습니다.");
                    } else if (selectNum.equals("2")) {
                        break;
                    }
                } else {
                    System.out.println("\n✨ 비밀번호가 일치하지 않습니다.");
                }
            }
//            else {
//                System.out.println("\n✨ 계좌번호가 존재하지 않습니다."); // ERROR
//            }
        }
    }
}

