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
        Scanner sc = new Scanner(System.in);
//        1. 이체할 계좌가 있는지 확인(내 계좌번호인지도 확인)
        System.out.print("✨이체할 계좌번호를 입력해주세요.\n→");
        String accountNumber = sc.nextLine();
        for(int i=0; i<bankList.size(); i++){
            if(bankList.get(i).accountNumber.equals(accountNumber))
            System.out.println();
        }
//        2. 은행명, 계좌번호, 비밀번호, 입금할 돈
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
