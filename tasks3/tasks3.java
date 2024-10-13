public class tasks3 {

    // Task 1: Странная пара
    public static boolean isStrangePair(String str1, String str2) {
        if (str1.isEmpty() && str2.isEmpty()) {
            return true;
        }
        return str1.charAt(0) == str2.charAt(str2.length() - 1) && str1.charAt(str1.length() - 1) == str2.charAt(0);
    }

    // Task 2: Скидочные цены
    public static List<Object[]> sale(List<Object[]> items, int discount) {
        List<Object[]> discountedItems = new ArrayList<>();
        for (Object[] item : items) {
            int price = (int) item[1];
            int newPrice = Math.max(1, (int) (price * (1 - discount / 100.0)));
            discountedItems.add(new Object[]{item[0], newPrice});
        }
        return discountedItems;
    }

    // Task 3: Успешный выстрел
    public static boolean successShoot(int x, int y, int r, int m, int n) {
        int dx = m - x;
        int dy = n - y;
        return dx * dx + dy * dy <= r * r;
    }

    // Task 4: Анализ четности
    public static boolean parityAnalysis(int num) {
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return (num % 2 == sum % 2);
    }

    // Task 5: Камень, ножницы, бумага
    public static String rps(String player1, String player2) {
        if (player1.equals(player2)) {
            return "Tie";
        }
        if ((player1.equals("rock") && player2.equals("scissors")) ||
            (player1.equals("paper") && player2.equals("rock")) ||
            (player1.equals("scissors") && player2.equals("paper"))) {
            return "Player 1 wins";
        } else {
            return "Player 2 wins";
        }
    }

    // Task 6: Мультипликативная постоянность
    public static int bugger(int num) {
        int count = 0;
        while (num >= 10) {
            int product = 1;
            while (num > 0) {
                product *= num % 10;
                num /= 10;
            }
            num = product;
            count++;
        }
        return count;
    }

    // Task 7: Самый дорогой инвентарь
    public static String mostExpensive(List<Object[]> inventory) {
        String itemName = "";
        int maxCost = 0;
        for (Object[] item : inventory) {
            int cost = (int) item[1] * (int) item[2];
            if (cost > maxCost) {
                maxCost = cost;
                itemName = (String) item[0];
            }
        }
        return "Наиб. общ. стоимость у предмета " + itemName + " - " + maxCost;
    }

    // Task 8: Самая длинная уникальная подстрока
    public static String longestUnique(String str) {
        String longest = "";
        String current = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = current.indexOf(c);
            if (index != -1) {
                current = current.substring(index + 1);
            }
            current += c;
            if (current.length() > longest.length()) {
                longest = current;
            }
        }
        return longest;
    }

    // Task 9: Префикс и суффикс
    public static boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.substring(0, prefix.length() - 1));
    }

    public static boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.substring(1));
    }

    // Task 10: Поместится ли кирпич
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        int minBrick1 = Math.min(a, Math.min(b, c));
        int minBrick2 = a + b + c - minBrick1 - Math.max(a, Math.max(b, c));
        return (minBrick1 <= w && minBrick2 <= h) || (minBrick1 <= h && minBrick2 <= w);
    }

    public static void main(String[] args) {
        System.out.println(isStrangePair("ratio", "orator"));
      
        List<Object[]> items = new ArrayList<>();
        items.add(new Object[]{"Laptop", 124200});
        items.add(new Object[]{"Phone", 51450});
        System.out.println(sale(items, 25));
      
        System.out.println(successShoot(0, 0, 5, 2, 2));
      
        System.out.println(parityAnalysis(243));
      
        System.out.println(rps("rock", "paper"));
      
        System.out.println(bugger(39));
      
        List<Object[]> inventory = new ArrayList<>();
        inventory.add(new Object[]{"Скакалка", 550, 8});
        inventory.add(new Object[]{"Шлем", 3750, 4});
        System.out.println(mostExpensive(inventory));
      
        System.out.println(longestUnique("abcba"));
      
        System.out.println(isPrefix("automation", "auto-"));
      
        System.out.println(isSuffix("arachnophobia", "-phobia"));
      
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));
    }
}

// github - https://github.com/W4Nd/java