import java.util.*;

public class Revision{

    public void update(List<Account> BankList) {

        Scanner sc = new Scanner(System.in);


//        Account memo1 = new Account("123","하나","123",10,"하나은행");
//        Account memo2 = new Account("124","두나","1234",100,"두나은행");
//        Account memo3 = new Account("125","세나","12345",1000,"세나은행");
//        BankList.add(memo1);
//        BankList.add(memo2);
//        BankList.add(memo3);
        System.out.println("계좌를 수정 하겠습니다. 아래와 같이 입력해 주세요");
        System.out.println("\n✨ 계좌번호를 입력해주세요");

        String num = sc.nextLine();
        for (int i = 0; i < BankList.size(); i++) {
            if (num.equals(BankList.get(i).accountNumber)) {
                System.out.println("\n✨ 계좌 비밀번호를 입력해주세요");
                String pwd = sc.nextLine();
                if (pwd.equals(BankList.get(i).pwd)) {
                    System.out.println(BankList.get(i).name+ "님의 계좌 번호는 " + BankList.get(i).accountNumber + "이고 비밀번호는 " + BankList.get(i).pwd + "입니다.");
                    System.out.println("계좌번호를 수정하시겠습니까? ---1번---");
                    System.out.println("고객명을 수정하시겠습니까? ---2번---");
                    System.out.println("계좌 비밀번호를 수정하시겠습니까? ---3번---");
                    System.out.println("메뉴로 돌아가시겠습니까? ---4번---");

                    String selectNum = sc.nextLine();
                    if(selectNum.equals("1")) {
                        System.out.println("\n✨ 변경하실 계좌번호를 입력해주세요.");
                        String updateAccount = sc.nextLine();
                        BankList.set(i,new Account(updateAccount,BankList.get(i).name,BankList.get(i).pwd,BankList.get(i).money,BankList.get(i).bankName));

                        System.out.println("\n✨ 계좌번호가 변경되었습니다.");
                    }
                    if(selectNum.equals("2")) {
                        System.out.println("\n✨ 변경하실 고객명을 입력해주세요.");
                        String updateName = sc.nextLine();
                        BankList.set(i,new Account(BankList.get(i).accountNumber,updateName,BankList.get(i).pwd,BankList.get(i).money,BankList.get(i).bankName));
                        System.out.println("\n✨ 고객명이 변경되었습니다.");
                    }
                    if(selectNum.equals("3")) {
                        System.out.println("\n✨ 변경하실 비밀번호를 입력해주세요.");
                        String updatePwd = sc.nextLine();
                        BankList.set(i,new Account(BankList.get(i).accountNumber,BankList.get(i).name,updatePwd,BankList.get(i).money,BankList.get(i).bankName));
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
//            else {
//                System.out.println("\n✨ 계좌번호가 틀렸습니다.");
//            }
        }
    }
}
