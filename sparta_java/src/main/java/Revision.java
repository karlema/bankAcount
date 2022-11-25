import java.util.*;

public class Revision {

    public void update(List<Account> bankList) {

        Scanner sc = new Scanner(System.in);


        System.out.println("\n✨ 계좌번호를 입력해주세요");
        String num = sc.nextLine();
        boolean isFind = false;
        for (int i = 0; i < bankList.size(); i++) {
            if (num.equals(bankList.get(i).accountNumber)) {
                isFind = true;
                System.out.println("\n✨ 계좌 비밀번호를 입력해주세요");
                String pwd = sc.nextLine();
                if (pwd.equals(bankList.get(i).pwd)) {
                    System.out.println(bankList.get(i).name + "님의 계좌 번호는 " + bankList.get(i).accountNumber + "이고 비밀번호는 " + bankList.get(i).pwd + "입니다.");
                    System.out.println("계좌번호를 수정하시겠습니까? ---1번---");
                    System.out.println("고객명을 수정하시겠습니까? ---2번---");
                    System.out.println("계좌 비밀번호를 수정하시겠습니까? ---3번---");
                    System.out.println("메뉴로 돌아가시겠습니까? ---4번---");

                    String selectNum = sc.nextLine();
                    if (selectNum.equals("1")) {
                        System.out.println("\n✨ 변경하실 계좌번호를 입력해주세요.");
                        String updateAccount = sc.nextLine();
                        bankList.set(i, new Account(updateAccount, bankList.get(i).name, bankList.get(i).pwd, bankList.get(i).money, bankList.get(i).bankName));

                        System.out.println("\n✨ 계좌번호가 변경되었습니다.");
                    }
                    if (selectNum.equals("2")) {
                        System.out.println("\n✨ 변경하실 고객명을 입력해주세요.");
                        String updateName = sc.nextLine();
                        bankList.set(i, new Account(bankList.get(i).accountNumber, updateName, bankList.get(i).pwd, bankList.get(i).money, bankList.get(i).bankName));
                        System.out.println("\n✨ 고객명이 변경되었습니다.");
                    }
                    if (selectNum.equals("3")) {
                        System.out.println("\n✨ 변경하실 비밀번호를 입력해주세요.");
                        String updatePwd = sc.nextLine();
                        bankList.set(i, new Account(bankList.get(i).accountNumber, bankList.get(i).name, updatePwd, bankList.get(i).money, bankList.get(i).bankName));
                        System.out.println("\n✨ 계좌 비밀번호가 변경되었습니다.");
                    } else if (selectNum.equals("4")) {
                        break;
                    }
                } else {
                    System.out.println("\n✨ 비밀번호가 틀렸습니다.");
                }
            }

            if (isFind == false) {
                System.out.println("\n✨ 존재하지 않는 계좌번호입니다.");
            }
        }
    }
}
