import java.lang.reflect.Method;
import java.util.Objects;

public class PriorityMethod implements Comparable<PriorityMethod> {

    private Method method;
    private int priority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriorityMethod that = (PriorityMethod) o;
        return priority == that.priority;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(priority);
    }

    public Method getMethod() {
        return method;
    }

    public PriorityMethod(Method method, int priority) {
        this.method = method;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }


    @Override
    public int compareTo(PriorityMethod o) {
        if (priority>o.priority) {
            return 1;
        }
        else if (priority == o.priority) {
            return 0;
        }
        else {
            return -1;
        }
    }
}
