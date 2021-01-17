import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits = new ArrayList<>();

    public Float getWeigh() {
        if (fruits.size() != 0) {
            return  fruits.get(0).getPieceWeight() * fruits.size();
        }
        else {
            return 0.0f;
        }
    }

    public boolean compare(Box inBox) {
        return this.getWeigh().compareTo(inBox.getWeigh()) == 0;
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }

    public void moveContent(Box<T> toBox) {
        for (T fruit : fruits) {
            toBox.addFruit(fruit);
        }
        fruits.clear();
    }
}
