import java.util.Scanner;

public class Calories {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Время:");
        int min = console.nextInt();
        System.out.println("Интенсивность:");
        int x = console.nextInt();

        int calories = (x*min);
        System.out.println(calories);
    }
}
