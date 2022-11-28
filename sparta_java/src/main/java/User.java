import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private Account myAccount = null;
    public User() {}
    void login(List<Account> bankList){
        Scanner sc = new Scanner(System.in);

        boolean isFindAccount = false;
        while (!isFindAccount){
            System.out.print("✨계좌번호를 입력해주세요.\n→");
            String accountNumber = sc.nextLine();
            for(int i=0; i<bankList.size(); i++){
                if(bankList.get(i).accountNumber.equals(accountNumber)){
                    boolean isSuccess = false;
                    isFindAccount = true;
                    System.out.println("계좌를 찾았습니다");
                    System.out.print("✨비밀번호를 입력해주세요.\n→");

                    while(isSuccess != true){
                        String pwd = sc.nextLine();
                        if(bankList.get(i).pwd.equals(pwd)) {
                            System.out.println("✨로그인 성공");
                            isSuccess = true;
//                            user.setMyAccount(bankList.get(i));
                            myAccount = bankList.get(i);
                        }else {
                            System.out.println("비밀번호를 다시 입력해주세요.");
                        }
                    }
                    return;
                }
            }

            if(!isFindAccount) System.out.println("없는 계좌입니다.");
        }

        return;
    }

    void transferMoney(List<Account> bankList){
        System.out.println("송금을 시작합니다.");
        boolean isFindAccount = false;
        while (!isFindAccount){
            Scanner sc = new Scanner(System.in);
//        1. 이체할 계좌가 있는지 확인
            System.out.print("✨송금할 계좌번호를 입력해주세요.\n→");
            String accountNumber = sc.nextLine();
            if(accountNumber.equals(myAccount.accountNumber)){
                System.out.println("본인 계좌로는 송금할 수 없습니다.");
                return;
            }
            System.out.print("✨송금할 계좌의 은행명을 입력해주세요.\n→");
            String bankName = sc.nextLine();
            for(int i=0; i<bankList.size(); i++){
                if(bankList.get(i).accountNumber.equals(accountNumber) && bankList.get(i).bankName.equals(bankName)){
                    // 2. 은행명, 계좌번호, 비밀번호, 입금할 돈
                    System.out.print("✨송금할 금액 입력해주세요.\n→");
                    String transferMoney = sc.nextLine();

                    if(myAccount.limit && Integer.parseInt(transferMoney) > 300000){
                        System.out.println("myAccount.limit 한도계좌인지 : " + myAccount.limit);
                        System.out.println("Integer.parseInt(transferMoney) : " + Integer.parseInt(transferMoney));
                        System.out.println("송금 최대 한도는 30만원입니다.");
                        return;
                    }
                    if(myAccount.money > Integer.parseInt(transferMoney)){
                        System.out.println("✨비밀번호를 입력해주세요.\n→");
                        String pwd = sc.nextLine();
                        if(myAccount.pwd.equals(pwd)){
                            System.out.println("✨송금 시 500원의 수수료가 발생합니다.");
                            System.out.println("\n✨ 송금하시겠습니까? ---1번---");
                            System.out.println("\n✨ 취소하시겠습니까? ---2번---");
                            String selectNum = sc.nextLine();
                            switch (selectNum) {
                                case "1" :
                                    myAccount.money = myAccount.money - Integer.parseInt(transferMoney) - 500;
                                    bankList.get(i).money = bankList.get(i).money + Integer.parseInt(transferMoney);
                                    System.out.println("✨송금을 완료했습니다. 남은 잔액은 " + myAccount.money + "입니다.");
                                    break;
                                case "2" :
                                    break;
                            }
                        }
                        return;
                    }else {
                        System.out.println("잔액이 부족합니다.");
                    }
                    return;
                }else{
//                    ❌항상 출력되는 문제
                    System.out.println("계좌번호 또는 은행명을 다시 입력해주세요.");
                }

            }
        }


//        3. (한도 제한계좌) 입금금액 30만원 이상이면 문구노출
//        4. 이체받은 계좌는 들어오게

    }


    void getMoney(){
        System.out.println("✨"+ myAccount.name + "님의 남은 잔고는 " + myAccount.money +"원 입니다.");
    }

    public Account getMyAccount(){
        return myAccount;
    }

    public void setMyAccount(Account account){
        myAccount = account;
    }
    public void setMyAccountMoney(int money){
        myAccount.money = money;
    }

}
