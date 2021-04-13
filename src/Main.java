import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		Database db = new Database();
		
		Members m = db.setUsers();
		User u = new User(System.currentTimeMillis(),"Abby","Gomez","12345","abby@yahoo.com");
		m.addUser(u);
		
		m.showUsers();
		
		db.closeConnection();
		
		
	}

}
