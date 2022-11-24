import java.util.*;

public class Revision implements AccountRevision{
    @Override
    public void update() {

        List<Account> accountList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);


        Account memo1 = new Account("123","하나","123",10,"하나은행");
        Account memo2 = new Account("124","두나","1234",100,"두나은행");
        Account memo3 = new Account("125","세나","12345",1000,"세나은행");
        accountList.add(memo1);
        accountList.add(memo2);
        accountList.add(memo3);
        System.out.println("계좌를 수정 하겠습니다. 아래와 같이 입력해 주세요");
        System.out.println("\n✨ 계좌번호를 입력해주세요");

        String num = sc.nextLine();
        for (int i = 0; i < accountList.size(); i++) {
            if (num.equals(accountList.get(i).getAccountNumber())) {
                System.out.println("\n✨ 계좌 비밀번호를 입력해주세요");
                String pwd = sc.nextLine();
                if (pwd.equals(accountList.get(i).getPwd())) {
                    System.out.println(accountList.get(i).getName() + "님의 계좌 번호는 " + accountList.get(i).getAccountNumber() + "이고 비밀번호는 " + accountList.get(i).getPwd() + "입니다.");
                    System.out.println("계좌번호를 수정하시겠습니까? ---1번---");
                    System.out.println("고객명을 수정하시겠습니까? ---2번---");
                    System.out.println("계좌 비밀번호를 수정하시겠습니까? ---3번---");
                    System.out.println("메뉴로 돌아가시겠습니까? ---4번---");

                    String selectNum = sc.nextLine();
                    if(selectNum.equals("1")) {
                        System.out.println("\n✨ 변경하실 계좌번호를 입력해주세요.");
                        String updateAccount = sc.nextLine();
                        accountList.set(i,new Account(updateAccount,accountList.get(i).getName(),accountList.get(i).getPwd(),accountList.get(i).getMoney(),accountList.get(i).getBankName()));

                        System.out.println("\n✨ 계좌번호가 변경되었습니다.");
                    }
                    if(selectNum.equals("2")) {
                        System.out.println("\n✨ 변경하실 고객명을 입력해주세요.");
                        String updateName = sc.nextLine();
                        accountList.set(i,new Account(accountList.get(i).getAccountNumber(),updateName,accountList.get(i).getPwd(),accountList.get(i).getMoney(),accountList.get(i).getBankName()));
                        System.out.println("\n✨ 고객명이 변경되었습니다.");
                    }
                    if(selectNum.equals("3")) {
                        System.out.println("\n✨ 변경하실 비밀번호를 입력해주세요.");
                        String updatePwd = sc.nextLine();
                        accountList.set(i,new Account(accountList.get(i).getAccountNumber(),accountList.get(i).getName(),updatePwd,accountList.get(i).getMoney(),accountList.get(i).getBankName()));
                        System.out.println("\n✨ 계좌 비밀번호가 변경되었습니다.");
                    }
                    else if(selectNum.equals("4")) {
                        break;
                    }
                }
                else {
                    System.out.println("\n✨ 비밀번호가 틀렸습니다.");
                }
            }
            else {
                System.out.println("\n✨ 계좌번호가 틀렸습니다.");
            }
        }
    }
}
