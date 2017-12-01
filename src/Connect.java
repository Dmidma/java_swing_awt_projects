
import java.sql.*;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
public class Connect {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/sakila";
		String userName = "root";
		String password = "R00t4dm1dm5";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected");
			
			String query  = "SELECT * FROM actor";
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			// printing query result
			System.out.println("Query result:");
			ResultSetMetaData md = rs.getMetaData();
			for (int i = 1; i <= md.getColumnCount(); i++) {
				System.out.print(md.getColumnName(i) + "|");
			}
			System.out.println();
			while (rs.next()) {
				System.out.print(
						rs.getString(1) + 
						"|" + 
						rs.getString(2) + 
						"|" + 
						rs.getString(3) + 
						"|" + 
						rs.getString(4));
				System.out.println();
			}
			
		} catch (Exception e) {
			System.err.println(e.toString());
			System.err.println("Cannot connect to server");
			System.exit(1);
		}
		
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Disconnected");
			} catch (Exception e) {
				
			}
		}
	}
}
