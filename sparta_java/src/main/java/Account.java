public class Account {
    public String accountNumber;
    public String name;
    public String pwd;
    public int money;
    public String bankName;

    public boolean limit;

    public Account(String accountNumber, String name, String pwd, int money, String bankName, boolean limit) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.pwd = pwd;
        this.money = money;
        this.bankName = bankName;
        this.limit =limit;
    }
        public String getAccountNumber () {
            return accountNumber;
        }

        public String getName () {
            return name;
        }

        public String getPwd () {
            return pwd;
        }

        public int getMoney () {
            return money;
        }

        public String getBankName () {
            return bankName;
        }
    }

