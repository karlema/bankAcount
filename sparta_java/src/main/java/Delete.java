import java.util.List;
import java.util.Scanner;

public class Delete {


    public void delete(List<Account> bankList) {
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
                    System.out.println("\n✨ " + bankList.get(i).name + "님의 계좌 번호는 " + bankList.get(i).accountNumber + "이고 잔고는 " + bankList.get(i).money + "원 입니다.");
                    System.out.println("\n✨ 계좌를 정말 삭제하시겠습니까? ---1번---");
                    System.out.println("\n✨ 메뉴로 돌아가시겠습니까? ---2번---");

                    String selectNum = sc.nextLine();
                    if (selectNum.equals("1")) {
                        bankList.remove(i);
                        System.out.println("\n✨ 계좌가 삭제되었습니다.");
                    } else if (selectNum.equals("2")) {
                        break;
                    }
                } else {
                    System.out.println("\n✨ 비밀번호가 일치하지 않습니다.");
                }
            }

            if (isFind == false) {
                System.out.println("\n✨ 계좌번호가 존재하지 않습니다."); // ERROR
            }
        }
    }
}

