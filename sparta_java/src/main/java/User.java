import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    static void login(){
        List<Account> bankList = new ArrayList<>();
        bankList.add("11111111111", "이재원", "1234", "")
        String pwd, int money, String bankName)

        System.out.println("로그인 진행 공간");
        Scanner sc = new Scanner(System.in);
        System.out.print("✨계좌번호를 입력해주세요.\n→");
        String accountNumber = sc.nextLine();
        System.out.print("✨비밀번호를 입력해주세요.\n→");
        String pwd = sc.nextLine();
        System.out.println("계좌번호 : " + accountNumber + ", 비밀번호 : " + pwd);

    }
}
