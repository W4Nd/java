import java.util.Scanner;

public class duvetCover {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double fabricLength = console.nextDouble(); // Длина ткани
        double coverWidth = console.nextDouble();     // Ширина пододеяльника
        double coverLength = console.nextDouble();    // Длина пододеяльника

        int numberOfCovers = calculateDuvetCovers(fabricLength, coverWidth, coverLength);
        System.out.println("Количество пододеяльников: " + numberOfCovers);
    }

    public static int calculateDuvetCovers(double fabricLength, double coverWidth, double coverLength) {
        // Площадь ткани
        double fabricArea = fabricLength * 1; // Допустим, ширина ткани 1 метр

        // Площадь одного пододеяльника
        double coverArea = coverWidth * coverLength;

        // Количество пододеяльников
        int numberOfCovers = (int) (fabricArea / coverArea);

        return numberOfCovers;
    }
}
