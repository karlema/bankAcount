import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Delete {


    public void delete(List<Account> bankList) {
        Scanner sc = new Scanner(System.in);

        boolean isCheckAccount = false;

        System.out.print("✨ 계좌번호를 입력해주세요.\n→ ");

        while (!isCheckAccount) {
            String accountNumber = sc.nextLine();
            String patten = "^(\\d{3,6})-?(\\d{2,6})-?(\\d{6,9})$";
            boolean accountPatten = Pattern.matches(patten, accountNumber);
            for (int i = 0; i < bankList.size(); i++) {
                if (bankList.get(i).accountNumber.equals(accountNumber) && accountPatten == true) {
                    boolean isCheckPwd = false;

                    System.out.print("✨ 비밀번호를 입력해주세요.\n→ ");

                    while (!isCheckPwd) {
                        String pwd = sc.nextLine();
                        if (bankList.get(i).pwd.equals(pwd)) {
                            System.out.println("✨ " + bankList.get(i).name + "님의 계좌 번호는 " + bankList.get(i).accountNumber + ", 비밀번호는 " + bankList.get(i).pwd + "입니다.");
                            System.out.println("----------------------------------------");
                            System.out.println("1. 삭제");
                            System.out.print("2. 취소");

                            int selectNum = sc.nextInt();
                            switch (selectNum) {
                                case 1:
                                    bankList.remove(i);

                                    System.out.println("✨ 계좌가 삭제되었습니다.");
                                    break;
                                case 2:
                                    break;
                            }
                            return;
                        } if(!isCheckPwd) {
                            System.out.println("비밀번호가 올바르지 않습니다. 확인 후 다시 입력해주세요.");
                        }
                    }
                    return;
                }
            }
            if (!isCheckAccount) {
                System.out.println("계좌번호가 올바르지 않습니다. 확인 후 다시 입력해주세요.");
            }
        }
    }
}


