package lab6;

public class Stack<T> {
    private T[] data;
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size < data.length) {
            data[size] = element;
            size++;
        } else {
            throw new IllegalStateException("Stack is full");
        }
    }

    public T pop() {
        if (size > 0) {
            T element = data[size - 1];
            data[size - 1] = null; 
            size--;
            return element;
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public T peek() {
        if (size > 0) {
            return data[size - 1];
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());    // Output: 3
        System.out.println(stack.peek());  // Output: 2
        stack.push(4);
        System.out.println(stack.pop());    // Output: 4
    }
}

