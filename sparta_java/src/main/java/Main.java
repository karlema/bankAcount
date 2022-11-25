import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean isExit = false;
    static boolean isUser = false;

    public static void main(String[] args)
    {
        List<Account> bankList = new ArrayList<>();
        boolean isBack = false;
        isBack = Menu.menu(isExit, bankList);
        while (isBack){
            Menu.menu(isExit, bankList);

        }
        System.out.println("사용자인지 은행직원인지 선택해주세요. 1. 은행직행, 2. 사용자");
        Scanner sel = new Scanner(System.in);
        String selectUser;
        selectUser = sel.nextLine();
        List<Account> bankList = new ArrayList<>();
        if(selectUser.equals("1") || selectUser.equals("1."))
        {
            System.out.println("은행직원 입니다.");
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
                switch (select_num)
                {
                    case "1": case "1.":
                    {
                        System.out.println("계좌를 등록 하겠습니다. 아래와 같이 입력해 주세요");
                        System.out.println("계좌번호,이름,비밀번호,입금금액,은행명 순으로 적어주세요");
                        Scanner sc2 = new Scanner(System.in);
                        Register reg = new Register(bankList);
                        reg.CastString = sc2.nextLine();
                        reg.parceChar();
                        for(int i=0;i<bankList.size();i++)
                        {
                            System.out.println((i+1) +"번째 계좌번호 : "+bankList.get(i).accountNumber);
                        }
                        break;
                    }
                    case "2": case "2.":
                    {
                        System.out.println("계좌를 수정 하겠습니다. 아래와 같이 입력해 주세요");
                        break;
                    }
                    case "3": case "3.":
                    {
                        System.out.println("계좌를 삭제 하겠습니다. 아래와 같이 입력해 주세요");
                        break;
                    }
                    case "4": case "4.":
                    {
                        System.out.println("계좌번호 검색 하겠습니다. 아래와 같이 입력해 주세요");
                        Search test = new Search();
                        test.search(bankList);
                        break;
                    }
                    case "5": case "5.":
                    {
                        System.out.println("계좌 전체조회 하겠습니다. 아래와 같이 입력해 주세요");
                        Search test = new Search();
                        test.read(bankList);
                        break;
                    }
                    case "6": case "6.":
                    {
                        System.out.println("계좌 이체 하겠습니다. 아래와 같이 입력해 주세요");
                        break;
                    }
                    case "7": case "7.":
                    {
                        System.out.println("종료합니다");
                        isExit = true;
                        break;
                    }
                    default:
                    {
                        System.out.println("숫자를 다시 확인해주세요.");
                        break;
                    }

                }
            }
        }
        else
        {
            //로그인
            User.login(bankList);
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