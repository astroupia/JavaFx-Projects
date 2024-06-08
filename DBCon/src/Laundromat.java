import java.util.Scanner;
import java.sql.*;

public class Laundromat {
    public static void main (String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/laundromat", "root", "");
            System.out.print("Name: ");
            String name = input.nextLine();
            input.nextLine();
            System.out.print("ID: ");
            int id = input.nextInt();
            String sql = "SELECT * FROM customers WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    // Retrieve customer details from ResultSet
                    String customerName = rs.getString("name");
                    int db_id = rs.getInt("id");

                    // Verify if retrieved customer matches the provided name and ID
                    if (customerName.equals(name) && db_id == id) System.out.println("Verified for " + rs.getString("name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }     
    }
}