package lab8;

import java.util.List;
import java.util.stream.Collectors;

public class AggregateDataProcessor {
    // Метод для агрегации данных, помеченный аннотацией @DataProcessor
    @DataProcessor(description = "Aggregate data into a single string")
    public void aggregateData(List<String> data) {
        // Объединяем все элементы в одну строку, разделяя их запятыми
        String aggregatedData = data.stream()
            .collect(Collectors.joining(", "));
        System.out.println("Aggregated Data: " + aggregatedData);
    }
}
