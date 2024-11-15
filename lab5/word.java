package lab5;

import java.util.regex.*;

public class word {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam at congue massa. Aliquam ut condimentum massa.";
        char initial = 'A';
        Pattern pattern = Pattern.compile("\\b" + initial + "\\w*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
