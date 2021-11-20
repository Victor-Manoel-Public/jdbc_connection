package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    private static String url = "<postgresql_database_url_goes_here>";
    private static String username = "<postgresql_database_user_goes_here>";
    private static String password = "<postgresql_database_password_goes_here>";
    private static Connection connection = null;

    public Connect(){
        connect();
    }

    public Connection getConnection(){
        return connection;
    }

    public static void connect(){
        try{
            if(connection == null){
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(false);
                System.out.println("DB connected successfully.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
