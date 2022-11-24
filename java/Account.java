public class Account {
    public String accountNumber;
    public String name;
    public String pwd;
    public int money;
    public String bankName;

    public Account(String accountNumber, String name, String pwd, int money, String bankName)
    {
        this.accountNumber = accountNumber;
        this.name = name;
        this.pwd = pwd;
        this.money = money;
        this.bankName = bankName;
    }
}
