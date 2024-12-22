package lab8;

import java.util.List;
import java.util.stream.Collectors;

public class TransformDataProcessor {
    // Метод для преобразования данных, помеченный аннотацией @DataProcessor
    @DataProcessor(description = "Transform data to uppercase")
    public void transformData(List<String> data) {
        // Преобразуем строки в верхний регистр
        List<String> transformedData = data.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Transformed Data: " + transformedData);
    }
}
