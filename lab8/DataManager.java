package lab8;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.lang.reflect.Method;

public class DataManager {
    private List<Object> dataProcessors = new ArrayList<>(); // Список объектов-обработчиков данных
    private List<String> data = new ArrayList<>(); // Список данных для обработки

    // Регистрируем объект-обработчик данных
    public void registerDataProcessor(Object processor) {
        dataProcessors.add(processor);
    }

    // Загружаем данные из источника из строки, разделенной запятыми
    public void loadData(String source) {
        this.data = Arrays.asList(source.split(",")); // Разделяем строку на элементы
        System.out.println("Data loaded: " + data); // Выводим загруженные данные
    }

    // Обрабатываем данные с использованием методов с аннотацией @DataProcessor
    public void processData() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3); // Создаем пул потоков с 3 потоками

        // Перебираем зарегистрированные обработчики
        for (Object processor : dataProcessors) {
            // Перебираем методы каждого обработчика
            for (Method method : processor.getClass().getMethods()) {
                // Проверяем, помечен ли метод аннотацией @DataProcessor
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    // Передаем задачу на выполнение в отдельный поток
                    executorService.submit(() -> {
                        try {
                            // Вызываем метод с аннотацией, передавая данные
                            method.invoke(processor, data);
                        } catch (Exception e) {
                            e.printStackTrace(); // Обрабатываем возможные ошибки
                        }
                    });
                }
            }
        }

        executorService.shutdown(); // Завершаем выполнение потоков
        executorService.awaitTermination(10, TimeUnit.SECONDS); // Ждем завершения задач (максимум 10 секунд)
    }

    // Сохраняем обработанные данные (в данном случае просто выводим их)
    public void saveData(String destination) {
        System.out.println("Saving data to " + destination + ": " + data);
    }
}
