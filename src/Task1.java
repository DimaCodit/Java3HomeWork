public class Task1 {
    static String a = "A";

    public static void main(String[] args) {
        Object lock = new Object();
        class MyClass implements Runnable {
            private String b;
            private String nextB;

            public MyClass(String b, String nextB) {
                this.b = b;
                this.nextB = nextB;
            }

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (lock) {
                        try {
                            while (!a.equals(b))
                                lock.wait();
                            System.out.println(b);
                            a = nextB;
                            Thread.sleep(1);
                            lock.notifyAll();
                        } catch (Exception e) {

                        }
                    }
                }
            }
        }

        new Thread(new MyClass("A", "B")).start();
        new Thread(new MyClass("B", "C")).start();
        new Thread(new MyClass("C", "D")).start();
        new Thread(new MyClass("D", "E")).start();
        new Thread(new MyClass("E", "A")).start();

    }
}