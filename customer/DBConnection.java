package customer;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
public static Connection getConnection() throws ClassNotFoundException,SQLException
{
Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Telecom","root","welcome");
return c;
}
}
