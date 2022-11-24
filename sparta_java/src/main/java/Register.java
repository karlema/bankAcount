import java.util.List;

public class Register {
    public String CastString;

    public String accountNumber =null;
    public String name;
    public String pwd;
    public int money;
    public String bankName;
    public void Register(List<Account> bankList)
    {
        int cnt=0;
        int totla_cnt=0;
        int first =0;
        int flag =0;
        while(true)
        {
            if(CastString!=null)
            {
                totla_cnt++;
            }

            if(cnt ==1 && flag ==0)
            {
                accountNumber = CastString.substring(first,totla_cnt-1);
                System.out.println(accountNumber);
                first = totla_cnt;
                flag =1;
            }
            else if(cnt ==2 && flag ==0)
            {
                name = CastString.substring(first,totla_cnt-1);
                System.out.println(name);
                first = totla_cnt ;
                flag =1;
            }
            else if(cnt ==3 && flag ==0)
            {
                pwd = CastString.substring(first,totla_cnt-1);
                System.out.println(pwd);
                first = totla_cnt;
                flag =1;
            }
            else if(cnt ==4 && flag ==0)
            {
                // 콤마 앞
                money = Integer.parseInt(CastString.substring(first,totla_cnt-1));
                System.out.println(money);
                first = totla_cnt;
                flag =1;

                // 콤마 뒤
                bankName = CastString.substring(first,CastString.length());
                System.out.println(bankName);
                break;
            }

            if(CastString.toCharArray()[totla_cnt] == ',')
            {
                cnt++;
                flag =0;
            }
        }
        Account ac = new Account(accountNumber,name,pwd,money,bankName);
        bankList.add(ac);
        System.out.println(" 계좌번호 : " + accountNumber + " 이름 : " + name + " 비밀번호 : "+ pwd+ " 입금금액 : " + money+ " 은행명 : " +bankName);
    }
}
