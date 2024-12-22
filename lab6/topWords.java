package lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class topWords {
    public static void main(String[] args) {
        String filePath = "D:\\java\\lab6\\text.txt";

        File file = new File(filePath);
        
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        
        Map<String, Integer> wordCountMap = new HashMap<>();

        
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase(); 
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        
        scanner.close();

        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());

        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        
        int topN = 10;
        System.out.println("Топ-10 самых часто встречающихся слов:");
        for (int i = 0; i < Math.min(topN, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

