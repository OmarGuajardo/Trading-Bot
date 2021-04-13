import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

	private static Connection connection;

	public Database() throws SQLException {
		String s1 = "jdbc:mysql://35.222.96.220:3306/trading_bot?useSSL=false";
		connection = DriverManager.getConnection(s1,"root","qwerty12345");
		
	}

	
	//Pulls all the Users information stored in the database locally
	public Members fetchMembers() throws SQLException {
		Statement statement = connection.createStatement();
		ArrayList<User> users = new ArrayList<User>();
		ResultSet rs = statement.executeQuery("select * from Users");
		
		while(rs.next()) {
			User u = new User(
					rs.getLong(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5));
			users.add(u);
		}
		Members m = new Members(users);
		return m;
		
	}
	
	//This function gets all the information in the database
	//makes a ListArray of the Stocks and initializes the Portfolio 
	//class with that ListArray
	public Portfolio fetchPortfolio(User u) throws SQLException {
		Statement statement = this.connection.createStatement();
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		ResultSet rs = statement.executeQuery("select * from Stock where user_id="+u.getUserId()+";");
		while(rs.next()) {
			Stock s = new Stock(
					rs.getString(2),
					rs.getDouble(3),
					rs.getDouble(4),
					rs.getInt(5),
					rs.getLong(1));
			stocks.add(s);
		}
		Portfolio p = new Portfolio(stocks);
		return p;
		
	}
	
	
	public static void addStockDB(Stock s) throws SQLException {
		
		String statement = ("INSERT INTO Portfolio VALUES ("+"'"+
									s.getTickerNumber()+"',"+
									s.getCurrentPrice()+","+
									s.getPriceOfPurchase()+","+
									s.getShares()+","+
									s.getID()+");");
		PreparedStatement preparedStatement = connection.prepareStatement(statement);
		preparedStatement.executeUpdate();
	}
	
	public static void removeStockDB(long row_id) throws SQLException {
		
		String statement = ("DELETE FROM Portfolio WHERE row_id="+row_id+";");
		PreparedStatement preparedStatement = connection.prepareStatement(statement);
		preparedStatement.executeUpdate();
	}
	
	public static void addUserDB(User u) throws SQLException {
			
			String statement = ("INSERT INTO Users VALUES ("+
										"'"+ u.getUserId()+"',"+
										"'"+u.getFirstName()+"',"+
										"'"+u.getLastName()+"',"+
										"'"+u.getPassword()+"',"+
										"'"+u.getEmail()+"');");
			PreparedStatement preparedStatement = connection.prepareStatement(statement);
			preparedStatement.executeUpdate();
		}
	
	
	
	//Will close connection to the Database
	public void closeConnection() throws SQLException {
		connection.close();
	}
}
