import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private static Account myAccount = null;
    public User() {}
    static void login(List<Account> bankList){
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
                            User.setMyAccount(bankList.get(i));
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



    static void getMoney(){
        System.out.println("✨"+ myAccount.name + "님의 남은 잔고는 " + myAccount.money +"원 입니다.");
    }

    public static Account getMyAccount(){
        return myAccount;
    }

    public static void setMyAccount(Account account){
        myAccount = account;
    }
    public static void setMyAccountMoney(int money){
        myAccount.money = money;
    }

}
