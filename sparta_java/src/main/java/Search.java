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

        System.out.print("✨ 계좌번호 또는 고객명을 입력해주세요.\n→ ");
        String select = scanner.nextLine();
        String confirm = select;


        for (int i = 0; i < bankList.size(); i++) {
            if(bankList.get(i).accountNumber.contains(select)) {
                System.out.println("----------------------------------------");
                if(bankList.get(i).limit()){
                    System.out.println("한도계좌");
                }else{
                    System.out.println("일반계좌");
                }
                System.out.println("계좌번호 : " + bankList.get(i).getAccountNumber());
                System.out.println("고객명 : " + bankList.get(i).getName());
                System.out.println("잔고 : " + bankList.get(i).getMoney());
                System.out.println("----------------------------------------\n");
            }
        }

        for (int i = 0; i < bankList.size(); i++) {
            if(bankList.get(i).name.contains(select)) {
                System.out.println("--------------------------------");
                if(bankList.get(i).limit()){
                    System.out.println("한도계좌");
                }else{
                    System.out.println("일반계좌");
                }
                System.out.println("계좌번호 : " + bankList.get(i).getAccountNumber());
                System.out.println("고객명 : " + bankList.get(i).getName());
                System.out.println("잔고 : " + bankList.get(i).getMoney());
                System.out.println("--------------------------------\n");
            }
        }
    }

    public void read(List<Account> bankList){

        System.out.println("✨ 저장된 계좌번호와 고객명을 모두 출력합니다.\n");
        // 모두 출력
        for (int i = 0; i < bankList.size(); i++) {
            System.out.println("---------- " + (i + 1) + "번" + " ----------");
            if(bankList.get(i).limit()){
                System.out.println("한도계좌");
            }else{
                System.out.println("일반계좌");
            }
            System.out.println("계좌번호 : " + bankList.get(i).getAccountNumber());
            System.out.println("고객명 : " + bankList.get(i).getName());
            System.out.println("잔고 : " + bankList.get(i).getMoney());
        }
        System.out.println("---------- 출력 완료 ----------\n");
    }
}



