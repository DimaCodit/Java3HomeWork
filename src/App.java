import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Auth.connect();

        // Авторизация

        boolean authResult = Auth.userAuth("login1", "pass1");

        System.out.println(authResult);

        // Смена ника

        boolean changeNickResult = Auth.changeNick("login1", "Dude");


    }

}



