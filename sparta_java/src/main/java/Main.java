import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    static boolean isExit = false;
    static boolean isUser = false;
    public static void main(String[] args)
    {
        System.out.println("\n \n");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|    88        88    ,ad8888ba,    888888888888   ad88888ba   88  8b        d8      88888888ba          db         888b      88  88      a8P      |");
        System.out.println("|    88        88   d8\"'    `\"8b        88       d8\"     \"8b  88   Y8,    ,8P       88      \"8b        d88b        8888b     88  88    ,88'       |");
        System.out.println("|    88        88  d8'        `8b       88       Y8,          88    `8b  d8'        88      ,8P       d8'`8b       88 `8b    88  88  ,88\"         |");
        System.out.println("|    88aaaaaaaa88  88          88       88       `Y8aaaaa,    88      Y88P          88aaaaaa8P'      d8'  `8b      88  `8b   88  88,d88'          |");
        System.out.println("|    88\"\"\"\"\"\"\"\"88  88          88       88         `\"\"\"\"\"8b,  88      d88b          88\"\"\"\"\"\"8b,     d8YaaaaY8b     88   `8b  88  8888\"88,         |");
        System.out.println("|    88        88  Y8,        ,8P       88               `8b  88    ,8P  Y8,        88      `8b    d8\"\"\"\"\"\"\"\"8b    88    `8b 88  88P   Y8b        |");
        System.out.println("|    88        88   Y8a.    .a8P        88       Y8a     a8P  88   d8'    `8b       88      a8P   d8'        `8b   88     `8888  88     \"88,      |");
        System.out.println("|    88        88    `\"Y8888Y\"'         88        \"Y88888P\"   88  8P        Y8      88888888P\"   d8'          `8b  88      `888  88       Y8b     |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\n \n");

        List<Account> bankList = new ArrayList<>();
        boolean isBack = false;
        isBack = Menu.menu(isExit, bankList);
        while (isBack){
            Menu.menu(isExit, bankList);
        }
    }
}