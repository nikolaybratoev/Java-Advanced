package generics.genericcountstringsmethod;

public class Box<T extends Comparable> {
    private T element;

    public Box(T element) {
        this.element = element;
    }

    public T getElement() {
        return this.element;
    }

    @Override
    public String toString() {
        return this.element.getClass().getName() + ": " + this.element;
    }
}
