import java.util.*;

public class Main {

    // 1
    public static String nonRepeat(String str) {
        return nonRepeatHelper(str.toLowerCase(), new HashSet<>());
    }

    private static String nonRepeatHelper(String str, Set<Character> visited) {
        if (str.isEmpty()) return str;
        char current = str.charAt(0);
        if (visited.contains(current)) {
            return nonRepeatHelper(str.substring(1), visited);
        } else {
            visited.add(current);
            return current + nonRepeatHelper(str.substring(1), visited);
        }
    }

    // 2
    public static List<String> bruteForce(int n, int k) {
        List<String> result = new ArrayList<>();
        if (n > k) return result;
        char[] alphabet = new char[k];
        for (int i = 0; i < k; i++) {
            alphabet[i] = (char) ('0' + i);
        }
        generateCombinations(result, "", alphabet, n);
        return result;
    }

    private static void generateCombinations(List<String> result, String current, char[] alphabet, int n) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        for (char c : alphabet) {
            if (!current.contains(String.valueOf(c))) {
                generateCombinations(result, current + c, alphabet, n);
            }
        }
    }

    // 3
    public static String encode(int[] input, String key) {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            char ch = (char) ((input[i] ^ key.charAt(i)) % 256);
            encoded.append(ch);
        }
        return encoded.toString();
    }

    public static int[] decode(String message, String key) {
        int[] decoded = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            decoded[i] = message.charAt(i) ^ key.charAt(i);
        }
        return decoded;
    }

    // 4
    public static List<String> split(String str) {
        List<String> clusters = new ArrayList<>();
        int balance = 0;
        StringBuilder cluster = new StringBuilder();
        for (char ch : str.toCharArray()) {
            cluster.append(ch);
            if (ch == '(') balance++;
            else if (ch == ')') balance--;
            if (balance == 0) {
                clusters.add(cluster.toString());
                cluster.setLength(0);
            }
        }
        return clusters;
    }

    // 5
    public static String shortHand(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= str.length(); i++) {
            if (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result.append(str.charAt(i - 1));
                if (count > 1) {
                    result.append('*').append(count);
                }
                count = 1;
            }
        }
        return result.toString();
    }

    // 6
    public static String convertToRome(int num) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(romans[i]);
            }
        }
        return result.toString();
    }

    // 7
    public static String uniqueSubstring(String digits) {
        int[] evenCount = new int[10], oddCount = new int[10];
        for (int i = 0; i < digits.length(); i++) {
            if (i % 2 == 0) evenCount[digits.charAt(i) - '0']++;
            else oddCount[digits.charAt(i) - '0']++;
        }
        int maxEven = Arrays.stream(evenCount).max().getAsInt();
        int maxOdd = Arrays.stream(oddCount).max().getAsInt();
        if (maxEven > maxOdd) return "чет";
        if (maxOdd > maxEven) return "нечет";
        int firstMaxDigitIndex = Arrays.stream(evenCount).boxed().max(Integer::compare).orElse(0);
        char firstMaxDigit = (char) ('0' + firstMaxDigitIndex);
        int firstOccurrence = digits.indexOf(firstMaxDigit);
        return firstOccurrence % 2 == 0 ? "чет" : "нечет";
    }

    // 8
    public static String labirint(int[][] matrix) {
        int n = matrix.length;
        if (matrix[n - 1][n - 1] < 0 || matrix[0][0] < 0) return "Прохода нет";
        int[][] dp = new int[n][n];
        String[][] path = new String[n][n];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[n - 1][n - 1] = matrix[n - 1][n - 1];
        path[n - 1][n - 1] = String.valueOf(matrix[n - 1][n - 1]);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] >= 0) {
                    if (i < n - 1 && dp[i + 1][j] != Integer.MAX_VALUE) {
                        if (dp[i][j] > dp[i + 1][j] + matrix[i][j]) {
                            dp[i][j] = dp[i + 1][j] + matrix[i][j];
                            path[i][j] = path[i + 1][j] + "-" + matrix[i][j];
                        }
                    }
                    if (j < n - 1 && dp[i][j + 1] != Integer.MAX_VALUE) {
                        if (dp[i][j] > dp[i][j + 1] + matrix[i][j]) {
                            dp[i][j] = dp[i][j + 1] + matrix[i][j];
                            path[i][j] = path[i][j + 1] + "-" + matrix[i][j];
                        }
                    }
                }
            }
        }
        return dp[0][0] == Integer.MAX_VALUE ? "Прохода нет" : "Путь: " + path[0][0] + ", стоимость: " + dp[0][0];
    }

    // 9
    public static String numericOrder(String str) {
        String[] words = str.split(" ");
        String[] result = new String[words.length];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (Character.isDigit(c)) {
                    result[c - '1'] = word.replaceAll("\\d", "");
                    break;
                }
            }
        }
        return String.join(" ", result).trim();
    }

    // 10
    public static boolean fibString(String str) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        List<Integer> counts = new ArrayList<>(countMap.values());
        Collections.sort(counts);
        if (counts.size() < 2) return false;
        for (int i = 2; i < counts.size(); i++) {
            if (counts.get(i) != counts.get(i - 1) + counts.get(i - 2)) {
                return false;
            }
        }
        return true;
    }

    // Главная функция для тестирования всех функций
    public static void main(String[] args) {
        // 1
        System.out.println(nonRepeat("abracadabra")); // Ожидается "abrcd"
        System.out.println(nonRepeat("abababcac"));  // Ожидается "abc"

        // 2
        System.out.println(bruteForce(1, 5)); // Ожидается ["0","1","2","3","4"]
        System.out.println(bruteForce(2, 2)); // Ожидается ["01", "10"]
        System.out.println(bruteForce(5, 3)); // Ожидается []

        // 3
        System.out.println(encode(new int[]{0, 31, 28, 10, 29}, "MKIIT")); // Ожидается "MTUCI"
        System.out.println(Arrays.toString(decode("MTUCI", "MKIIT")));   // Ожидается [0, 31, 28, 10, 29]

        // 4
        System.out.println(split("()()()")); // Ожидается ["()", "()", "()"]
        System.out.println(split("((()))")); // Ожидается ["((()))"]
        System.out.println(split("((()))(())()()(()())")); // Ожидается ["((()))", "(())", "()", "()", "(()())"]

        // 5
        System.out.println(shortHand("abbccc")); // Ожидается "ab*2c*3"
        System.out.println(shortHand("vvvvaajaaaaa")); // Ожидается "v*4a*2ja*5"

        // 6
        System.out.println(convertToRome(8)); // Ожидается "VIII"
        System.out.println(convertToRome(1234)); // Ожидается "MCCXXXIV"
        System.out.println(convertToRome(52)); // Ожидается "LII"

        // 7
        System.out.println(uniqueSubstring("31312131")); // Ожидается "нечет"
        System.out.println(uniqueSubstring("1111111"));  // Ожидается "чет"
        System.out.println(uniqueSubstring("12223234333")); // Ожидается "чет"

        // 8
        System.out.println(labirint(new int[][]{
            {1, 3, 1},
            {1, -1, 1},
            {4, 2, 1}
        })); // Ожидается "Путь: 1-1-1-3-1, стоимость: 7"
        System.out.println(labirint(new int[][]{
            {2, -7, 3},
            {-4, -1, 8},
            {4, 5, 9}
        })); // Ожидается "Прохода нет"

        // 9
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng")); // Ожидается "One ring to rule them all"
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat")); // Ожидается "With great power comes great responsibility"

        // 10
        System.out.println(fibString("CCCABDD")); // Ожидается true
        System.out.println(fibString("ABC"));    // Ожидается false
    }
}

//https://github.com/W4Nd/java