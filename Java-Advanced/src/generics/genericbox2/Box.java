package generics.genericbox2;

public class Box<T> {
    private T number;

    public Box(T name) {
        this.number = name;
    }

    @Override
    public String toString() {
        return this.number.getClass().getName() + ": " + this.number;
    }
}
