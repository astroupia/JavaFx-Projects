import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        String sql = "select customername from customer where customer_id = 2";
        String url = "jdbc:mysql//localhost:3306/crowd_funding";
        String username = "root";
        String password = "";

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);
    }
}
