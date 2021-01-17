import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        Integer[] intArr = {1,2,3,4,5,6};
        swapElements(intArr, 1,2);

        for (Integer i : intArr) {
            System.out.println(i);
        }

        ArrayList test = arrayToArrayList(intArr);
        System.out.println(test);

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());

        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());

        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        orangeBox1.addFruit(new Orange());
        orangeBox1.addFruit(new Orange());

        orangeBox2.addFruit(new Orange());
        orangeBox2.addFruit(new Orange());
        orangeBox2.addFruit(new Orange());

        System.out.println(appleBox1.compare(orangeBox1));

        orangeBox1.moveContent(orangeBox2);

        System.out.println(orangeBox1);
        System.out.println(orangeBox2);

    }

    public static <E> void swapElements(E[] arrayForSwap, int index1, int index2 ) {
        E temp = arrayForSwap[index1];
        arrayForSwap[index1] = arrayForSwap[index2];
        arrayForSwap[index2] = temp;
    }

    public static <E> ArrayList<E> arrayToArrayList(E[] array) {
        ArrayList <E> arrayList = new ArrayList<>();
        for (E element : array) {
            arrayList.add(element);
        }
        return arrayList;
    }
}
