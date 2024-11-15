package lab5;

import java.util.regex.*;

public class finder {
    public static void main(String[] args) {
        String text = "Цена 50руб. 50кг, 6 штук, 9999, слово";
        Pattern pattern = Pattern.compile("\\d+\\.\\d+|\\d+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
