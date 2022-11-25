import java.util.List;

public class Register {
    public String CastString;

    public String accountNumber =null;
    public String name;
    public String pwd;
    public int money;
    public String bankName;
    static List<Account> bankList;
    public void parceChar()
    {
        int countComma=0;
        int countTotal=0;
        int first =0;
        int flag =0;
        while(true)
        {
            if(CastString!=null)
            {
                countTotal++;
            }

            if(countComma ==1 && flag ==0)
            {
                accountNumber = CastString.substring(first,countTotal-1);
                System.out.println(accountNumber);
                first = countTotal;
                flag =1;
            }
            else if(countComma ==2 && flag ==0)
            {
                name = CastString.substring(first,countTotal-1);
                System.out.println(name);
                first = countTotal ;
                flag =1;
            }
            else if(countComma ==3 && flag ==0)
            {
                pwd = CastString.substring(first,countTotal-1);
                System.out.println(pwd);
                first = countTotal;
                flag =1;
            }
            else if(countComma ==4 && flag ==0)
            {
                // 콤마 앞
                money = Integer.parseInt(CastString.substring(first,countTotal-1));
                System.out.println(money);
                first = countTotal;

                // 콤마 뒤
                bankName = CastString.substring(first,CastString.length());
                System.out.println(bankName);
                break;
            }

            if(CastString.toCharArray()[countTotal] == ',')
            {
                countComma++;
                flag =0;
            }
        }
        Account ac = new Account(accountNumber,name,pwd,money,bankName);
        bankList.add(ac);
        System.out.println(" 계좌번호 : " + accountNumber + " 이름 : " + name + " 비밀번호 : "+ pwd+ " 입금금액 : " + money+ " 은행명 : " +bankName);
    }

    public Register(List<Account> bankList)
    {
        this.bankList = bankList;
    }
}
