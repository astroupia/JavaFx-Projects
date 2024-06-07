import java.sql.*;


public class dbcon {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/crowd_funding";
        String username = "root";
        String password = "";
        String query = "SELECT customer_customername FROM customer";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()){
                System.out.println("Cusomter Name: " + result.getString("customer_customername"));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found");
        } catch (SQLException se) {
            System.out.println("Sql Exception");
        }
        
    }
    

}
