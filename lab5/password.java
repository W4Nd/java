package lab5;

import java.util.regex.*;

public class password {
    public static void main(String[] args) {
        String password = "Example123";
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            System.out.println("Пароль корректен!");
        } else {
            System.out.println("Пароль не соответствует требованиям!");
        }
    }
}
