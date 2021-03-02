import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class StartTests {

    private static Method beforeMethod = null;
    private static Method afterMethod = null;

    private static ArrayList<Method> afterMethods = new ArrayList<>();
    private static ArrayList<Method> beforeMethods = new ArrayList<>();

    private static List <PriorityMethod> testMethods = new ArrayList<>();

    public static void getMethods(Class testingClass) {

        Method[] allMethods = testingClass.getMethods();

        for (Method method : allMethods) {
            if (method.getAnnotation(BeforeSuit.class) != null) {
                beforeMethods.add(method);
            }
            if (method.getAnnotation(AfterSuit.class) != null) {
                afterMethods.add(method);
            }
            if (method.getAnnotation(Test.class) != null) {
                Test annotation = method.getAnnotation(Test.class);
                testMethods.add(new PriorityMethod(method, annotation.priority()));
            }
        }

        if (beforeMethods.size() > 1) {
            throw new RuntimeException("More than one method defined with annotation BeforeSuit");
        }
        if (afterMethods.size() > 1) {
            throw new RuntimeException("More than one method defined with annotation AfterSuit");
        }

        if (beforeMethods.size() == 1) {
            beforeMethod = beforeMethods.get(0);
        }
        if (afterMethods.size() == 1) {
            afterMethod = afterMethods.get(0);
        }
    }

    public static void start(Class<? extends Testable> testingClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        getMethods(testingClass);

        Testable test = (Testable) testingClass.newInstance();

        if (beforeMethod != null) {
            beforeMethod.invoke(test);
        }

        Collections.sort(testMethods);

        for (PriorityMethod m:testMethods) {
            m.getMethod().invoke(test);
        }

        if (afterMethod != null) {
            afterMethod.invoke(test);
        }


    }
}
