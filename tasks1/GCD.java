import java.util.Scanner;

public class GCD {
    public static int gcd(int a, int b) {
        // Алгоритм Евклида
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Первое число: ");
        int num1 = console.nextInt();
        System.out.println("Второе число: ");
        int num2 = console.nextInt();

        int greatestCommonDivisor = gcd(num1, num2);

        System.out.println("Наибольший общий делитель " + num1 + " и " + num2 + " равен " + greatestCommonDivisor);
    }
}