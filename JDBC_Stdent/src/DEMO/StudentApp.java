package DEMO;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

	public class StudentApp {

	    public static void main(String[] args) {

	        String url = "jdbc:mysql://localhost:3306/college";
	        String username = "root";
	        String password = "admin@123";

	        try {

	            // Connect to database
	            Connection con =
	                    DriverManager.getConnection(
	                            url,
	                            username,
	                            password
	                    );

	            // Create statement
	            Statement stmt =
	                    con.createStatement();

	            // SQL query
	            String sql =
	                    "SELECT * FROM student";

	            // Execute query
	            ResultSet rs =
	                    stmt.executeQuery(sql);

	            // Read data
	            while (rs.next()) {

	                int id =
	                        rs.getInt("id");

	                String name =
	                        rs.getString("name");

	                int age =
	                        rs.getInt("age");

	                String email =
	                        rs.getString("email");

	                System.out.println(
	                        id + " " +
	                        name + " " +
	                        age + " " +
	                        email
	                );
	            }

	            // Close connection
	            con.close();

	        } catch (Exception e) {

	            e.printStackTrace();
	        }
	    }
	}
