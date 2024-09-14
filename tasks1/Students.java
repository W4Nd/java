import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество студентов: ");
        int students = scanner.nextInt();

        System.out.print("Количество парт: ");
        int desks = scanner.nextInt();
        int result = tables(students, desks);
        System.out.println("Не хватает столов: " + result);
        scanner.close();
    }

    public static int tables(int students, int desks) {
        // Сколько столов нужно для размещения всех студентов
        int requiredDesks = (students + 1) / 2; // округляем вверх
        // Сколько столов не хватает
        return Math.max(0, requiredDesks - desks);
    }
}
