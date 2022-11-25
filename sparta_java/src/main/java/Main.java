import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    static boolean isExit = false;
    static boolean isUser = false;
    public static void main(String[] args)
    {
        List<Account> bankList = new ArrayList<>();
        boolean isBack = false;
        isBack = Menu.menu(isExit, bankList);
        while (isBack){
            Menu.menu(isExit, bankList);
        }
    }
}