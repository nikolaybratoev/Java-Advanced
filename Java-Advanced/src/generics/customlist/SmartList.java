package generics.customlist;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Consumer;

public class SmartList<T extends Object & Comparable> {
    private static final int INITIAL_CAPACITY = 4;
    private T[] data;
    private int size;

    public SmartList() {
        this.data = (T[])Array.newInstance(Object.class, INITIAL_CAPACITY);
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(T element) {
        if (this.size == this.data.length) {
            reSize();
        }

        this.data[this.size++] = element;
    }

    private void reSize() {
        T[] newData = (T[])Array.newInstance(Object.class,
                this.data.length * 2);
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }

        this.data = newData;
    }

    public T remove(int index) {
        T element = this.data[index];

        this.size--;

        for (int i = index; i < this.size; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.data[this.size] = null;

        return element;
    }

    public boolean contains(T element) {
        for (int i = 0; i < this.size; i++) {

            if (element.equals(this.data[i])) {
                return true;
            }
        }

        return false;
    }

    public void swap(int first, int second) {
        T temp = this.data[first];

        this.data[first] = this.data[second];

        this.data[second] = temp;
    }

    public long countGreaterThan(T element) {
        return Arrays.stream(this.data, 0, this.size)
                .filter(e -> 0 < e.compareTo(element))
                .count();
    }

    public T getMax() {
        return Arrays.stream(this.data, 0, this.size)
                .parallel()
                .max(T::compareTo)
                .orElse(null);
    }

    public T getMin() {
        return Arrays.stream(this.data, 0, this.size)
                .parallel()
                .min(T::compareTo)
                .orElse(null);
    }

    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }
}