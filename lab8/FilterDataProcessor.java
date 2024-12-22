package lab8;

import java.util.List;
import java.util.stream.Collectors;

public class FilterDataProcessor {
    // Метод для фильтрации данных, помеченный аннотацией @DataProcessor
    @DataProcessor(description = "Filter data with length greater than 3")
    public void filterData(List<String> data) {
        // Фильтруем данные: оставляем элементы длиной больше 3
        List<String> filteredData = data.stream()
            .filter(item -> item.length() > 3)
            .collect(Collectors.toList());
        System.out.println("Filtered Data: " + filteredData);
    }
}
