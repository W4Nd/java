package lab4;

class CustomDivisionException extends Exception {
    public CustomDivisionException(String message) {
        super(message);
    }
}


public class DivisionProgram {
    public static void main(String[] args) {
        try {
            double result = divide(10, 0);
            System.out.println("Результат деления: " + result);
        } catch (CustomDivisionException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static double divide(double numerator, double denominator) throws CustomDivisionException {
        if (denominator == 0) {
            throw new CustomDivisionException("Деление на ноль недопустимо.");
        }
        return numerator / denominator;
    }
}

