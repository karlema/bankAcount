import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    static Account myAccount;

    public User() {}
    static void login(List<Account> bankList){
        System.out.println("테스트");
//        List<Account> bankList = new ArrayList<>();
//        Account account1 = new Account("1111", "이재원1", "1234", 0, "하나");
//        Account account2 = new Account("2222", "이재원2", "1234", 0, "국민");
//        Account account3 = new Account("3333", "이재원3", "1234", 0, "신한");
//        Account account4 = new Account("4444", "이재원4", "1234", 0, "농협");
//
//        bankList.add(account1);
//        bankList.add(account2);
//        bankList.add(account3);
//        bankList.add(account4);

        System.out.println("로그인 진행 공간");
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
                            User.myAccount = bankList.get(i);
                            isSuccess = true;
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

    void getMoney(){
        System.out.println("✨"+ myAccount.name + "님의 남은 잔고는 " + myAccount.money +"원 입니다.");
    }

}
