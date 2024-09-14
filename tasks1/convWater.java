import java.util.Scanner;

public class convWater {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите целое число галлонов:");
        int gal = console.nextInt();
        double x = gal * 3.785;
        System.out.println(x);
    }
}