import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private Account myAccount = null;

    public User() {
    }

    void login(List<Account> bankList) {
        Scanner sc = new Scanner(System.in);

        boolean isFindAccount = false;
        while (!isFindAccount) {
            System.out.print("✨ 계좌번호를 입력해주세요.\n→ ");
            String accountNumber = sc.nextLine();
            for (int i = 0; i < bankList.size(); i++) {
                if (bankList.get(i).accountNumber.equals(accountNumber)) {
                    boolean isSuccess = false;
                    isFindAccount = true;
                    System.out.println("✨ 계좌를 찾았습니다");

                    while (isSuccess != true) {
                        System.out.print("✨ 비밀번호를 입력해주세요.\n→ ");
                        String pwd = sc.nextLine();
                        if (bankList.get(i).pwd.equals(pwd)) {
                            System.out.println("✨ 로그인에 성공했습니다.");
                            isSuccess = true;
                            myAccount = bankList.get(i);
                        } else {
                            System.out.println("✨ 비밀번호를 다시 입력해주세요.");
                        }
                    }
                    return;
                }
            }

            if (!isFindAccount) System.out.println("✨ 등록되지 않은 계좌입니다.");
        }
    }

    void transferMoney(List<Account> bankList) {
        System.out.println("✨ 송금 메뉴입니다.");
        boolean isFindAccount = false;
        while (!isFindAccount) {
            Scanner sc = new Scanner(System.in);

            System.out.print("✨ 받으실 분의 계좌번호를 입력해주세요.\n→ ");
            String accountNumber = sc.nextLine();
            if (accountNumber.equals(myAccount.accountNumber)) {
                System.out.println("✨ 현재 계좌와 동일한 계좌입니다. 다시 확인해주세요.");
                return;
            }
            System.out.print("✨ 보내실 계좌의 은행명을 입력해주세요.\n→ ");
            String bankName = sc.nextLine();
            for (int i = 0; i < bankList.size(); i++) {
                if (bankList.get(i).accountNumber.equals(accountNumber) && bankList.get(i).bankName.equals(bankName)) {

                    System.out.print("✨ 보내실 금액 입력해주세요.\n→ ");
                    String transferMoney = sc.nextLine();

                    if (myAccount.limit && Integer.parseInt(transferMoney) > 300000) {
                        System.out.println("✨ 한도를 초과하는 금액은 송금하실 수 없습니다.");
                        return;
                    }
                    if (myAccount.money > Integer.parseInt(transferMoney)) {
                        System.out.print("✨ 비밀번호를 입력해주세요.\n→ ");
                        String pwd = sc.nextLine();
                        if (myAccount.pwd.equals(pwd)) {
                            System.out.println("✨ 송금 시 500원의 수수료가 발생합니다.");
                            System.out.println("\n✨ 1. 송금");
                            System.out.println("\n✨ 2. 돌아가기");
                            String selectNum = sc.nextLine();
                            switch (selectNum) {
                                case "1":
                                    myAccount.money = myAccount.money - Integer.parseInt(transferMoney) - 500;
                                    bankList.get(i).money = bankList.get(i).money + Integer.parseInt(transferMoney);
                                    System.out.println("✨ 송금이 완료되었습니다. 남은 금액은 " + myAccount.money + "원입니다.");
                                    break;
                                case "2":
                                    break;
                            }
                        }
                        return;
                    } else {
                        System.out.println("✨ 잔액이 부족합니다.");
                    }
                    return;
                }
            }
        }
    }


    void getMoney() {
        System.out.println("✨ " + myAccount.name + "님 계좌의 잔고는 " + myAccount.money + "원입니다.");
    }

    public Account getMyAccount() {
        return myAccount;
    }

    public void setMyAccount(Account account) {
        myAccount = account;
    }

    public void setMyAccountMoney(int money) {
        myAccount.money = money;
    }

}
