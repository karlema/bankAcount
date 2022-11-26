import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Delete {


    public void delete(List<Account> bankList) {
        Scanner sc = new Scanner(System.in);


        boolean isFindAccount = false;
        System.out.println("\n✨ 계좌번호를 입력해주세요.");
        while (!isFindAccount) {
            String accountNumber = sc.nextLine();
            String patten = "^(\\d{9})-?(\\d{9})-?(\\d{9})$"; //"([0-9,\-]{3,6}\-[0-9,\-]{2,6}\-[0-9,\-])"
            boolean accountPatten = Pattern.matches(patten, accountNumber);
            for (int i = 0; i < bankList.size(); i++) {
                if (bankList.get(i).accountNumber.equals(accountNumber) && accountPatten == true) {
                    boolean isFindPwd = false;
                    System.out.println("\n✨ 비밀번호를 입력해주세요.");

                    while (!isFindPwd) {
                        String pwd = sc.nextLine();
                        if (bankList.get(i).pwd.equals(pwd)) {
                            System.out.println("\n✨ " + bankList.get(i).name + "님의 계좌 번호는 " + bankList.get(i).accountNumber + "이고 비밀번호는 " + bankList.get(i).pwd + "입니다.");
                            System.out.println("\n✨ 계좌를 정말 삭제하시겠습니까? ---1번---");
                            System.out.println("\n✨ 메뉴로 돌아가시겠습니까? ---2번---");

                            String selectNum = sc.nextLine();
                            if (selectNum.equals("1")) {
                                bankList.remove(i);
                                System.out.println("\n✨ 계좌가 삭제되었습니다.");
                                break;
                            } else if (selectNum.equals("2")) {
                                break;
                            }
                        } else {
                            System.out.println("\n✨ 비밀번호를 다시 입력해주세요.");
                        }
                    }
                    return;
                }
            }
            if (!isFindAccount) {
                System.out.println("\n✨ 계좌번호를 다시 입력해주세요.");
            }
        }
    }
}


