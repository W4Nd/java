package lab7;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    public static void main(String[] args) {
        List<Item> items = List.of(
            new Item("Box1", 50),
            new Item("Box2", 30),
            new Item("Box3", 40),
            new Item("Box4", 20),
            new Item("Box5", 10)
        );

        Loader loader1 = new Loader(items, "Loader 1");
        Loader loader2 = new Loader(items, "Loader 2");
        Loader loader3 = new Loader(items, "Loader 3");

        Thread t1 = new Thread(loader1);
        Thread t2 = new Thread(loader2);
        Thread t3 = new Thread(loader3);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Item {
    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}

class Loader implements Runnable {
    private static final int MAX_WEIGHT = 150;
    private List<Item> items;
    private String name;

    public Loader(List<Item> items, String name) {
        this.items = items;
        this.name = name;
    }

    @Override
    public void run() {
        int currentWeight = 0;
        List<Item> load = new ArrayList<>();

        synchronized (items) {
            for (Item item : items) {
                if (currentWeight + item.getWeight() <= MAX_WEIGHT) {
                    load.add(item);
                    currentWeight += item.getWeight();
                } else {
                    break;
                }
            }
            items.removeAll(load);
        }

        System.out.println(name + " is moving items: " + load.stream()
            .map(Item::getName)
            .toList());
    }
}
