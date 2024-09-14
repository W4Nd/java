import java.util.Scanner;

public class Tern {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Число a:");
        int a = console.nextInt();
        System.out.println("Число b:");
        int b = console.nextInt();

        int x = a > b ? a : b;

        System.out.println(x);
    }
}