import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

	private Connection connection;
	public Database() throws SQLException {
		String s1 = "jdbc:mysql://35.222.96.220:3306/trading_bot?useSSL=false";
		String s2 = "jdbc:mysql://35.238.103.74:3306/carmax2?useSSL=false";

		
		connection = DriverManager.getConnection(s1,"root","qwerty12345");
		
	}

	//This function gets all the information in the database
	//makes a ListArray of the Stocks and initializes the Portfolio 
	//class with that ListArray
	public void setPortfolio() throws SQLException {
		Statement statement = this.connection.createStatement();
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		ResultSet rs = statement.executeQuery("select * from Portfolio");
		while(rs.next()) {
			Stock s = new Stock(
					rs.getString(1),
					rs.getDouble(2),
					rs.getDouble(3),
					rs.getInt(4),
					rs.getLong(5));
			stocks.add(s);
		}
		
		for(Stock s: stocks) {
			System.out.println(s.getTickerNumber());
		}
		
	}
	
	
	
	//returns a connection that will allow other classes to mutate the 
	//Database by making statements
	public Connection getConnection() {
		return this.connection;
	}
	
	//Will close connection to the Database
	public void closeConnection() throws SQLException {
		this.connection.close();
	}
}