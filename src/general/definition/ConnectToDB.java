package general.definition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectToDB {
	
	
	
	private Connection conn = null;
	
	// database url, username and password
	private String url = null;
	private String userName = null;
	private String password = null;
	
	
	
	
	public ConnectToDB(String url, String userNam, String password) {
		
		this.url = url;
		this.userName = userNam;
		this.password =  password;
		
		connectDB(url, userName, password);
		
	}
	
	/**
	 * This private method will connect to the database with the given url
	 * userName and password.
	 * It will catch any possible exception.
	 * @param url
	 * @param userName
	 * @param password
	 */
	private void connectDB(String url, String userName, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected");
		} catch (Exception e) {
			System.err.println(e.toString());
			System.err.println("Cannot connect to server");
			System.exit(1);
		}
	}
	
	
	/**
	 * This method will execute a given query to the connected 
	 * data base.
	 * It will catch any exception. 
	 * @param query the string that holds the query.
	 * @return the result set after the execution of the query.
	 */
	public ResultSet executeQuery(String query) {
		
		// initialize the result set 
		ResultSet rs = null;
		
		try {
		// prepare the statement
		Statement st = conn.createStatement();
		
		rs= st.executeQuery(query);
		
		// close statement
		st.close();
		
		} catch (Exception e) {
			System.err.println(e.toString());
			System.err.println("Cannot execute query");
			System.exit(1);
		}
		
		// return the result set
		return rs;
	}
	
	
	/**
	 * This method will close the connection of the current database.
	 */
	public void disconnect() {
		
		// if we are connected to a database
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Disconnected");
			} catch (Exception e) {
				
			}
		}
	}
	
	
	/**
	 * Getter for the URL.
	 * @return the url of the data base.
	 */
	public String getUrl() {
		return this.url;
	}
	
	
	/**
	 * Getter for the userName
	 * @return the user name of the data base.
	 */
	public String getUserName() {
		return this.userName;
	}
	
	
	/**
	 * Getter for the password.
	 * @return the password of the data base.
	 */
	public String getPassword() {
		return this.password;
	}
}
