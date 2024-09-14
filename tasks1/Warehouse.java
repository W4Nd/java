import java.util.Scanner;

public class Warehouse {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Коробки:");
        int x = console.nextInt();
        System.out.println("Мешки:");
        int y = console.nextInt();
        System.out.println("Бочки:");
        int z = console.nextInt();
        System.out.println("Общее кол-во товаров: " + ((x*20)+(y*50)+(z*100)));

    }
}
