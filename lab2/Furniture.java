abstract class Furniture {
    private float len;
    private float width;
    private int price;

    public Furniture(float len, float width, int price) {
        this.len = len;
        this.width = width;
        this.price = price;
    }
    public Furniture() {
        this.len = 5.0f;
        this.width = 2.0f;
        this.price = 3000;
    }
    public void getPrice() {
        System.out.println("Цена объекта: " + price);
    }
    public void getSquare() {
        System.out.println("Площадь объекта: " + len * width);
    }
    @Override
    public String toString() {
        return "Был создан новый объект: тип - " + getClass().getName() + ", длина - " + len + ", ширина - " + width + ", цена - " + price;
    }
    abstract void objectInfo();
}

class Table extends Furniture {
    private float height;
    public Table(float len, float width, int price, float height) {
        super(len, width, price);
        this.height = height;
    }
    public void getHeight() {
        System.out.println("Высота объекта: " + height);
    }
    void objectInfo() {
        System.out.println(toString());
    }
}

class Chair extends Furniture {
    void objectInfo() {
        System.out.println(toString());
    }
    public void Convenience() {
        System.out.println("Супер удобный стульчик");
    }
}

class Bed extends Chair {
    private static int objectCount = 0;
    @Override
    public void Convenience() {
        System.out.println("Супер удобная кроватка");
    }
    public Bed() {
        objectCount++;
    }
    
    public static int getObjectCount() {
        return objectCount;
    }
}

class Main {
    public static void main(String[] args) {
        Furniture table = new Table(3.5f, 2.0f, 5000, 1.2f);
        Chair chair = new Chair();
        Bed bed = new Bed();
        Bed bed2 = new Bed();

        table.getSquare();
        table.objectInfo();
        System.out.println();

        chair.Convenience();
        chair.objectInfo();
        System.out.println();

        bed.objectInfo();
        bed.Convenience();
        System.out.println(Bed.getObjectCount());
    }
}
