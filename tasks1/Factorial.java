import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Число:");
        int i = console.nextInt();
        int x = 1;
        for (int j = 1; j <= i; j++) {
            x = x * j;
        }
        System.out.println("Факториал числа " + i + " = " + x);
    }
}
