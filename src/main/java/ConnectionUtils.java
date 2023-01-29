
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static String USER_NAME = "ulka";
    private static String USER_PASSWORD = "123456";
    private  static String URL = "jdbc:mysql://localhost:3306/books" ;

    public static Connection openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//        DriverManager.registerDriver(driver);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Connection succesfull!");
        }
        catch(Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
    }
}
