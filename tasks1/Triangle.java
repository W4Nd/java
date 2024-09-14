import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Стороны:");
        int x = console.nextInt();
        int y = console.nextInt();
        int z = console.nextInt();
        if (x + y <= z || x + z <= y || y + z <= x)
            System.out.println("Не треугольник");
        else if(x == y && y == z)
            System.out.println("Равносторонний");
        else if (x == y || x == z || y == z)
            System.out.println("Равнобедренный");
        else
            System.out.println("Разносторонний");
    }
}
