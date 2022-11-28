import java.util.List;
import java.util.regex.Pattern;

public class Register {
    public String CastString;
    public String accountNumber = null;
    public String name;
    public String pwd;
    public int money;
    public String bankName;
    public boolean limit;
    public String prefix = "356-1100-";

    public void parceChar(List<Account> bankList) {
        int countComma = 0;
        int countTotal = 0;
        int first = 0;
        int flag = 0;
        int last = 0;
        CastString = CastString.replaceAll(" ", "");
        while (true) {
            try {
                if (CastString != null) {
                    countTotal++;
                }

                if (flag == 0) {
                    switch (countComma) {
                        case 1: {
                            if (CastString.toCharArray()[first] == '*') {
                                String tempaccountNumber = "";
                                for (int i = 0; i < 6; i++) {
                                    tempaccountNumber += String.valueOf((int) (Math.random() * 10));
                                }
                                accountNumber = prefix + tempaccountNumber;
                            } else {
                                accountNumber = CastString.substring(first, countTotal - 1);
                                String pattern = "^(\\d{3,6})-?(\\d{2,6})-?(\\d{6,9})$";
                                boolean accountPattern = Pattern.matches(pattern, accountNumber);
                                if (!accountPattern) {
                                    System.out.println("✨ 형식에 맞지 않는 계좌번호입니다.");
                                    System.out.println("✨ (3~6자리 숫자)-(2~6자리 숫자)-(6~9자리 숫자) 형식으로 입력해주세요");
                                    return;
                                }
                                int count = 0;
                                for (Account acnt : bankList) {
                                    if (accountNumber.equals(bankList.get(count).accountNumber)) {
                                        System.out.println("✨ 동일한 계좌번호가 있습니다.");
                                        return;
                                    }
                                    count++;
                                }
                            }
                            System.out.println("✨ 새로 등록된 계좌의 번호는 " + accountNumber + " 입니다.");

                            first = countTotal;
                            flag = 1;
                            break;
                        }
                        case 2: {
                            name = CastString.substring(first, countTotal - 1);
//                            System.out.println(name);
                            first = countTotal;
                            flag = 1;
                            break;
                        }
                        case 3: {
                            pwd = CastString.substring(first, countTotal - 1);
//                            System.out.println(pwd);
                            first = countTotal;
                            flag = 1;
                            break;
                        }
                        case 4: {
                            money = Integer.parseInt(CastString.substring(first, countTotal - 1));
//                            System.out.println(money);
                            first = countTotal;
                            flag = 1;
                            break;
                        }
                        case 5: {

                            // 콤마 앞
                            bankName = CastString.substring(first, countTotal - 1);
//                            System.out.println(bankName);
                            first = countTotal;

                            if (CastString.toCharArray()[first] == '1') {
                                limit = true;
                            } else {
                                limit = false;
                            }
                            // 콤마 뒤



                            last = 1;
                            flag = 1;
                            break;
                        }
                    }
                }

                if (CastString.toCharArray()[countTotal] == ',') {
                    countComma++;
                    flag = 0;
                }

                if (last == 1) break;
            } catch (Exception e) {
                System.out.println("✨ 잘못된 입력입니다.");
                return;
            }
        }
        Account ac = new Account(accountNumber, name, pwd, money, bankName, limit);
        bankList.add(ac);
        if (!limit) {
            System.out.println("✨ 계좌번호 : " + accountNumber + " 이름 : " + name + " 비밀번호 : " + pwd + " 입금금액 : " + money + " 은행명 : " + bankName);
        } else {
            System.out.println("✨ 계좌번호(한도제한) : " + accountNumber + " 이름 : " + name + " 비밀번호 : " + pwd + " 입금금액 : " + money + " 은행명 : " + bankName);
        }

    }

    public Register() {

    }
}
