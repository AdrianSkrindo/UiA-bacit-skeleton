package modell;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static final Connector INSTANCE = new Connector();
    static Connection connection;

    public static Connector getINSTANCE() {
        return INSTANCE;
    }


    public Connection getConnection(PrintWriter out) throws SQLException, ClassNotFoundException {
        Connection toReturn = null;
        Class.forName("org.mariadb.jdbc.Driver");
        try {
            toReturn = (connection != null)
                    ? connection
                    : DriverManager.getConnection(
                    "jdbc:mariadb://172.17.0.1:3308/amv",
                    "root",
                    "12345");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("SQL Exception " + e);
        }
        return toReturn;
    }
}