import java.sql.Connection;
import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		Database db = new Database();
		Portfolio portfolio = db.setPortfolio();
		
		
		
		portfolio.showPortofolio();
		
		db.closeConnection();
		
		
	}

}
