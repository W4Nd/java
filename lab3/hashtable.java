package lab3;
import java.util.LinkedList;

class HashTable<K, V> {
    private class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) return null;

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] == null) return;

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                table[index].remove(entry);
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        // Добавляем элементы
        hashTable.put("apple", 5);
        hashTable.put("banana", 3);
        hashTable.put("orange", 7);

        // Получаем элементы
        System.out.println("Значение по ключу 'apple': " + hashTable.get("apple"));

        // Удаляем элемент
        hashTable.remove("banana");

        // Проверяем, существует ли элемент
        System.out.println("Значение по ключу 'banana': " + hashTable.get("banana"));

        // Размер таблицы
        System.out.println("Размер таблицы: " + hashTable.size());

        // Проверка, пуста ли таблица
        System.out.println("Пуста ли таблица? " + hashTable.isEmpty());
    }
}