import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        StartTests.start(SomeTest.class);
    }
}
