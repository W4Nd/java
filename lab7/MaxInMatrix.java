package lab7;

public class MaxInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {9, 5, 6},
            {7, 8, 4}
        };

        MaxThread[] threads = new MaxThread[matrix.length];
        Thread[] threadObjects = new Thread[matrix.length];
        int[] maxValues = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            threads[i] = new MaxThread(matrix[i]);
            threadObjects[i] = new Thread(threads[i]);
            threadObjects[i].start();
        }

        try {
            for (Thread t : threadObjects) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < threads.length; i++) {
            maxValues[i] = threads[i].getMax();
        }

        int globalMax = maxValues[0];
        for (int max : maxValues) {
            if (max > globalMax) {
                globalMax = max;
            }
        }

        System.out.println("Global Max: " + globalMax);
    }
}

class MaxThread implements Runnable {
    private int[] row;
    private int max;

    public MaxThread(int[] row) {
        this.row = row;
    }

    @Override
    public void run() {
        max = row[0];
        for (int value : row) {
            if (value > max) {
                max = value;
            }
        }
    }

    public int getMax() {
        return max;
    }
}
