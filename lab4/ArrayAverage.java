package lab4;

public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5"};
        int sum = 0;
        int count = 0;

        try {
            for (int i = 0; i < arr.length; i++) {
                try {
                    int num = Integer.parseInt(arr[i]);
                    sum += num;
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Элемент массива на позиции " + i + " не является числом: " + arr[i]);
                }
            }

            if (count > 0) {
                double average = (double) sum / count;
                System.out.println("Среднее арифметическое: " + average);
            } else {
                System.out.println("Нет числовых элементов для вычисления среднего арифметического.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка выхода за границы массива: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}

