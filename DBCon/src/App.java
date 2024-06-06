import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        String sql = "SELECT customer_customername FROM customer";
        String url = "jdbc:mysql://localhost:3306/crowd_funding";
        String username = "root";
        String password = "";

        Connection conn = DriverManager.getConnection(url, username, password);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        result.next();
        result.getString(1);
        System.out.println(result);
    }
}
