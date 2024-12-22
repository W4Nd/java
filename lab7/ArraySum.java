package lab7;

public class ArraySum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int mid = array.length / 2;

        SumThread firstHalf = new SumThread(array, 0, mid);
        SumThread secondHalf = new SumThread(array, mid, array.length);

        Thread t1 = new Thread(firstHalf);
        Thread t2 = new Thread(secondHalf);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalSum = firstHalf.getSum() + secondHalf.getSum();
        System.out.println("Total Sum: " + totalSum);
    }
}

class SumThread implements Runnable {
    private int[] array;
    private int start, end, sum;

    public SumThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
    }

    public int getSum() {
        return sum;
    }
}
