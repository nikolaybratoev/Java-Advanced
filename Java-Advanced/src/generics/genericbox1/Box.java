package generics.genericbox1;

public class Box<T> {
    private T name;

    public Box(T name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.getClass().getName() + ": " + this.name;
    }
}
