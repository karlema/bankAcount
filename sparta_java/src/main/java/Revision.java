import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Revision {


    public void update(List<Account> bankList) {
        Scanner sc = new Scanner(System.in);


        boolean isCheckAccount = false;
        System.out.println("\n✨ 계좌번호를 입력해주세요.");
        while (!isCheckAccount) {
            String accountNumber = sc.nextLine();
            String patten = "^(\\d{3,6})-?(\\d{2,6})-?(\\d{6,9})$";
            boolean accountPatten = Pattern.matches(patten, accountNumber);
            for (int i = 0; i < bankList.size(); i++) {
                if (bankList.get(i).accountNumber.equals(accountNumber) && accountPatten == true) {
                    boolean isCheckPwd = false;
                    System.out.println("\n✨ 비밀번호를 입력해주세요.");

                    while (!isCheckPwd) {
                        String pwd = sc.nextLine();
                        if (bankList.get(i).pwd.equals(pwd)) {
                            System.out.println("\n✨ " + bankList.get(i).name + "님의 계좌 번호는 " + bankList.get(i).accountNumber + "이고 비밀번호는 " + bankList.get(i).pwd + "입니다.");
//                            System.out.println("\n✨ 계좌번호를 수정하시겠습니까? ---0번---");
                            System.out.println("\n✨ 고객명을 수정하시겠습니까? ---1번---");
                            System.out.println("\n✨ 계좌 비밀번호를 수정하시겠습니까? ---2번---");
                            System.out.println("\n✨ 메뉴로 돌아가시겠습니까? ---3번---");

                            String selectNum = sc.nextLine();
                            switch (selectNum) {
//                                case "0" :
//                                {
//                                    System.out.println("\n✨ 변경하실 계좌번호를 입력해주세요.");
//                                    String updateAccount = sc.nextLine();
//                                    boolean updateAccountPatten = Pattern.matches(patten,updateAccount);
//                                    if (updateAccountPatten == true) {
//                                        bankList.set(i, new Account(updateAccount, bankList.get(i).name, bankList.get(i).pwd, bankList.get(i).money, bankList.get(i).bankName));
//                                        System.out.println("\n✨ 계좌번호가 변경되었습니다.");
//                                        break;
//                                    }
//                                }
                                case "1" :
                                    System.out.println("\n✨ 변경하실 고객명을 입력해주세요.");
                                    String updateName = sc.nextLine();
                                    bankList.set(i, new Account(bankList.get(i).accountNumber, updateName, bankList.get(i).pwd, bankList.get(i).money, bankList.get(i).bankName, bankList.get(i).limit));
                                    System.out.println("\n✨ 고객명이 변경되었습니다.");
                                    break;
                                case "2" :
                                    System.out.println("\n✨ 변경하실 비밀번호를 입력해주세요.");
                                    String updatePwd = sc.nextLine();
                                    bankList.set(i, new Account(bankList.get(i).accountNumber, bankList.get(i).name, updatePwd, bankList.get(i).money, bankList.get(i).bankName, bankList.get(i).limit));
                                    System.out.println("\n✨ 계좌 비밀번호가 변경되었습니다.");
                                    break;
                                case "3" :
                                    break;
                            }
                            return;
//                            if (selectNum.equals("0")) {
//                                System.out.println("\n✨ 변경하실 계좌번호를 입력해주세요.");
//                                String updateAccount = sc.nextLine();
//                                boolean updateAccountPatten = Pattern.matches(patten,updateAccount);
//                                if (updateAccountPatten == true) {
//                                    bankList.set(i, new Account(updateAccount, bankList.get(i).name, bankList.get(i).pwd, bankList.get(i).money, bankList.get(i).bankName));
//                                    System.out.println("\n✨ 계좌번호가 변경되었습니다.");
//                                    break;
//                                } else if(!updateAccountPatten) { //ERROR
//                                    System.out.println("\n✨ 계좌번호 형식이 맞지않습니다.");
//                                }
//                            }
//                            if (selectNum.equals("1")) {
//                                System.out.println("\n✨ 변경하실 고객명을 입력해주세요.");
//                                String updateName = sc.nextLine();
//                                bankList.set(i, new Account(bankList.get(i).accountNumber, updateName, bankList.get(i).pwd, bankList.get(i).money, bankList.get(i).bankName));
//                                System.out.println("\n✨ 고객명이 변경되었습니다.");
//                                break;
//                            }
//                            if (selectNum.equals("2")) {
//                                System.out.println("\n✨ 변경하실 비밀번호를 입력해주세요.");
//                                String updatePwd = sc.nextLine();
//                                bankList.set(i, new Account(bankList.get(i).accountNumber, bankList.get(i).name, updatePwd, bankList.get(i).money, bankList.get(i).bankName));
//                                System.out.println("\n✨ 계좌 비밀번호가 변경되었습니다.");
//                                break;
//                            } else if (selectNum.equals("3")) {
//                                break;
//                            }
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


