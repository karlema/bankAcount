import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Revision {


    public void update(List<Account> bankList) {
        Scanner sc = new Scanner(System.in);


        boolean isCheckAccount = false;
        System.out.print("\n✨ 계좌번호를 입력해주세요.\n→ ");
        while (!isCheckAccount) {
            String accountNumber = sc.nextLine();
            String patten = "^(\\d{3,6})-?(\\d{2,6})-?(\\d{6,9})$";
            boolean accountPatten = Pattern.matches(patten, accountNumber);
            for (int i = 0; i < bankList.size(); i++) {
                if (bankList.get(i).accountNumber.equals(accountNumber) && accountPatten == true) {
                    boolean isCheckPwd = false;
                    System.out.print("\n✨ 비밀번호를 입력해주세요.\n→ ");

                    while (!isCheckPwd) {
                        String pwd = sc.nextLine();
                        if (bankList.get(i).pwd.equals(pwd)) {
                            System.out.println("\n✨ " + bankList.get(i).name + "님의 계좌 번호는 " + bankList.get(i).accountNumber + " 이고 비밀번호는 " + bankList.get(i).pwd + " 입니다.");
                            System.out.println("\n✨ 0. 계좌 설정 변경 ");
                            System.out.println("\n✨ 1. 고객명 수정");
                            System.out.println("\n✨ 2. 비밀번호 수정");
                            System.out.println("\n✨ 3. 메뉴로 돌아가기");
                            System.out.print("→ ");

                            String selectNum = sc.nextLine();
                            switch (selectNum) {
                                case "0" :
                                {
                                    if(bankList.get(i).limit == true) {
                                        bankList.set(i, new Account(bankList.get(i).accountNumber, bankList.get(i).name, bankList.get(i).pwd, bankList.get(i).money, bankList.get(i).bankName, false));
                                        System.out.println("\n✨ 일반계좌로 변경되었습니다.");
                                        break;
                                    }
                                    else if(bankList.get(i).limit == false)
                                        bankList.set(i, new Account(bankList.get(i).accountNumber, bankList.get(i).name, bankList.get(i).pwd, bankList.get(i).money, bankList.get(i).bankName, true));
                                    System.out.println("\n✨ 한도계좌로 변경되었습니다.");
                                    break;

                                }
                                case "1" :
                                    System.out.print("\n✨ 변경하실 이름을 입력해주세요.\n→ ");
                                    String updateName = sc.nextLine();
                                    bankList.set(i, new Account(bankList.get(i).accountNumber, updateName, bankList.get(i).pwd, bankList.get(i).money, bankList.get(i).bankName, bankList.get(i).limit));
                                    System.out.println("\n✨ 고객명이 변경되었습니다.");
                                    break;
                                case "2" :
                                    System.out.print("\n✨ 새로운 비밀번호를 입력해주세요.\n→ ");
                                    String updatePwd = sc.nextLine();
                                    bankList.set(i, new Account(bankList.get(i).accountNumber, bankList.get(i).name, updatePwd, bankList.get(i).money, bankList.get(i).bankName, bankList.get(i).limit));
                                    System.out.println("\n✨ 비밀번호가 변경되었습니다.");
                                    break;
                                case "3" :
                                    break;
                            }
                            return;
                        } if (!isCheckPwd) {
                            System.out.println("\n✨ 비밀번호를 다시 입력해주세요.");
                        }
                    }
                    return;
                }
            }
            if (!isCheckAccount) {
                System.out.println("\n✨ 계좌번호를 다시 입력해주세요.");
            }
        }
    }
}


