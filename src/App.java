import java.sql.SQLException;

public class App {
    public static synchronized void printLetter(char letter) {
        System.out.println(letter);
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Thread printA = new Thread(new Runnable(){
            @Override
            public void run() {
                printLetter('A');
            }
        });

        Thread printB = new Thread(new Runnable(){
            @Override
            public void run() {
                printLetter('B');
            }
        });

        Thread printC = new Thread(new Runnable(){
            @Override
            public void run() {
                printLetter('C');
            }
        });

        printA.start();
        printB.start();
        printC.start();

    }

}



