import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {

    //    public void test(List<Account> bankList){
////        System.out.println(bankList);
//        for (int i = 0; i <bankList.size() ; i++) {
//            System.out.println(bankList.get(i).accountNumber);
//            System.out.println(bankList.get(i).name);
//            System.out.println(bankList.get(i).money);
//        }
//    }
    public void search(List<Account> bankList) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("계좌번호 혹은 소유자명으로 검색해주세요");
        String select = scanner.nextLine();
        String confirm = select;


        for (int i = 0; i < bankList.size(); i++) {
            if(bankList.get(i).accountNumber.contains(select)) {
                System.out.println("--------------------------------");
                System.out.println("계좌 번호 : " + bankList.get(i).getAccountNumber());
                System.out.println("소유자 명 : " + bankList.get(i).getName());
                System.out.println("잔고 : " + bankList.get(i).getMoney());
                System.out.println("--------------------------------");
                System.out.println("");
            }
        }

        for (int i = 0; i < bankList.size(); i++) {
            if(bankList.get(i).name.contains(select)) {
                System.out.println("--------------------------------");
                System.out.println("계좌 번호 : " + bankList.get(i).getAccountNumber());
                System.out.println("소유자 명 : " + bankList.get(i).getName());
                System.out.println("잔고 : " + bankList.get(i).getMoney());
                System.out.println("--------------------------------");
                System.out.println("");
            }
        }
    }

    public void read(List<Account> bankList){

        System.out.println("계좌 번호와 소유자명을 출력합니다.\n");
        // 모두 출력
        for (int i = 0; i < bankList.size(); i++) {
            System.out.println("---------- " + (i + 1) + "번 메모" + " ----------");
            System.out.println("계좌 번호 : " + bankList.get(i).getAccountNumber());
            System.out.println("소유자 명 : " + bankList.get(i).getName());
            System.out.println("잔고 : " + bankList.get(i).getMoney());
        }
        System.out.println("---------- 출력 완료 ----------\n");
    }
}



