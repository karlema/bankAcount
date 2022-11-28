import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static boolean menu(boolean isExit, List<Account> bankList) {
        System.out.print("✨ 사용자 유형을 선택해주세요.\n1 : 은행직원\n2 : 고객\n→ ");
        Scanner sel = new Scanner(System.in);
        String selectUser;
        selectUser = sel.nextLine();

        if (selectUser.equals("1") || selectUser.equals("1.")) {

            while (!isExit) {
                System.out.println("----------------------------------------");
                System.out.println("1. 계좌 등록");
                System.out.println("2. 계좌 수정");
                System.out.println("3. 계좌 삭제");
                System.out.println("4. 계좌 검색");
                System.out.println("5. 계좌 조회");
                System.out.println("6. 사용자 유형 선택 메뉴");
                System.out.println("7. 종료하기");
                System.out.println("----------------------------------------");
                Scanner sc = new Scanner(System.in);
                String select_num;
                select_num = sc.nextLine();
                switch (select_num) {
                    case "1":
                    case "1.": {
                        System.out.println("✨ 계좌 등록 메뉴입니다. 아래 형식에 맞춰 입력해주세요.");
                        System.out.print("✨ 계좌번호 또는 *(자동생성), 고객명, 비밀번호, 입금액, 은행명, 한도 여부(예 : 1 아니오 : 0)\n→ ");

                        Scanner sc2 = new Scanner(System.in);
                        Register reg = new Register();
                        reg.CastString = sc2.nextLine();
                        reg.parceChar(bankList);
                        break;
                    }
                    case "2":
                    case "2.": {
                        System.out.println("✨ 계좌 수정 메뉴입니다.");

                        Revision revision = new Revision();
                        revision.update(bankList);
                        break;
                    }
                    case "3":
                    case "3.": {
                        System.out.println("✨ 계좌 삭제 메뉴입니다.");

                        Delete delete = new Delete();
                        delete.delete(bankList);
                        break;
                    }
                    case "4":
                    case "4.": {
                        System.out.println("✨ 계좌 검색 메뉴입니다.");

                        Search test = new Search();
                        test.search(bankList);
                        break;
                    }
                    case "5":
                    case "5.": {
                        System.out.println("✨ 계좌 조회 메뉴입니다.");

                        Search test = new Search();
                        test.read(bankList);
                        break;
                    }
                    case "6":
                    case "6.": {
                        return true;
                    }
                    case "7":
                    case "7.": {
                        System.out.println("✨ 프로그램을 종료합니다.");

                        isExit = true;

                        break;
                    }
                    default: {
                        System.out.println("✨ 메뉴의 숫자를 다시 확인해주세요.");

                        break;
                    }

                }

            }
            return false;
        } else {
            User user = new User();
            user.login(bankList);
            BalanceMoney balanceMoney = new BalanceMoney(user);

            while (!isExit) {
                System.out.println("✨ 이용하시려는 메뉴의 숫자를 입력해주세요.");
                System.out.println("1 : 입금");
                System.out.println("2 : 출금");
                System.out.println("3 : 잔액 조회");
                System.out.println("4 : 거래내역 조회");
                System.out.println("5 : 송금");
                System.out.println("6 : 종료");
                System.out.print("→ ");

                String selectMenu;
                selectMenu = sel.nextLine();

                switch (selectMenu) {
                    case "1":
                        balanceMoney.inMoney(user);
                        break;
                    case "2":
                        balanceMoney.outMoney(user);
                        break;
                    case "3":
                        try {
                            user.getMoney();
                        } catch (NullPointerException e) {
                            System.out.println("✨ 잔고가 없습니다.\n");
                        }
                        break;
                    case "4":
                        balanceMoney.dealHistories();
                        break;
                    case "5":
                        user.transferMoney(bankList);
                        break;
                    case "6":
                        isExit = true;
                        break;
                    default:
                        System.out.println("✨ 숫자를 다시 입력해주세요.\n");
                        break;

                }
            }
            return false;
        }
    }
}
