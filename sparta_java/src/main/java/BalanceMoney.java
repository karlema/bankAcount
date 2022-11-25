public class BalanceMoney {

    void inMoney(){
        System.out.println("입금");
        System.out.println("accountNumber : " + User.getMyAccount().accountNumber);
        System.out.println("name : " + User.getMyAccount().name);
        System.out.println("money : " + User.getMyAccount().money);
        System.out.println("pwd : " + User.getMyAccount().pwd);
        User.setMyAccountMoney(2000);
    }
    void outMoney(){
        System.out.println("출금");
    }
}
