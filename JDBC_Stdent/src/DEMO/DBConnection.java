package DEMO;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/college";
		String username="root";
		String password="admin@123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					url,
					username,
					password
					);
			System.out.println("database connected ");
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}