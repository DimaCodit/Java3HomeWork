import java.sql.*;

public class Auth {
    private static Connection connection;
    private static Statement statement;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean userAuth(String login, String password) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT login FROM users WHERE login ='" + login + "'" + "AND password = '" + password + "'");
        return rs.next();
    }

    public static boolean changeNick(String login, String newNickname)   {
        try {
            statement.executeUpdate("UPDATE users SET nickname = '"+ newNickname +"' WHERE login ='" + login + "'");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

}
