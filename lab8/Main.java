package lab8;

public class Main {
    public static void main(String[] args) throws Exception {
        // Создаем экземпляры обработчиков данных
        FilterDataProcessor filterProcessor = new FilterDataProcessor();
        TransformDataProcessor transformProcessor = new TransformDataProcessor();
        AggregateDataProcessor aggregateProcessor = new AggregateDataProcessor();

        // Создаем экземпляр DataManager
        DataManager dataManager = new DataManager();

        // Регистрируем обработчики данных
        dataManager.registerDataProcessor(filterProcessor);
        dataManager.registerDataProcessor(transformProcessor);
        dataManager.registerDataProcessor(aggregateProcessor);

        // Загружаем исходные данные
        String sourceData = "apple,banana,cherry,date,elderberry";
        dataManager.loadData(sourceData);

        // Обрабатываем данные с использованием многозадачности
        dataManager.processData();

        // Сохраняем обработанные данные
        dataManager.saveData("output.txt");
    }
}


