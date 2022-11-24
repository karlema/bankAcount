import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    static boolean isExit = false;
    static boolean isUser = false;
    public static void main(String[] args) {
        System.out.println("사용자인지 은행직원인지 선택해주세요. 1. 은행직행, 2. 사용자");
        Scanner sel = new Scanner(System.in);
        String selectUser;
        selectUser = sel.nextLine();

        List<Account> bankList = new ArrayList<>();
        if(selectUser.equals("1") || selectUser.equals("1.")) {
            System.out.println("은행직원 입니다.");
            while(!isExit) {
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

                if(select_num.equals("1")|| selectUser.equals("1."))
                {
                    System.out.println("계좌를 등록 하겠습니다. 아래와 같이 입력해 주세요");
                    System.out.println("계좌번호,이름,비밀번호,입금금액,은행명 순으로 적어주세요");
                    Scanner sc2 = new Scanner(System.in);
                    Register a = new Register(bankList);
                    a.CastString = sc2.nextLine();
                    a.parceChar();
                    for(int i=0;i<bankList.size();i++)
                    {
                        System.out.println((i+1) +"번째 계좌번호 : "+bankList.get(i).accountNumber);
                    }
                }
                else if(select_num.equals("2") || selectUser.equals("2."))
                {
                    System.out.println("계좌를 수정 하겠습니다. 아래와 같이 입력해 주세요");
                }
                else if(select_num.equals("3") || selectUser.equals("3."))
                {
                    System.out.println("계좌를 삭제 하겠습니다. 아래와 같이 입력해 주세요");
                }
                else if(select_num.equals("4") || selectUser.equals("4."))
                {
                    System.out.println("계좌번호 검색 하겠습니다. 아래와 같이 입력해 주세요");
                }
                else if(select_num.equals("5") || selectUser.equals("5."))
                {
                    System.out.println("계좌 전체조회 하겠습니다. 아래와 같이 입력해 주세요");
                }
                else if(select_num.equals("6") || selectUser.equals("6."))
                {
                    System.out.println("계좌 이체 하겠습니다. 아래와 같이 입력해 주세요");
                }
                else if(select_num.equals("7") || selectUser.equals("7."))
                {
                    System.out.println("종료합니다");
                    isExit = true;
                }
                else {
                    System.out.println("숫자를 다시 확인해주세요.");
                }

            }
        }
        else {
            //사용자 부분
            User.login();
            while(!isExit){
                System.out.println("------------------------------");
                System.out.println("1. 입금");
                System.out.println("2. 출금");
                System.out.println("3. 잔고확인");

                String userSelect;
                userSelect = sel.nextLine();
                if(userSelect.equals("1")){
                    System.out.println("입금 하겠습니다. 아래와 같이 입력해 주세요");
                    break;
                }else if(userSelect.equals("2")){
                    System.out.println("출금 하겠습니다. 아래와 같이 입력해 주세요");
                }else if(userSelect.equals("3")){
                    try{
                        new User().getMoney();
                    }catch (NullPointerException e){
                        System.out.println("잔고가 없습니다.");
                    }

                }
            }
        }


        return;
    }
}