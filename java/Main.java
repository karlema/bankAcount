import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{

    static boolean isExit = false;

    public static void main(String[] args)
    {
        List<Account> bankList = new ArrayList<>();
        Register a = new Register();
        while(!isExit)
        {
            System.out.println("1. 계좌 등록");
            System.out.println("2. 계좌 수정");
            System.out.println("3. 계좌 삭제");
            System.out.println("4. 계좌번호 검색");
            System.out.println("5. 계좌 전체조회");
            System.out.println("6. 계좌 이체");
            System.out.println("7. 종료");
            Scanner sc = new Scanner(System.in);
            String select_num;
            select_num = sc.nextLine();

            if(select_num.equals("1"))
            {
                System.out.println("계좌를 등록 하겠습니다. 아래와 같이 입력해 주세요");
                System.out.println("계좌번호,이름,비밀번호,입금금액,은행명 순으로 적어주세요");
                Scanner sc2 = new Scanner(System.in);
                a.CastString = sc2.nextLine();
                Register(bankList);

                for(int i=0;i<bankList.size();i++)
                {
                    System.out.println((i+1) +"번째 계좌번호 : "+bankList.get(i).accountNumber);
                }
            }
            else if(select_num.equals("2"))
            {

            }
            else if(select_num.equals("3"))
            {

            }
            else if(select_num.equals("4"))
            {

            }
            else if(select_num.equals("5"))
            {

            }
            else if(select_num.equals("6"))
            {

            }
            else if(select_num.equals("7"))
            {
                System.out.println("종료합니다");
                isExit = true;
            }
            else {
                System.out.println("숫자를 다시 확인해주세요.");
            }

        }

        return;
    }
}