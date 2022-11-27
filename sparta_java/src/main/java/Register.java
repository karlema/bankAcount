import java.util.List;
import java.util.regex.Pattern;

public class Register {
    public String CastString;

    public String accountNumber =null;
    public String name;
    public String pwd;
    public int money;
    public String bankName;

    public void parceChar(List<Account> bankList)
    {
        int countComma=0;
        int countTotal=0;
        int first =0;
        int flag =0;
        CastString = CastString.replaceAll(" ","");
        while(true)
        {
            try{
                if(CastString!=null)
                {
                    countTotal++;
                }

                if(countComma ==1 && flag ==0)
                {
                    accountNumber = CastString.substring(first,countTotal-1);
                    String pattern = "^(\\d{3,6})-?(\\d{2,6})-?(\\d{6,9})$";
                    boolean accountPattern = Pattern.matches(pattern,accountNumber);
                    if(!accountPattern) {
                        System.out.println("계좌번호 형식이 맞지 않습니다.");
                        System.out.println("(3~6자리 숫자)-(2~6자리 숫자)-(6~9자리 숫자) 형식으로 입력해주세요");
                        return;
                    }
                    int count=0;
                    for(Account acnt: bankList)
                    {
                        if(accountNumber.equals(bankList.get(count).accountNumber))
                        {
                            System.out.println("동일한 계좌번호가 있습니다. 처음 메뉴로 돌아가겠습니다.");
                            return;
                        }
                        count++;
                    }

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
            }catch (Exception e)
            {
                System.out.println("입력 방법이 틀렸습니다. 처음 메뉴로 돌아가겠습니다.");
                return;
            }

        }
        Account ac = new Account(accountNumber,name,pwd,money,bankName);
        bankList.add(ac);
        System.out.println(" 계좌번호 : " + accountNumber + " 이름 : " + name + " 비밀번호 : "+ pwd+ " 입금금액 : " + money+ " 은행명 : " +bankName);
    }

    public Register()
    {

    }
}
